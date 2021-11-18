package com.sondouni.board.mainboard;

import com.sondouni.board.model.BoardVO;
import com.sondouni.board.model.UserVO;
import com.sondouni.board.user.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/change")
public class BoardUpdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserVO uvo = (UserVO)session.getAttribute("loginUser");
        BoardVO vo = new BoardVO();
        vo.setIboard(MyUtils.getParameterInt(req,"ibaord"));
        vo.setWirter(uvo.getIuser());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardVO vo = new BoardVO();

    }
}
