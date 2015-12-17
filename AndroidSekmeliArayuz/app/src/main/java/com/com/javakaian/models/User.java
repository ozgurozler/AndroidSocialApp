package com.com.javakaian.models;

import java.util.ArrayList;

/**
 * Created by javakaian on 12/12/2015.
 */
public class User
{
    private String name;
    private String userName;
    private String password;
    private int age;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private ArrayList<User> friendList;
    private ArrayList<Post> posts;
    private ArrayList<FriendRequest> fRequestsList;
    ///

    private boolean addable;


    public User()
    {
        friendList = new ArrayList<User>();
        posts  =new ArrayList<Post>();
        fRequestsList = new ArrayList<FriendRequest>();
        addable=true;
    }




    public User(String name, String userName, String email,int age) {
        super();
        this.name = name;
        this.userName = userName;
        this.age = age;
        this.email = email;
    }

    public void addFriend(User user)
    {


        friendList.add(user);


    }
    public void addFriendRequest(User userSender, User userReciever)
    {
        fRequestsList.add(new FriendRequest(userSender, userReciever));
    }

    public void makePost(String postText)
    {
        posts.add(new Post(this, postText));
    }


    public ArrayList<FriendRequest> getfRequestsList() {
        return fRequestsList;
    }

    public void setfRequestsList(ArrayList<FriendRequest> fRequests) {
        this.fRequestsList = fRequests;
    }

    public boolean isAddable() {
        return addable;
    }

    public void setAddable(boolean addable) {
        this.addable = addable;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<User> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<User> friendList) {
        this.friendList = friendList;
    }


    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }


    public String toString() {

        return name+" "+userName+" "+email+" "+age;
    }
}
