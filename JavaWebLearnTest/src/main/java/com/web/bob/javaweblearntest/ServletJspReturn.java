package com.web.bob.javaweblearntest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletJspReturn", value = "/ServletJspReturn")
public class ServletJspReturn extends HttpServlet {
    Log log= LogFactory.getLog(ServletJspReturn.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("开始执行doGet");
        //获取ServletContext对象
        //this.getServletConfig().getServletContext();
        //等同于下面一句，因为创建getServletContext必须要通过getServletConfig对象
        ServletContext context = this.getServletContext();
        //获取web的上下文路径，
        String path = context.getContextPath();
        //请求重定向，这样的好处可以让获取的路径更加灵活。不用考虑项目名是否发生了变化。
        response.sendRedirect(context.getContextPath()+"/JSPComment.jsp");
        log.info("执行doGet结束");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
