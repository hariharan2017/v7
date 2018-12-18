package com.example.health.v7;

public class Patient {
    private String first_name;
    private String last_name;
    private String address;
    private String desc;
    private String contact;

    public Patient() {
    }

    public Patient(String first_name, String last_name, String address, String desc, String contact) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.desc = desc;
        this.contact = contact;
    }


    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String getDesc() {
        return desc;
    }

    public String getContact() {
        return contact;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
