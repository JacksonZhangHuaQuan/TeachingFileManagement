package com.teacher.filter;

import com.teacher.common.Const;
import com.teacher.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginFilter implements Filter {

    private List<String> list = new ArrayList<>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        list.add("/index.jsp");
        list.add("/jsp/login.jsp");
        list.add("/login");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI();
        User currentUser = (User) request.getSession().getAttribute(Const.CURRENT_USER);
        if (currentUser != null){
            filterChain.doFilter(request,response);
            return;
        }
        if (list != null && list.contains(path)){
            filterChain.doFilter(request,response);
            return;
        }
        if (path.endsWith(".css") || path.endsWith(".js") || path.endsWith(".jpg") || path.endsWith(".png") || path.endsWith(".otf") || path.endsWith(".eot") || path.endsWith(".svg") || path.endsWith(".ttf") || path.endsWith(".woff") || path.endsWith(".gif")){
            filterChain.doFilter(request,response);
            return;
        }
        response.sendRedirect(request.getContextPath()+"/index.jsp");

    }

    @Override
    public void destroy() {

    }
}
