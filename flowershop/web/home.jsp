<%-- 
    Document   : home.jsp
    Created on : Apr 24, 2017, 3:43:03 PM
    Author     : gama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String name = "formulario";
    if(request.getSession().getAttribute("active") == null) {
       
    } else {
        name = "Bienvenido " + request.getSession().getAttribute("name");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%if(name.startsWith("form")) {%>
        <h1><%=name%></h1>
        <form action="login" method="POST">
            <input type='text' placeholder='User' name = 'user' id='user' />
            <input type='password' placeholder="password" name='pass' id='pass'/>
            <button>Send</button>
        </form>
        <%} else {%>
            <h1><%=name%></h1>
        <%}%>
    </body>
</html>
