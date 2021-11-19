<%@ page import="com.sondouni.board.model.UserVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sondouni.board.model.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserVO loginUser = (UserVO)session.getAttribute("loginUser");
    String msg = (String)session.getAttribute("msg");
    List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
    int pageNum = (int)request.getAttribute("maxPage");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        table, td, th{
            border-collapse: collapse ;
            border: 1px solid #000;
        }
        .table { border-collapse: collapse ; border: 1px solid #000; }
        html,body { margin: 0; padding: 0; height: 100%; }
        .box { height : 100%;background-color : rgb(204, 203, 203); display: flex; justify-content: center; align-items: center; flex-direction: column }
        .listbox { background-color: #fff; height: 800px;width: 800px; border :1px solid #000;display: flex; justify-content: center; align-items: center;flex-direction: column }
    </style>
</head>
<body >
    <div class="box">
        <div class="listbox">



                <%if(loginUser != null){%>
            <div><%=loginUser.getNm()%>님 환영합니다!</div>
            <div><a href="/user/logout"><input type="button" value="logOut"></a></div>
                <%}%>
                <%if(loginUser == null){%>
            <div><a href="/user/login"><input type="button" value="logIn"></a></div>
                <%}%>
            <div>BoardList</div>
                <table>
                    <tr >
                        <th>num</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>시간</th>
                    </tr>
                    <%for(BoardVO vo : list){%>
                    <tr >
                        <td><%=vo.getIboard()%></td>
                        <td><a href="/board/detail?iboard=<%=vo.getIboard()%>"><%=vo.getTitle()%></a></td>
                        <td><%=vo.getIid()%></td>
                        <td><%=vo.getRdt()%></td>
                    </tr>
                    <%}%>
                </table>
            <a href="/board/write"><input type="button" value="write"></a>
            <%for(int i = 1;i<=pageNum;i++){%>
                <span style="margin-top: 20px">
                    <a href="/board/list?page=<%=i%>"><%=i%>&nbsp;</a>
                <span/>
            <%}%>
    </div>
</body>
</html>