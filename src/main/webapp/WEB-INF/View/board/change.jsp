<%@ page import="com.sondouni.board.model.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    String err = (String)request.getAttribute("err");
%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        html,body { margin: 0; padding: 0; height: 100%; }
        .box { height : 100%;background-color : rgb(204, 203, 203); display: flex; justify-content: center; align-items: center; flex-direction: column }
        .detailBox { background-color: #fff; height: 800px;width: 800px; border :1px solid #000;justify-content: center;display: flex;  align-items: center;flex-direction: column }
        .boxx { }
    </style>
</head>
<body>
<div class="box">
    <div class="detailBox">
        <%if(err!=null){%>
        <div><%=err%></div>
        <%
                BoardVO vo = (BoardVO)request.getAttribute("chgData");
                request.setAttribute("data",vo);
            }%>
        <form class="detailBox" action="change" method="post" id="frm">
            <h1>ChangePost</h1>
            <div>제목 : <input type="text" name="title" value="${requestScope.data.title}" ></div>
            <input type="hidden" id="iboard" name="iboard" value="${requestScope.data.iboard}">
            <div>내용 : <input type="text" name="ctnt" value="${requestScope.data.ctnt}" style="width:300px;height:200px;" ></div>
            <div>
                <input type="submit" value="change">
                <a href="/board/detail?iboard=${requestScope.data.iboard}"><input type="button" value="back"></a>
                <input type="button" value="reset" onclick="removeAll()">
            </div>
        </form>
        <script>
            function removeAll() {
                var frm = document.querySelector('#frm');
                if(frm) {
                    frm.title.value = '';
                    frm.ctnt.value = '';
                    frm.writer.value = '';
                }
            }
        </script>
    </div>

</div>
</body>
</html>