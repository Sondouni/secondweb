package com.sondouni.board.mainboard;

import com.sondouni.board.model.BoardVO;
import com.sondouni.board.user.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardVO vo = new BoardVO();
//        MyUtils.getParameterInt(req, "pk")
//        MyUtils.parseStringToInt(req.getParameter("iboard"))
        vo.setIboard(MyUtils.getParameterInt(req, "iboard"));
        req.setAttribute("board",BoardDAO.oneBoard(vo));
        MyUtils.disForward(req,res,"board/detail");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
