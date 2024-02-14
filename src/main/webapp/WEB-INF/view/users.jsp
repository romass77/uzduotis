<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
      
              <a href="<%=application.getContextPath()%>/user/edit">New user</a>
        <ul>
            <c:forEach var="user" items="${list}">
                <li>
                    ${user.iduser}&nbsp;

                    ${user.name}&nbsp;

                    ${user.email}&nbsp;

                    ${user.password}
                    <a href="<%=application.getContextPath()%>/user/delete?iduser=${user.iduser}">Delete</a>
                    <a href="<%=application.getContextPath()%>/user/edit?iduser=${user.iduser}">Edit</a>
                    <a href="<%=application.getContextPath()%>/task/task_user?iduser=${tasks.userid}">Tasks</a>
                    <br>
                   

                </li>
            </c:forEach> 
        </ul>
        <a href="<%=application.getContextPath()%>/">Back</a>
        
    </body>
</html>
