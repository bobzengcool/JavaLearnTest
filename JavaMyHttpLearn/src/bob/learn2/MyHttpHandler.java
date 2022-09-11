package bob.learn2;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 处理/myserver路径请求的处理器类
 */
public class MyHttpHandler implements HttpHandler {
	Log log=LogFactory.getLog(MyHttpHandler.class);
	
    @Override
    public void handle(HttpExchange httpExchange) {
    	log.info("开始执行handle");
    	try {
    		log.info("接收到的请求方法名为->"+httpExchange.getRequestMethod());
			log.info("接收到的请求头参数为->"+getRequestParam(httpExchange));
			log.info("请求地址为->"+httpExchange.getRemoteAddress());
			log.info("请求的数据为->"+httpExchange.getRequestBody());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        try {
            StringBuilder responseText = new StringBuilder();
            responseText.append("input method").append(httpExchange.getRequestMethod()).append("<br/>");
            responseText.append("input para:").append(getRequestParam(httpExchange)).append("<br/>");
            responseText.append("input head:<br/>").append(getRequestHeader(httpExchange));
            handleResponse(httpExchange, responseText.toString());
//            handleResponse(httpExchange, new String(responseText.toString().getBytes(),"UTF-8"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        log.info("handle方法执行完毕");
    }

    /**
     * 获取请求头
     * @param httpExchange
     * @return
     */
    private String getRequestHeader(HttpExchange httpExchange) {
    	log.info("开始执行getRequestHeader");
        Headers headers = httpExchange.getRequestHeaders();
        return headers.entrySet().stream()
                                .map((Map.Entry<String, List<String>> entry) -> entry.getKey() + ":" + entry.getValue().toString())
                                .collect(Collectors.joining("<br/>"));
    }

    /**
     * 获取请求参数
     * @param httpExchange
     * @return
     * @throws Exception
     */
    private String getRequestParam(HttpExchange httpExchange) throws Exception {
    	log.info("开始执行getRequestParam");
        String paramStr = "";

        if (httpExchange.getRequestMethod().equals("GET")) {
            //GET请求读queryString
            paramStr = httpExchange.getRequestURI().getQuery();
        } else {
            //非GET请求读请求体
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody(), "utf-8"));
            StringBuilder requestBodyContent = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                requestBodyContent.append(line);
            }
            paramStr = requestBodyContent.toString();
        }

        return paramStr;
    }

    /**
     * 处理响应
     * @param httpExchange
     * @param responsetext
     * @throws Exception
     */
    private void handleResponse(HttpExchange httpExchange, String responsetext) throws Exception {
    	log.info("开始执行handleResponse");
        //生成html
        StringBuilder responseContent = new StringBuilder();
        responseContent.append("<html>")
                .append("<body>")
                .append(responsetext)
                .append("</body>")
                .append("</html>");
        String responseContentStr = responseContent.toString();
        byte[] responseContentByte = responseContentStr.getBytes("utf-8");

        //设置响应头，必须在sendResponseHeaders方法之前设置！
        httpExchange.getResponseHeaders().add("Content-Type:", "text/html;charset=utf-8");

        //设置响应码和响应体长度，必须在getResponseBody方法之前调用！
        httpExchange.sendResponseHeaders(200, responseContentByte.length);

        OutputStream out = httpExchange.getResponseBody();
        out.write(responseContentByte);
        out.flush();
        out.close();
    }
}
