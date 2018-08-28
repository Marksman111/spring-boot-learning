package com.marksman.entity;

import java.io.Serializable;

/**
 * @author weilb
 * @date 2018/8/28
 * @description
 */
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String useName;

    private String passWord;

    public UserEntity() {
    }

    public UserEntity(Long id, String useName, String passWord) {
        this.id = id;
        this.useName = useName;
        this.passWord = passWord;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", useName='" + useName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
