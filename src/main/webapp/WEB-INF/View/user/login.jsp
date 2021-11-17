<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        html,body { margin: 0; padding: 0; height: 100%; }
        .box { height : 100%;background-color : rgb(204, 203, 203); display: flex; justify-content: center; align-items: center; flex-direction: column }
        .loginbox { background-color: #fff; height: 200px;width: 300px; border :1px solid #000;display: flex; justify-content: center; align-items: center;flex-direction: column }
        #button {margin-top : 5px;  display: flex; justify-content: center; align-items: center; flex-direction: row;}
        .btn { margin: 3px }
    </style>
</head>
<body>
    <%if(msg != null){%>
    <script type="text/javascript">
        alert('<%=msg%>')
    </script>
    <%}%>
    <div class="box">
        <div class="loginbox">
            <form  action="/user/login" method="post">
                <div><input type="text" name="uid" placeholder="user id"></div>
                <div><input type="password" name="upw" placeholder="user password"></div>
                <div id="button">
                    <div class="btn"><input type="submit" value="login"></div>
                    <div class="btn"><a  href="/user/join"><input type="button" value="join"></a></div>
                </div>
            </form>
            <div>

            </div>
        </div>
    </div>
</body>
</html>