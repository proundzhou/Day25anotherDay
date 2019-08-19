package com.qf.java1906.zhouzhihao.addressList.Filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnreadableFilter extends BaseFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*强转*/
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        /*乱码处理*/
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(request,response);
    }
}
