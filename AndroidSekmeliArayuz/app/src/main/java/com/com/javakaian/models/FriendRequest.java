package com.com.javakaian.models;

/**
 * Created by javakaian on 12/12/2015.
 */
public class FriendRequest
{

    private User userSender, userReciever;


    public FriendRequest(User userSender, User userReciever)
    {
        this.userReciever=userReciever;
        this.userSender=userSender;

    }





    public  void sendRequest()
    {
        if(userReciever.isAddable())
        {

            userReciever.addFriendRequest(userSender, userReciever);



        }
        else
        {
            System.out.println("Request gönderemezsiniz..");
        }
    }
    public void acceptRequest(int reqIndex)
    {
        FriendMaker.makeFriend(userSender, userReciever);
        userReciever.getfRequestsList().remove(reqIndex);
    }

    public void declineRequest(int reqIndex)
    {
        userReciever.getfRequestsList().remove(reqIndex);

    }





    public User getUserSender() {
        return userSender;
    }





    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }





    public User getUserReciever() {
        return userReciever;
    }





    public void setUserReciever(User userReciever) {
        this.userReciever = userReciever;
    }

}
