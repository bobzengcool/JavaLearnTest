package com.bob.learn3Servlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTest2 extends GenericServlet {
    Log log= LogFactory.getLog(ServletTest2.class);
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        log.info("开始执行service方法");
        servletResponse.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
        servletResponse.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题
        String jsonStr ="{\"id\":\"123\",\"name\":\"小黎\"}";
        PrintWriter out = servletResponse.getWriter() ;
        out.write(jsonStr);
        out.close();
    }
}
