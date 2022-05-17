package com.example.simplenewsapp;

public class Ipsum {
    static String[] headlines = {
            "Ukraine crisis: How to help people affected by Russia invasion",
            "Chelsea squad was not prepared for Abramovich sale announcement, admits Kante"};

    static String[] article = {
            "Amid the horrendous scenes in Eastern Europe, many people are asking how they can assist those in peril - here's how\n\n" + "Following the invasion of Ukraine by Russia in recent weeks, millions of people have been put in danger, and require aid and assistance in order to survive.",
            "N'Golo Kante has admitted that the Chelsea squad was not prepared for Roman Abramovich's announcement confirming that he has put the club up for sale.\n\n" + "Chelsea initially welcomed Abramovich to the club back in 2003 as he purchased the club from Ken Bates for £140 million ($187m)."
    };

    public String[] getHeadlines(){
        return headlines.clone();
    }

    public  String[] getArticle(){
        return article.clone();
    }
}
