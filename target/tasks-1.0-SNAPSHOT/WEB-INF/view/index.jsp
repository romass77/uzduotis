<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to My Tasks</title>
    </head>

    <body>
      
        
          <h1>My tasks</h1>
        <a href="<%=application.getContextPath()%>/task/task_list">Tasks list</a><br>
        <a href="<%=application.getContextPath()%>/user/user_list">User list</a><br>
        <a href="<%=application.getContextPath()%>/register/users_list">Users list</a>
    </body>
</html>
