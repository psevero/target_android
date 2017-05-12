package com.curso.target.aula5;

/**
 * Created by sala01 on 12/05/2017.
 */

public class Item {
    int  avatarID, imgID;
    String name, title, likes;

    public Item(int avatarID, int imgID, String name, String title, String likes) {
        this.avatarID = avatarID;
        this.imgID = imgID;
        this.name = name;
        this.title = title;
        this.likes = likes;
    }

    public int getAvatarID() {
        return avatarID;
    }

    public void setAvatarID(int avatarID) {
        this.avatarID = avatarID;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
