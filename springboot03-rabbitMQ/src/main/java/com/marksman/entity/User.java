package com.marksman.entity;

import java.io.Serializable;

/**
 * @author weilb
 * @date 2018/8/19
 * @description
 */
public class User implements Serializable {

    private String name;

    private String pass;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
