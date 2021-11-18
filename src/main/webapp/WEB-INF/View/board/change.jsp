<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        html,body { margin: 0; padding: 0; height: 100%; }
        .box { height : 100%;background-color : rgb(204, 203, 203); display: flex; justify-content: center; align-items: center; flex-direction: column }
        .detailBox { background-color: #fff; height: 800px;width: 800px; border :1px solid #000;justify-content: center;display: flex;  align-items: center;flex-direction: column }
    </style>
</head>
<body>
<div class="box">
    <div class="detailBox">
        <h1><%=vo.getTitle()%></h1>
        <div>번호 : <input type="text" value="<%=vo.getIboard()%>" style="width:300px;height:25px;"disabled></div>
        <div>내용 : <input type="text" value="<%=vo.getCtnt()%>" style="width:300px;height:200px;" disabled></input></div>
        <div>이름 : <input type="text" value="<%=vo.getIid()%>" style="width:300px;height:25px;" disabled></div>
        <div>시간 : <input type="text" value="<%=vo.getRdt()%>" style="width:300px;height:25px;"disabled></div>
        <div>
            <a href="/board/list"><input type="button" value="back"></a>
            <%if(uvo!=null){
                if(vo.getWirter()==uvo.getIuser()){%>
            <a href="/board/change"><input type="button" value="change"></a>
            <a href="/board/delete?iboard=<%=vo.getIboard()%>"><input type="button" value="delete"></a>
            <%}}%>
        </div>
    </div>

</div>
</body>
</html>