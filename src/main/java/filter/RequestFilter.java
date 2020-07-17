package filter;

import core.MyRequest;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("*.do")
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //拆箱
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        //创建新的请求
        MyRequest myRequest=new MyRequest(request,response);

        //将请求添加到当前线程中
//        Util.setRequest(myRequest);
//        ContextLoaderListener.getCurrentWebApplicationContext()

        //将请求进行替换
        filterChain.doFilter(myRequest,response);
    }

    @Override
    public void destroy() {

    }
}
