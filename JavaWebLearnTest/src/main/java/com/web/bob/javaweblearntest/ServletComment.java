package com.web.bob.javaweblearntest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.misc.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ServletComment", value = "/ServletComment")
public class ServletComment extends HttpServlet {
    Log log= LogFactory.getLog(ServletComment.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("begin doPost");
        String comment=request.getParameter("comment");
        log.info("servlet接收到的comment为："+comment);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.getWriter().println(comment);
    }
}
