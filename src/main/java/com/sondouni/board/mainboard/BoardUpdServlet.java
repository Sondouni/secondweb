package com.sondouni.board.mainboard;

import com.sondouni.board.model.BoardVO;
import com.sondouni.board.model.UserVO;
import com.sondouni.board.user.MyUtils;
import org.apache.catalina.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/board/change")
public class BoardUpdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(!MyUtils.isLogin(req)){
            res.sendRedirect("/user/login");
            return;
        }
        HttpSession session = req.getSession();
        UserVO uvo = (UserVO)session.getAttribute("loginUser");
        BoardVO vo = new BoardVO();
        vo.setIboard(MyUtils.getParameterInt(req,"iboard"));
        System.out.println("리퀘스트 받은 아이보드"+MyUtils.getParameterInt(req,"iboard"));
        vo = BoardDAO.oneBoard(vo);
        System.out.println("doget에서의 vo.iboard"+vo.getIboard());
        req.setAttribute("data",vo);
        MyUtils.disForward(req,res,"board/change");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardVO vo = new BoardVO();
        vo.setTitle(req.getParameter("title"));//title
        vo.setCtnt(req.getParameter("ctnt"));//ctnt

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sd.format(new Date());
        System.out.println(date);
        vo.setMdt(date);//data
        int iboard = MyUtils.getParameterInt(req,"iboard");
        vo.setIboard(iboard);//iboard
        HttpSession session = req.getSession();
        UserVO uvo = (UserVO)session.getAttribute("loginUser");
        vo.setWirter(uvo.getIuser());//wirter

        int result = BoardDAO.chgBoard(vo);
        switch (result){
            case 1:
                res.sendRedirect("detail?iboard=\"+vo.getIboard()");
                break;
            default:
                req.setAttribute("err","fail to edit");
                req.setAttribute("chgData",vo);
                doGet(req,res);
                break;
        }
    }
}
