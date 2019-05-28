package me.codeminions.factory.bean.db;

import java.sql.Timestamp;

public class Account {
    private Long id;
    private Timestamp registerDate;
    private String pwd;

    public Account(Long id, String pwd, Timestamp registerDate) {
        this.id = id;
        this.registerDate = registerDate;
        this.pwd = pwd;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
