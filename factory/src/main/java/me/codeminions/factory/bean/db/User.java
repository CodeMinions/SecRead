package me.codeminions.factory.bean.db;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import me.codeminions.factory.bean.myenum.SexEnum;

public class User implements Serializable {
    @Expose
    private Long id;
    @Expose
    private String name;

    @Expose
    private String signature;

    @Expose
    private String portrait;

    @Expose
    private SexEnum sex;

    @Expose
    private int praise;

    private Account account;

    private List<UserMessage> msgList = null;

    private List<Fans> fansList = null;

    private List<UserTag> userTagList = null;

    private List<UserArticle> userArticlesList = null;

    public User() {
    }

    public User(Long id, String name, String signature){
        this.id = id;
        this.name = name;
        this.signature = signature;
    }

    public User(String name, String signature){
        this.name = name;
        this.signature = signature;
    }

    public User(Long id, String name, int sex, String pwd, Timestamp date) {
        this.id = id;
        this.name = name;
        this.sex = SexEnum.getSex(sex);
        this.account = new Account(id, pwd, date);
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

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<UserMessage> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<UserMessage> msgList) {
        this.msgList = msgList;
    }

    public List<Fans> getFansList() {
        return fansList;
    }

    public void setFansList(List<Fans> fansList) {
        this.fansList = fansList;
    }

    public List<UserTag> getUserTagList() {
        return userTagList;
    }

    public void setUserTagList(List<UserTag> userTagList) {
        this.userTagList = userTagList;
    }

    public List<UserArticle> getUserArticlesList() {
        return userArticlesList;
    }

    public void setUserArticlesList(List<UserArticle> userArticlesList) {
        this.userArticlesList = userArticlesList;
    }
}

