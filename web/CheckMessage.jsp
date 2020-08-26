<%-- 
    Document   : CheckMessage
    Created on : Mar 23, 2020, 10:52:49 AM
    Author     : PhongFPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border ="1px">
            <tr>
                <td>From</td>
                <td>${requestScope.checkMessage.from}</td>
            </tr>
            <tr>
                <td>Title</td>
                <td>${requestScope.checkMessage.messageTitle}</td>
            </tr>
            <tr>
                <td>Created Time:</td>
                <td>${requestScope.checkMessage.messageTime}</td>
            </tr>
            <tr>
                <td>Content</td>
                <td>${requestScope.checkMessage.messageContent}</td>
            </tr>
        </table>
    </body>
</html>
