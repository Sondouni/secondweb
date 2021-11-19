<%@ page import="com.sondouni.board.model.UserVO" %>
<%@ page import="com.sondouni.board.model.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserVO uvo = (UserVO)session.getAttribute("loginUser");
    String err = (String)request.getAttribute("error");
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
        .context { margin-top: 70px; display: flex; align-items: center; flex-direction: column; height: 100%}
        .writeBox { background-color: #fff; height: 500px;width: 500px; border :1px solid #000;display: flex;  align-items: center;flex-direction: column }
    </style>
</head>
<body>
    <div class="box">
        <div class="writeBox">
            <% if(err!=null){%>
            <div><%=err%></div>
            <%}%>
            <h1>Write</h1>
            <form class="context" action="/board/write" method="post">
                <div><input type="text" placeholder="title" value="${requestScope.wrtData.title}" name="title"></div>
                <div>
                    <textarea name="ctnt" placeholder="context" rows="10">${requestScope.wrtData.ctnt}</textarea>
                </div>
                <div><input type="text" value="<%=uvo.getUid()%>" name="title" disabled></div>
                <div>
                    <input type="submit" value="write">
                    <input type="reset" value="reset">
                    <a href="/board/list"><input type="button" value="back"></a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>