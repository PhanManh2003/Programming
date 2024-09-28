<%-- 
    Document   : demo
    Created on : Jul 9, 2024, 2:25:05 PM
    Author     : manhpthe172481
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<!-- JSP Predefined Variable – Implicit Objects 
request – Object of HttpServletRequest (request parameters, HTTP headers, cookies

response – Object of HttpServletResponse

out - Object of PrintWriter buffered version JspWriter

session - Object of HttpSession associated with the request

application - Object of ServletContext shared by all servlets in the engine

config - Object of ServletConfig

pageContext - Object of PageContext in JSP for a single point of access

page – variable synonym for this object -->
      
        
        <%
    // request: accessing a request parameter
    String username = request.getParameter("username");
    out.println("Hello, " + username + "<br>");

    // response: setting content type
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

    // out: writing output to the client
    out.println("<h1>Welcome to the JSP Page</h1><br>");

    // session: setting and getting session attributes
    session.setAttribute("user", "John Doe");
    String user = (String) session.getAttribute("user");
    out.println("Session User: " + user + "<br>");

    // application: setting and getting application attributes
    application.setAttribute("appName", "JSP Learning");
    String appName = (String) application.getAttribute("appName");
    out.println("Application Name: " + appName + "<br>");

    // config: accessing servlet configuration information
    String servletName = config.getServletName();
    out.println("Servlet Name: " + servletName + "<br>");

    // pageContext: accessing the request URI
//    String requestUri = pageContext;
//    out.println("Request URI: " + requestUri + "<br>");

    // page: referring to the current JSP page instance
    out.println("This is the current page: " + page + "<br>");
        %>
    </body>
</html>
