package me.codeminions.secread.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.geek.thread.GeekThreadManager;
import com.geek.thread.ThreadPriority;
import com.geek.thread.ThreadType;
import com.geek.thread.task.GeekRunnable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;

import me.codeminions.common.app.Application;
import me.codeminions.common.tools.Constant;
import me.codeminions.factory.bean.api.account.LoginModel;
import me.codeminions.factory.bean.api.base.ResponseModel;
import me.codeminions.factory.bean.db.User;
import me.codeminions.secread.R;
import me.codeminions.secread.net.HttpUtil;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private final int isSuccess = 102;
    private final int isFail = 103;
    private final int notLogout = 104;
    
    private boolean isPwdVisible = false;

    private Gson gson = new Gson();
    private User user = null;
    private Handler handler = new MyHandler(this);

    String userId = null;
    String pwd = null;

    EditText edit_user;
    EditText edit_pwd;
    ImageView btn_visible;

    Button btn_login;
    Button btn_cancel;

    public static void startAction(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initWidget();
    }

    void initWidget() {
        edit_user = findViewById(R.id.edit_login_userId);
        edit_pwd = findViewById(R.id.edit_login_pwd);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        btn_cancel = findViewById(R.id.btn_register);
        btn_cancel.setOnClickListener(this);

        btn_visible = findViewById(R.id.btn_log_visible);
        btn_visible.setOnClickListener(this);
    }

    /**
     * 提交登录申请
     */
    void commitLogin() {
        if (userId.isEmpty() || pwd.isEmpty())
            return;

        GeekThreadManager.getInstance().execute(new GeekRunnable(ThreadPriority.LOW) {
            @Override
            public void run() {

                HttpUtil.sendHttpRequest(Constant.URL_BASE + Constant.URL_LOGIN,
                        RequestBody.create(MediaType.parse("application/json"),
                                gson.toJson(new LoginModel(Long.valueOf(userId), pwd))),
                        new HttpUtil.MyCallback() {
                            Message msg = new Message();

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                if (response.isSuccessful()) {
                                    String content = response.body().string();
                                    Log.i("okhttp", "发送成功\n" + content);

                                    Type type = new TypeToken<ResponseModel<User>>() {
                                    }.getType();
                                    ResponseModel result = gson.fromJson(content, type);

                                    if (result.getMessage().equals("ok")) {
                                        user = (User) result.getResult();

                                        msg.what = isSuccess;
                                        handler.sendMessage(msg);
                                    } else {
                                        msg.what = notLogout;
                                        msg.obj = result.getMessage();
                                        handler.sendMessage(msg);
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call call, IOException e) {
                                msg.what = isFail;
                                handler.sendMessage(msg);
                            }
                        });
            }
        }, ThreadType.NORMAL_THREAD);
    }

    public static class MyHandler extends Handler {
        private WeakReference<LoginActivity> reference;

        MyHandler(LoginActivity activity) {
            reference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (reference.get() != null) {
                LoginActivity activity = reference.get();
                switch (msg.what) {
                    case 102:
                        // 登陆成功
                        Application.setCurrentUser(activity.user);
                        Toast.makeText(activity, "登陆成功", Toast.LENGTH_SHORT).show();
                        activity.finish();
                        break;
                    case 103:
                        // 访问服务器失败
                        Toast.makeText(activity, "访问服务器失败", Toast.LENGTH_SHORT).show();
                        break;
                    case 104:
                        //  登录信息错误，登录失败
                        String message = (String) msg.obj;
                        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                userId = edit_user.getText().toString();
                pwd = edit_pwd.getText().toString();
                Toast.makeText(this, "发送信息", Toast.LENGTH_SHORT).show();
                commitLogin();
                break;
            case R.id.btn_register:
                break;
            case R.id.btn_log_visible:
                if(!isPwdVisible) {
                    btn_visible.setSelected(true);
                    isPwdVisible = true;
                    //密码可见
                    edit_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    btn_visible.setSelected(false);
                    isPwdVisible = false;
                    //密码不可见
                    edit_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;

        }
    }
}
