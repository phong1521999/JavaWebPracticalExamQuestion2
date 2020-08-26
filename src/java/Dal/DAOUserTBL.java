/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.UserTBL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhongFPT
 */
public class DAOUserTBL {
    public UserTBL getUserTBL(String id, String pass){
        UserTBL user=null;
        String sql="Select * from UserTBL where userid = ? and password = ?";
        try {
            Connection conn= new DBContext().getConnection();
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.setString(2, pass);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                user=new UserTBL(rs.getString(1), rs.getString(2));
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOUserTBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    public ArrayList<UserTBL> getAllUserTBL(){
        ArrayList<UserTBL> list=new ArrayList<>();
        String sql="Select * from UserTBL ";
        try {
            Connection conn= new DBContext().getConnection();
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                list.add(new UserTBL(rs.getString(1), rs.getString(2)));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(DAOUserTBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(new DAOUserTBL().getAllUserTBL());
    }
}
