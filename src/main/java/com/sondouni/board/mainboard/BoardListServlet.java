package com.sondouni.board.mainboard;

import com.sondouni.board.model.BoardParamVO;
import com.sondouni.board.model.BoardVO;
import com.sondouni.board.user.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardParamVO pvo = new BoardParamVO();
        pvo.setRecordCnt(5);
        int page = MyUtils.getParameterInt(req,"page",1);
        pvo.setPage(page);

        List<BoardVO> list = BoardDAO.getList(pvo);

        req.setAttribute("maxPage",BoardDAO.selMaxPage(pvo));
        req.setAttribute("list",list); //기존방법


/*
        HttpSession session = req.getSession();
        session.setAttribute("list",list);//session이용
*/
        MyUtils.disForward(req,res,"board/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
