package filter;

import java.io.*;
import jakarta.servlet.*;

public class MyFilter3 implements Filter {

    static int count = 0;

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {

        PrintWriter out = res.getWriter();
        long before = System.currentTimeMillis();

        chain.doFilter(req, res);

        long after = System.currentTimeMillis();
        out.print("<br/>Total response time " + (after - before) + " miliseconds");
        out.close();

    }

    @Override
    public void destroy() {
    }
}
