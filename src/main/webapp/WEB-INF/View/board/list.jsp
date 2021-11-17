<%@ page import="com.sondouni.board.model.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserVO loginUser = (UserVO)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        html,body { margin: 0; padding: 0; height: 100%; }
        .box { height : 100%;background-color : rgb(204, 203, 203); display: flex; justify-content: center; align-items: center; flex-direction: column }
        .listbox { background-color: #fff; height: 500px;width: 500px; border :1px solid #000;display: flex; justify-content: center; align-items: center;flex-direction: column }
    </style>
</head>
<body class="box">
    <div class="listbox">
    <%if(loginUser != null){%>
    <script type="text/javascript">
        alert('<%=loginUser.getNm()%>님 환영합니다!')
    </script>
        <div><%=loginUser.getNm()%>님 환영합니다!</div>
        <div><a href="/user/logout"><input type="button" value="logOut"></a></div>
        <%}%>
        <%if(loginUser == null){%>
        <div><a href="/user/login"><input type="button" value="logIn"></a></div>
        <%}%>
        <div>BoardList</div>
    </div>
</body>
</html>