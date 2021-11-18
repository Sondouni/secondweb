package com.sondouni.board.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/logout")
public class UserLogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        session.setAttribute("loginUser",null); //무식한 방법
        session.removeAttribute("loginUser"); //메소드사용해서 하나만 삭제
//        session.invalidate();//전체 다 삭제, 이걸 했을때 밑에것이 삭제되었다. session.setAttribute는 비동기(스레드)인가?
        session.setAttribute("msg","로그아웃 하였습니다.");
        res.sendRedirect("/board/list");
    }

}
