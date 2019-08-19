package com.qf.java1906.zhouzhihao.addressList.Entity;

public class Contact {
    private String name;
    private String password;
    private String phone;
    private String address;

    /*构造方法*/

    public Contact() {
    }

    public Contact(String name, String password, String phone, String address) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public Contact(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    /*get，set*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*toString*/

    @Override
    public String toString() {
        return "AddressList{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                '}';
    }
}
