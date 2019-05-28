package me.codeminions.factory.bean.db;

import java.sql.Date;

public class Fans {
    private Long userId;
    private User fansUser;

    private Date time;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getFansUser() {
        return fansUser;
    }

    public void setFansUser(User fansUser) {
        this.fansUser = fansUser;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
