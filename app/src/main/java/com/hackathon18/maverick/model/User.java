package com.hackathon18.maverick.model;

import android.os.Parcelable;

import java.util.Random;

/**
 * Created by IbrahimKhawaja on 3/29/2018.
 */

public class User {
    String Username;
    String Cnic;
    String Password;
    int credits;

    public User(String name,String nic, String pass){
        Username=name;
        Cnic=nic;
        Password=pass;
    }

    public User(String name,String nic, String pass, String credits){
        Username=name;
        Cnic=nic;
        Password=pass;
        this.credits=Integer.parseInt(credits);
    }

    public int creditsOfPreviousUser(){
        int min = 1200;
        int max = 5600;

        Random r = new Random();
        int randomCredits = r.nextInt(max - min + 1) + min;
        this.credits=randomCredits;
        return this.credits;
    }

    public int creditsOfNewUser(){
        this.credits=0;
        return this.credits;
    }

    public void add(int temp){
        this.credits+=temp;
    }

    public void subtract(int temp){
        this.credits-=temp;
    }

    public boolean canTransfer(int amount){
        if (this.credits>500 && (this.credits-amount)>0){
            return true;
        }
        return false;
    }

    public boolean canTransfer(){
        if (this.credits>500){
            return true;
        }
        return false;
    }



}
