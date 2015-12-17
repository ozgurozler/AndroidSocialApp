package com.com.javakaian.models;

/**
 * Created by javakaian on 12/12/2015.
 */
public class FriendMaker
{
    public static void makeFriend(User firstUser, User secondUser)
    {

        firstUser.addFriend(secondUser);
        secondUser.addFriend(firstUser);

    }

}
