package com.qf.java1906.zhouzhihao.addressList.Dao.Impl;

import com.qf.java1906.zhouzhihao.addressList.Dao.IAddressDao;
import com.qf.java1906.zhouzhihao.addressList.Entity.Contact;
import com.qf.java1906.zhouzhihao.addressList.Utils.DBClose;
import com.qf.java1906.zhouzhihao.addressList.Utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements IAddressDao {
    @Override
    public boolean isExist(String name ,String password) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rSet=null;
        int count=0;
        connection = DBUtils.getConnection();
        try {
            ps = connection.prepareStatement("select count(*) from addressList where (password=?)&&(password=?) ");
            ps.setString(1,name);
            ps.setString(2,password);
            rSet = ps.executeQuery();
            if(rSet.next()){
                count=rSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(rSet,ps,connection);
        }
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isExist(String name) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rSet=null;
        int count=0;
        connection = DBUtils.getConnection();
        try {
            ps = connection.prepareStatement("select count(*) from addressList where (password=?) ");
            ps.setString(1,name);
            rSet = ps.executeQuery();
            if(rSet.next()){
                count=rSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(rSet,ps,connection);
        }
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Contact> MyAddressList() {
        Connection connection=null;
        Statement statement=null;
        ResultSet rSet=null;
        List<Contact> contacts = new ArrayList<>();
        connection = DBUtils.getConnection();
        Contact contact=null;
        String name=null;
        String address=null;
        String phone=null;
        try {
            statement = connection.createStatement();
            rSet = statement.executeQuery("select name,phone,address from addressList  ");
            while (rSet.next()){
                name = rSet.getString("name");
                address = rSet.getString("address");
                phone = rSet.getString("phone");
                contact = new Contact(name,phone,address);
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(rSet,statement,connection);
        }
        return contacts;
    }

    @Override
    public Integer insertContact(Contact contact) {
        Connection connection=null;
        PreparedStatement ps=null;
        Integer count=0;
        connection = DBUtils.getConnection();
        try {
            ps = connection.prepareStatement("insert into addressList (name,phone,address) values (?,?,?)");
            ps.setString(1,contact.getName());
            ps.setString(2,contact.getPhone());
            ps.setString(3,contact.getAddress());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(ps,connection);
        }
        return count;
    }

    @Override
    public Contact selectContact(String name) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rSet=null;
        connection = DBUtils.getConnection();
        Contact contact=null;
        String address=null;
        String phone=null;
        try {
            preparedStatement = connection.prepareStatement("select phone,address from addressList where name=?");
            preparedStatement.setString(1,name);
            rSet = preparedStatement.executeQuery();
            if(rSet.next()){
                address = rSet.getString("address");
                phone = rSet.getString("phone");
                contact = new Contact(name,phone,address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(rSet,preparedStatement,connection);
        }
        return contact;
    }

    @Override
    public Integer editContact(Contact contact) {
        Connection connection=null;
        PreparedStatement ps=null;
        Integer count=0;
        connection = DBUtils.getConnection();
        try {
            ps = connection.prepareStatement("update addressList set password=?,phone=?,address=? where name=?");
            ps.setString(4,contact.getName());
            ps.setString(2,contact.getPhone());
            ps.setString(3,contact.getAddress());
            ps.setString(1,contact.getPassword());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(ps,connection);
        }
        return count;
    }

    @Override
    public Integer delContact(String name) {
        Connection connection=null;
        PreparedStatement ps=null;
        Integer count=0;
        connection = DBUtils.getConnection();
        try {
            ps = connection.prepareStatement("delete from addressList where name=?");
            ps.setString(1,name);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(ps,connection);
        }
        return count;
    }

}
