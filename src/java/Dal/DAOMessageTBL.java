/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.MessageTBL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhongFPT
 */
public class DAOMessageTBL {

    public ArrayList<MessageTBL> getInbox(String userName) {
        ArrayList<MessageTBL> list = new ArrayList<>();
        String sql = "select messagetitle,[from],messagetime,isread,messageid\n"
                + "from MessageTBL where [to] = ? order by messagetime";
        Connection conn;
        try {
            conn = new DBContext().getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, userName);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new MessageTBL(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5)));
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOMessageTBL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public MessageTBL checkMessage(int id) {
        //select [from], messagetitle,messagetime,messagecontent from MessageTBL where messageid = 4
        String sql = "select [from], messagetitle,messagetime,messagecontent from MessageTBL where messageid = ?";
        MessageTBL message = null;
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                message = new MessageTBL(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }

        } catch (Exception ex) {
            Logger.getLogger(DAOMessageTBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    public int createMessage(String to, String title, String content, String from) {
        int exe = -1;
        //select [from], messagetitle,messagetime,messagecontent from MessageTBL where messageid = 4
        String sql = "Insert into [MessageTBL] ([messagetitle],[messagetime],[from],[to],[messagecontent],[isread])"
                + "values (?,GETDATE(),?,?,?,0)";
        MessageTBL message = null;
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, title);
            pstm.setString(2, from);
            pstm.setString(3, to);
            pstm.setString(4, content);
            exe = pstm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOMessageTBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exe;
    }

    public ArrayList<String> getReceivedMessageID(String user) {
        ArrayList<String> list = new ArrayList<>();
        Connection conn;
        try {
            conn = new DBContext().getConnection();
            String sql = "select messageid from MessageTBL where [to]=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, user);
            ResultSet rs= pstm.executeQuery();
            while(rs.next()){
                list.add(rs.getString(1));
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOMessageTBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        //select messageid from MessageTBL where [to]='mra'
        return list;
    }
    public int updateRead(int id){
        //update MessageTBL set isread=1 where messageid=2
        String sql="update MessageTBL set isread=1 where messageid=?";
        int exe=-1;
        Connection conn;
        try {
            conn = new DBContext().getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            exe=pstm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAOMessageTBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exe;
    }
    public static void main(String[] args) {
        System.out.println(new DAOMessageTBL().getReceivedMessageID("mra"));
    }
}
