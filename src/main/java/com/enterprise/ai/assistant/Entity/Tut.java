package com.enterprise.ai.assistant.Entity;

public class Tut
{
    private String title;
    private String content;
    private String createdYears;

    public Tut(String content, String title, String createdYears)
    {
        this.content = content;
        this.title = title;
        this.createdYears = createdYears;
    }

    public Tut(){}

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getCreatedYears()
    {
        return createdYears;
    }

    public void setCreatedYears(String createdYears)
    {
        this.createdYears = createdYears;
    }
}
