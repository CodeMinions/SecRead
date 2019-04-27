package me.codeminions.secread.bean;

public class User {
    private String user_name;
    private String user_signature;

    public User(){
        this(null, null);
    }

    public User(String user_name, String user_signature) {

        this.user_name = user_name;
        this.user_signature = user_signature;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_signature() {
        return user_signature;
    }

    public void setUser_signature(String user_signature) {
        this.user_signature = user_signature;
    }
}
