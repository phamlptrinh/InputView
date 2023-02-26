package com.example.chuyenform;

import java.io.Serializable;

public class User implements Serializable {
        private String name;
        private String phoneNumber;
        private boolean gender;
        private String degree;
        private byte age;
        private boolean likeSport;
        private String kindOfMusic;


    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public boolean isLikeSport() {
        return likeSport;
    }

    public void setLikeSport(boolean likeSport) {
        this.likeSport = likeSport;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public String toString(){
        return "Người dùng "+name+", "+age+" tuổi, là "+(gender?"nữ, ":"nam, ")
                +(likeSport?"yêu thể thao, ":"khá lười, ")+"thích nhạc " +kindOfMusic
                +".\nTrình độ học vấn của "+(gender?"cô ấy là: ":"anh ấy là: ")+degree
                +"\nLiên lạc: "+phoneNumber;
    }
}
