package com.com.javakaian.models;

/**
 * Created by javakaian on 12/12/2015.
 */
public class Post
{
    private User user;
    private String postText;

    public Post()
    {


    }

    public Post(User user , String postText)
    {
        this.user=user;
        this.postText=postText;
    }


    public String toString() {

        return user.getName()+" : "+postText;
    }


}
