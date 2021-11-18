package com.sondouni.board.mainboard;

import com.sondouni.board.DButils;
import com.sondouni.board.model.BoardVO;
import com.sondouni.board.user.MyUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    public static int chgBoard(BoardVO vo){
        Connection con = null;
        PreparedStatement pr = null;
        String sql = " UPDATE t_board set title = ?, ctnt = ?, mdt = ? where iboard = ? and writer = ? ";
        try {
            con = DButils.getCon();
            pr = con.prepareStatement(sql);
            pr.setString(1,vo.getTitle());
            pr.setString(2,vo.getCtnt());
            pr.setString(3,vo.getMdt());
            pr.setInt(4,vo.getIboard());
            pr.setInt(5,vo.getWirter());
            return pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pr);
        }
        return 0;
    }
    public static int delBoard(int iboard,int writer){
        Connection con = null;
        PreparedStatement pr = null;
        String sql = " DELETE FROM t_board WHERE iboard = ? and writer = ?";
        try {
            con = DButils.getCon();
            pr = con.prepareStatement(sql);
            pr.setInt(1,iboard);
            pr.setInt(2,writer);
            return pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pr);
        }
        return 0;
    }

    public static BoardVO oneBoard(BoardVO param){
        BoardVO vo = new BoardVO();
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = " SELECT A.*,B.uid from t_board A " +
                    " Inner Join t_user B "+
                    " On A.writer = B.iuser "+
                    " where A.iboard = ? ";
        try {
            con = DButils.getCon();
            pr = con.prepareStatement(sql);
            pr.setInt(1,param.getIboard());
            rs = pr.executeQuery();
            if(rs.next()){
                vo.setCtnt(rs.getString("ctnt"));
                vo.setTitle(rs.getString("title"));
                vo.setIid(rs.getString("B.uid"));
                vo.setRdt(rs.getString("rdt"));
                vo.setMdt(rs.getString("mdt"));
                vo.setIboard(rs.getInt("iboard"));
                vo.setWirter(rs.getInt("writer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vo;
    }

    public static int newBoard(BoardVO vo){
        Connection con = null;
        PreparedStatement pr = null;
        String sql = "INSERT INTO t_board " +
                " (title,ctnt,writer) " +
                " VALUES " +
                " (?,?,?) ";
        try {
            con = DButils.getCon();
            pr = con.prepareStatement(sql);
            pr.setString(1,vo.getTitle());
            pr.setString(2,vo.getCtnt());
            pr.setInt(3, vo.getWirter());
            return pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pr);
        }
        return 0;
    }
    public static List<BoardVO> getList(){
        List<BoardVO> list = new ArrayList();
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = " SELECT A.iboard,A.title,A.rdt,B.uid FROM t_board A " +
                " INNER JOIN t_user B " +
                " ON A.writer = B.iuser " +
                " order by iboard desc ";
        try {
            con = DButils.getCon();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()){
                BoardVO vo = new BoardVO();
                vo.setIboard(rs.getInt("A.iboard"));
                vo.setTitle(rs.getString("A.title"));
                vo.setIid(rs.getString("B.uid"));
                vo.setRdt(rs.getString("A.rdt"));
                list.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pr,rs);
        }
        return list;
    }
}
