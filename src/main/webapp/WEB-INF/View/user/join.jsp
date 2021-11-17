<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> </title>
    <style>
        html,body { margin: 0; padding: 0; height: 100%; }
        .box { height : 100%;background-color : rgb(204, 203, 203); display: flex; justify-content: center; align-items: center; flex-direction: column }
        .joinbox { background-color: #fff; height: 500px;width: 500px; border :1px solid #000;display: flex;  align-items: center;flex-direction: column }
        .context { margin-top: 70px; display: flex; justify-content: center; align-items: center; flex-direction: column; height: 100%}
        .div1 { margin-top: 50px}
        .gender { display: flex; justify-content: center; align-items: center; }
    </style>
</head>
<body class="box">
    <%if(msg != null){%>
    <script type="text/javascript">
        alert('<%=msg%>')
    </script>
    <%}%>
    <div class="joinbox">
        <h1>WelCome!</h1>
        <div>
            <form class="context" action="/user/join" method="post">
                <div><input type="text" name="uid" placeholder="user id"></div>
                <div><input type="password" name="upw" placeholder="user password"></div>
                <div><input type="text" name="nm" placeholder="name"></div>
                <div class="gender">
                    <label>woman<input type="radio" name="gender"value="0" checked></label>
                    <label>man<input type="radio" name="gender"value="1"></label>
                </div>
                <div class="div1"><input type="submit" value="join"></div>
            </form>
        </div>
    </div>
</body>
</html>