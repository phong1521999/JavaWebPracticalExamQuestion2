<%-- 
    Document   : CreateMessage
    Created on : Mar 23, 2020, 11:15:29 AM
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
        <form action="create" method="POST">
            <table border="1px">
                <tr>
                    <td>To</td>
                    <td>
                        <select name="to">
                            
                            <c:forEach items="${requestScope.list}" var="e">
                                <c:if test="${e.id ne sessionScope.login}">
                                   <option>${e.id}</option> 
                                </c:if>
                                
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><input type="text" name="title"/></td>
                </tr>
                <tr>
                    <td>Content</td>
                    <td><textarea name="content" rows="6"></textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
