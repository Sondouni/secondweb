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

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserVO vo = (UserVO) session.getAttribute("loginUser");
        if(vo == null){
//            MyUtils.disForward(req,res,"board/list"); 이거를 하면 jsp파일로 가지고
            res.sendRedirect("list"); //이것은 서블릿으로 가게된다
            return;
        }
        MyUtils.disForward(req,res,"board/write");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardVO vo = new BoardVO();
        //보드 값넣기
        vo.setTitle(req.getParameter("title"));
        vo.setCtnt(req.getParameter("ctnt"));
        HttpSession session = req.getSession();
        UserVO uvo = (UserVO)session.getAttribute("loginUser");
        vo.setWirter(uvo.getIuser());
        //글쓰기 실행
        int result = BoardDAO.newBoard(vo);
        System.out.println(result);
        switch (result){
            case 1:
                res.sendRedirect("list");
                break;
            case 0:
                req.setAttribute("error","fail to write");
                req.setAttribute("wrtData",vo);
                doGet(req,res);
                break;
        }
        //주소이동
    }
}
