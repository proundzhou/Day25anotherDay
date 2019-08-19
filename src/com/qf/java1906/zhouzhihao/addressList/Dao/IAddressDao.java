package com.qf.java1906.zhouzhihao.addressList.Dao;

import com.qf.java1906.zhouzhihao.addressList.Entity.Contact;

import java.util.List;

public interface IAddressDao {
    /*通过密码和用户名查看，或通过用户名查看是否存在该用户*/
    boolean isExist(String name ,String password);
    boolean isExist(String name);
    /*返回联系人列表*/
    List<Contact> MyAddressList();
    /*添加新联系人进入数据库*/
    Integer insertContact(Contact contact);
    /*查找一个联系人*/
    Contact selectContact(String name);
    /*修改联系人*/
    Integer editContact(Contact contact);
    /*删除联系人*/
    Integer delContact(String name);
    /*多删除*/
}
