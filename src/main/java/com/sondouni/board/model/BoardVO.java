package com.sondouni.board.model;

public class BoardVO {
    private int iboard;
//    private int iuser;
    private String title;
    private String ctnt;
    private int wirter;
    private String rdt;
    private String mdt;
    //닉네임? id값
    private String iid;

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

/*
    public int getIuser() {
        return iuser;
    }

    public void setIuser(int iuser) {
        this.iuser = iuser;
    }
*/

    public int getIboard() {
        return iboard;
    }

    public void setIboard(int iboard) {
        this.iboard = iboard;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCtnt() {
        return ctnt;
    }

    public void setCtnt(String ctnt) {
        this.ctnt = ctnt;
    }

    public int getWirter() {
        return wirter;
    }

    public void setWirter(int wirter) {
        this.wirter = wirter;
    }

    public String getRdt() {
        return rdt;
    }

    public void setRdt(String rdt) {
        this.rdt = rdt;
    }

    public String getMdt() {
        return mdt;
    }

    public void setMdt(String mdt) {
        this.mdt = mdt;
    }
}
