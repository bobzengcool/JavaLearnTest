package bob.learn3Servlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import java.io.IOException;

public class ServletTest implements Servlet{
    Log log= LogFactory.getLog(ServletTest.class);
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        log.info("执行init方法");
        log.info("servletConfig名字"+servletConfig.getServletName());

    }

    @Override
    public ServletConfig getServletConfig() {
        log.info("执行ServletConfig方法");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        log.info("执行service方法");
        log.info("服务方法名称"+servletRequest.getServerName());
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
