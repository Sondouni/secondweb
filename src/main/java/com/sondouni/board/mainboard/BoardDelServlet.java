package com.sondouni.board.mainboard;

import com.sondouni.board.model.UserVO;
import com.sondouni.board.user.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/delete")
public class BoardDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserVO vo = (UserVO)session.getAttribute("loginUser");
//        if(vo != null) {
//            BoardDAO.delBoard(MyUtils.getParameterInt(req, "iboard"), vo.getIuser());
//        }
        if(vo==null){
            req.setAttribute("err","login first");
            req.getRequestDispatcher("/board/detail").forward(req,res);
            return;
        }
        int result = BoardDAO.delBoard(MyUtils.getParameterInt(req, "iboard"), vo.getIuser());
        if(result == 0){
            req.setAttribute("err","it`s not your Post");
            req.getRequestDispatcher("/board/detail").forward(req,res);
            return;
        }
        res.sendRedirect("list");
    }
}
