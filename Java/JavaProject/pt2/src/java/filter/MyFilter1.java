package filter;

import java.io.*;  
import jakarta.servlet.*;  
  
public class MyFilter1 implements Filter{  
    @Override
    public void init(FilterConfig arg0) throws ServletException {}  
  
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,  
            FilterChain chain) throws IOException, ServletException {  
      
        PrintWriter out=res.getWriter();  
          
        out.print("<br/>this site is underconstruction..");  
        out.close();  
          
    }  
    @Override
    public void destroy() {}  
}  