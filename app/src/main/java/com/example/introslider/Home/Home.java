package com.example.introslider.Home;

public class Home {
    private String title;
    private int Image;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Home() {
    }

    public Home(String title, String date,int image) {
        this.title = title;
        // this.Category = category;
        // this.Description = description;
        this.Image = image;
         this.date=date;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }


    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
