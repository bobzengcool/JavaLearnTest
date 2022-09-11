package com.web.bob.javaweblearntest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class MyFilter implements Filter {
    Log log= LogFactory.getLog(MyFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("开始执行filter");
        Filter.super.init(filterConfig);
        Enumeration<String> names = filterConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name=names.nextElement();
            log.info("开始  name="+filterConfig.getInitParameter(name));
        }

        log.info("执行filter结束");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("开始执行doFilter");
        log.info("本次的方法为-》》》"+servletRequest.getServletContext().getContextPath());
        servletRequest.setCharacterEncoding("UTF-8");
        String comment=servletRequest.getParameter("comment");
        log.info("filter获取到的comment为："+comment);

        filterChain.doFilter(servletRequest,servletResponse);
        log.info("执行doFilter结束");
    }

    @Override
    public void destroy() {
        log.info("开始执行destroy");
        Filter.super.destroy();
    }
}
