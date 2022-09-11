package com.web.bob.javaweblearntest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletOrig", value = "/ServletOrig")
public class ServletOrig implements Servlet {
    Log log= LogFactory.getLog(ServletOrig.class);
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        log.info("开始执行init方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        log.info("开始执行ServletConfig方法");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        log.info("开始执行service方法");
        servletResponse.setContentType("text/html;charset=utf-8");
        // Hello
        PrintWriter out = servletResponse.getWriter();
        out.println("<html><body>");
        out.println("<h1>通过实现servlet接口开发</h1>");
        out.println("</body></html>");
        log.info("执行service方法结束");
    }

    @Override
    public String getServletInfo() {
        log.info("执行getServletInfo方法");
        return null;
    }

    @Override
    public void destroy() {
        log.info("执行destroy方法");
    }
}
