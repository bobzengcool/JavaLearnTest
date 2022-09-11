package bob.learn2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.net.httpserver.HttpServer;



public class HttpServerMain {
	static Log log=LogFactory.getLog(HttpServerMain.class);
    public static void main(String[] args) throws IOException {
    	log.info("开始执行main方法");
        //创建一个HttpServer实例，并绑定到指定的IP地址和端口号
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

        //创建一个HttpContext，将路径为/myserver请求映射到MyHttpHandler处理器
//        httpServer.createContext("/myserver", new MyHttpHandler());
        httpServer.createContext("/", new MyHttpHandler());

        //设置服务器的线程池对象
        httpServer.setExecutor(Executors.newFixedThreadPool(10));

        //启动服务器
        httpServer.start();
    }
}
