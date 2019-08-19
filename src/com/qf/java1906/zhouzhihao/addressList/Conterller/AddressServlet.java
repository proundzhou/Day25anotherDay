package com.qf.java1906.zhouzhihao.addressList.Conterller;

import com.qf.java1906.zhouzhihao.addressList.Dao.Impl.AddressDaoImpl;
import com.qf.java1906.zhouzhihao.addressList.Entity.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AddressServlet",urlPatterns = "/AddressServlet")
public class AddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "login":
                login(request,response);
                break;
            case "toMyAddressList":
                toMyAddressList(request,response);
                break;
            case "toInsert":
                toInsert(request,response);
                break;
            case "insertContact":
                insertContact(request,response);
                break;
            case "toEdit":
                toEdit(request,response);
                break;
            case "editContact":
                editContact(request,response);
                break;
            case "deleteContact":
                deleteContact(request,response);
                break;
            case "deleteChoose":
                deleteChoose(request,response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    private void login (HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*获取数据*/
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        /*处理业务*/
        /*按name和密码查询数据库数据，存在该用户则返回通过*/
        int count=0;
        AddressDaoImpl addressDao = new AddressDaoImpl();
        boolean exitAdd = addressDao.isExist(name, password);
        /*通过，在会话区保存name，重定向到欢迎页面，不通过，则返回登陆页面，弹窗提示*/
        if(exitAdd){
            /*存储cookie*/
            String remember = request.getParameter("remember");
            if(remember!=null){
                Cookie cookie = new Cookie("name", URLEncoder.encode(name, "utf-8"));
                cookie.setMaxAge(60*60);
                response.addCookie(cookie);
            }
            request.getSession().setAttribute("name",name);
            response.sendRedirect("welcome.jsp");
        }else{
            response.sendRedirect("login.jsp");
        }
    }

    private void toMyAddressList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*获取用户名，此例中不必要*/
        /*String name =(String) request.getSession().getAttribute("name");*/
        /*从数据库找到表中的通讯对象，做成集合*/
        List<Contact> addressList = new ArrayList();
        AddressDaoImpl addressDao = new AddressDaoImpl();
        addressList = addressDao.MyAddressList();
        /*响应*/
        request.setAttribute("addressList",addressList);
        request.getRequestDispatcher("MyAddressList.jsp").forward(request,response);
    }

    private void toInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*重定向到修改页面*/
        response.sendRedirect("insertContact.jsp");
    }

    private void insertContact(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*获取添加的信息*/
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        /*按名字查询记录，如果不存在则添加到数据库中，如果存在，返回展示页面*/
        AddressDaoImpl addressDao = new AddressDaoImpl();
        if(addressDao.isExist(name)){
            response.sendRedirect("AddressServlet?action=toMyAddressList");
        }else{
            addressDao.insertContact(new Contact(name,phone,address));
            response.sendRedirect("AddressServlet?action=toMyAddressList");
        }
    }
    private void toEdit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        /*按姓名查找一个联系人，转发回页面*/
        Contact contact = new Contact();
        AddressDaoImpl addressDao = new AddressDaoImpl();
        contact = addressDao.selectContact(name);
        request.setAttribute("contact",contact);
        request.getRequestDispatcher("editContact.jsp").forward(request,response);
    }

    private void editContact(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        Contact contact = new Contact(name, password, phone, address);
        /*数据库修改，返回修改行数*/
        Integer count=null;
        AddressDaoImpl addressDao = new AddressDaoImpl();
        count = addressDao.editContact(contact);
        /*修改成功，返回查询页面*/
        if(count>0){
            response.sendRedirect("AddressServlet?action=toMyAddressList");
        }else{
            response.sendRedirect("AddressServlet?action=editContact&name="+name);
        }
    }
    private void deleteContact(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        /*按姓名删除一个联系人，重定向到通讯列表页面*/
        AddressDaoImpl addressDao = new AddressDaoImpl();
        Integer count=0;
        count= addressDao.delContact(name);
        if(count>0){
            response.sendRedirect("AddressServlet?action=toMyAddressList");
        }else{
            response.sendRedirect("AddressServlet?action=toMyAddressList");
        }
    }
    private void deleteChoose(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] nameLists = request.getParameterValues("nameList");
        AddressDaoImpl addressDao = new AddressDaoImpl();
        for (String name:nameLists
             ) {
            addressDao.delContact(name);
        }
        response.sendRedirect("AddressServlet?action=toMyAddressList");
    }
}
