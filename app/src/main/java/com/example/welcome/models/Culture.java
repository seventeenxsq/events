package com.example.welcome.models;

import android.media.Image;

public class Culture {

    private String Title;

    private int Image;

    public Culture(String title, int image, String content, String URL) {
        Title = title;
        Image = image;
        Content = content;
        this.URL = URL;
    }

    private String Content;

    private String URL;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
       Content = content;
    }


}
