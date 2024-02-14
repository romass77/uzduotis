<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tasks</title>
    </head>
    <body>
        
          <a href="<%=application.getContextPath()%>/task/edit">New task</a>
        <ul>
            <c:forEach var="task" items="${uzduotis}">
                <li>
                    ${task.idtasks}&nbsp;

                    ${task.task}&nbsp;

                    ${task.description}&nbsp;
                    
                     ${task.startdate}&nbsp;
                     
                      ${task.enddate}&nbsp;

                    ${task.userid}

                </li>
            </c:forEach> 
        </ul>
        <a href="<%=application.getContextPath()%>/">Back</a>
    </body>
</html>
