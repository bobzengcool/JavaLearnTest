package com.bob.web;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTest", value = "/ServletTest")
public class ServletTest extends HttpServlet {
    Log log= LogFactory.getLog(ServletTest.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("开始执行doGet方法");
        request.getMethod();
        request.getServletContext();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(request.getRequestedSessionId());
        log.info("执行doGet方法结束");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }
}
