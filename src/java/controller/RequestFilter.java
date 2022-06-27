package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter (filterName = "RequestFilter", urlPatterns = {"/login","/abc"})
public class RequestFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Ok");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest hsr = (HttpServletRequest) request;
        HttpServletResponse hsrp = (HttpServletResponse) response;
        
        if (hsr.getParameter("username") != null && hsr.getParameter("password") != null) {
            //adala page ekata yanna kalin execute wenne
            chain.doFilter(request, response);
            //response eka create unata passe execute wenne
        } else {
            System.out.println("Hello");
            hsrp.sendRedirect("index.jsp");
        }
        
    }
    
    @Override
    public void destroy() {
        
    }
    
}
