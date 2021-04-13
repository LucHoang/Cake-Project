package com.cakemanager.model;

import java.util.Date;

public class Blog {
    private int blogId;
    private String tittle;
    private String descriptionShort;
    private String content;
    private Date datePost;
    private int blogCateId;

    public Blog() {

    }

    public Blog(int blogId, String tittle, String descriptionShort, String content, Date datePost, int blogCateId) {
        this.blogId = blogId;
        this.tittle = tittle;
        this.descriptionShort = descriptionShort;
        this.content = content;
        this.datePost = datePost;
        this.blogCateId = blogCateId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public int getBlogCateId() {
        return blogCateId;
    }

    public void setBlogCateId(int blogCateId) {
        this.blogCateId = blogCateId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", tittle='" + tittle + '\'' +
                ", descriptionShort='" + descriptionShort + '\'' +
                ", content='" + content + '\'' +
                ", datePost=" + datePost +
                ", blogCateId=" + blogCateId +
                '}';
    }
}
