/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycomany.entities;

import java.util.Date;

/**
 *
 * @author sis14
 */
public class post {

    public static void add(post re) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private int id;
    private String title;
    private String slug;
    private String summary;
    private String content;
    private String publishedAt;

    public post() {
    }

    public post(String title, String slug, String summary, int id) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.summary = summary;
        this.content = content;
        this.publishedAt = publishedAt;
    }

    public post(int id1, String title, String slug, String summary, String content) {
        this.title = title;
        this.slug = slug;
        this.summary = summary;
        this.content = content;
        this.publishedAt = publishedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    @Override
    public String toString() {
        return "post{" + "title=" + title + ", slug=" + slug + ", summary=" + summary + ", content=" + content + ", publishedAt=" + publishedAt + '}';
    }
    
}
