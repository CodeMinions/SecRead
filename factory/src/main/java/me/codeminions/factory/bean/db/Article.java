package me.codeminions.factory.bean.db;

import java.sql.Date;
import java.util.List;

import me.codeminions.factory.bean.myenum.CopyrightLevelEnum;


public class Article {
    private Long id;
    private Date date;
    private int length;
    private String title;
    private CopyrightLevelEnum copyrightLevel;
    private String content;

    List<ArticleTag> articleTagList = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CopyrightLevelEnum getcopyrightLevel() {
        return copyrightLevel;
    }

    public void setcopyrightLevel(CopyrightLevelEnum copyrightLevel) {
        this.copyrightLevel = copyrightLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
