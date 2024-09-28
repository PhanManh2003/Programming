package filter;

import java.io.*;
import jakarta.servlet.*;

public class MyFilter2 implements Filter {

    static int count = 0;

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {

        PrintWriter out = res.getWriter();
        chain.doFilter(req, res);

        out.print("<br/>Total visitors " + (++count));
        out.close();

    }

    @Override
    public void destroy() {
    }
}
