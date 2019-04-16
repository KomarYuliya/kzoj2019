package com.model;

public class User_data {
    private String login;
    private int age;
    private String mail;
    private double height;
    private double weight;
    private int normKK;
    private int normGBU;
    public User_data(){};

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getNormKK() {
        return normKK;
    }

    public void setNormKK(int normKK) {
        this.normKK = normKK;
    }

    public int getNormGBU() {
        return normGBU;
    }

    public void setNormGBU(int normGBU) {
        this.normGBU = normGBU;
    }
}
