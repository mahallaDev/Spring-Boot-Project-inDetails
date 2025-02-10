package com.icicibank.produce.icicibankproduce.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Userteacherinfo {
    @Column
    private String name;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String emailid;

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    @Column
    private String contact;
    @Column
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
