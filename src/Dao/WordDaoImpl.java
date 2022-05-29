package Dao;

import DbUtils.DbManager;
import Entity.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WordDaoImpl implements WordDao{


    @Override
    public boolean insert(Word word) {
        //向数据库写入加密内容
        Connection conn= DbManager.getConnection();
        String sql = "insert into data(userKey,userHash,cword,cipher,time) values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,word.getUserKey());
            ps.setString(2,word.getUserHash());
            ps.setString(3,word.getEpWord());
            ps.setString(4,word.getCipher());
            ps.setString(5,word.getTime());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        DbManager.closeConnection(conn);
        return true;
    }


    public Word search(String userHash) {
        //查询已加密内容
        Connection conn = DbManager.getConnection();
        String sql = "SELECT * FROM `data` where userHash=?";
        PreparedStatement ps = null;
        Word wd = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,userHash);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                wd = new Word();
                wd.setUserKey(rs.getString("userKey"));
                wd.setEpWord(rs.getString("cword"));
                wd.setCipher(rs.getString("cipher"));
                wd.setTime(rs.getString("time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DbManager.closeConnection(conn);
        return wd;
    }

    @Override
    public Word select() {
        Connection conn = DbManager.getConnection();
        String sql = "SELECT * FROM `data`";
        PreparedStatement ps = null;
        Word wd = null;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                wd = new Word();
                wd.setUserKey(rs.getString("userKey"));
                wd.setUserHash(rs.getString("userHash"));
                wd.setEpWord(rs.getString("cword"));
                wd.setCipher(rs.getString("cipher"));
                wd.setTime(rs.getString("time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DbManager.closeConnection(conn);
        return wd;
    }
}
