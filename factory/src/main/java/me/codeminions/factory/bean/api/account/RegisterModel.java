package me.codeminions.factory.bean.api.account;

public class RegisterModel {
    private Long id;
    private String name;
    private int sex;
    private String password;

    private String signature;
    private String portrait;

    public static boolean check(RegisterModel model){
        return model != null
                && !model.getId().toString().isEmpty()
                && !model.getName().isEmpty()
                && (model.getSex() == 0 || model.getSex() == 1)
                && model.getPassword().isEmpty();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
}
