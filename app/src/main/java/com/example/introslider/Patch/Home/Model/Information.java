package com.example.introslider.Patch.Home.Model;

public class Information {
   private String Content;
   private String Name ;
   private String Url;

    public Information() {
    }

    public Information(String content, String name, String url) {
        Content = content;
        Name = name;
        Url = url;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
