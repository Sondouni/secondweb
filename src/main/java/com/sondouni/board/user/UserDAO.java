package com.sondouni.board.user;

import com.sondouni.board.DButils;
import com.sondouni.board.model.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//히카리?
public class UserDAO {
    public static int login(UserVO vo){
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "SELECT iuser, upw , nm from t_user where uid = ? ";
        try {
            con = DButils.getCon();
            pre = con.prepareStatement(sql);
            pre.setString(1,vo.getUid());
            rs = pre.executeQuery();
            if(rs.next()){
                if(rs.getString("upw").equals(vo.getUpw())){
                    vo.setIuser(rs.getInt("iuser"));
                    vo.setNm(rs.getString("nm"));
                    return 1;
                }else {
                    return 3;
                }
//                if(rs.next()){return rs.getString("upw").equals(vo.getUpw())? 1:3;}
            }else {
                return 2;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pre,rs);
        }
        return 0;
    }

    public static int join(UserVO vo){
        Connection con = null;
        PreparedStatement pre = null;
        String sql = "INSERT INTO t_user (uid,upw,nm,gender) values ( ? , ? , ? , ? )";
        try {
            con = DButils.getCon();
            pre = con.prepareStatement(sql);
            pre.setString(1,vo.getUid());
            pre.setString(2,vo.getUpw());
            pre.setString(3,vo.getNm());
            pre.setInt(4,vo.getGender());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pre);
        }
        return 0;
    }
}
