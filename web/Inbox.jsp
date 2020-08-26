<%-- 
    Document   : Inbox
    Created on : Mar 20, 2020, 3:37:10 PM
    Author     : PhongFPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="create">Create message</a>
        <table border="1px">
            <tr>
                <td>Title</td>
                <td>From</td>
                <td>At</td>
                <td>Seen</td>
            </tr>
            <c:forEach items="${requestScope.list}" var="e">
                <tr>
                    <td><a href="message?id=${e.id}">${e.messageTitle}</a></td>
                    <td>${e.from}</td>
                    <td>${e.messageTime}</td>
                    <td><c:if test="${e.isRead}">
                            <img src="eye.png" alt="haha"/>
                        </c:if></td>
                </tr>
                
            </c:forEach>
                
        </table>
    </body>
</html>
