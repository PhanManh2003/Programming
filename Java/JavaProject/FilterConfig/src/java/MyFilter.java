
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;

public class MyFilter implements Filter {
// An object of FilterConfig is created by the web container. 
// This object can be used to get the configuration information from the web.xml file.
    
    FilterConfig config; // a FilterConfig reference variable

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {

        PrintWriter out = resp.getWriter();

        String s = config.getInitParameter("construction");

        if (s.equals("yes")) {
            out.print("This page is under construction");
        } else {
            chain.doFilter(req, resp);//sends request to next resource  
        }

    }

    @Override
    public void destroy() {
    }
}
