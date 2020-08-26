/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PhongFPT
 */
public class UserTBL {
    String id,pass;

    public UserTBL(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    public UserTBL() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "UserTBL{" + "id=" + id + ", pass=" + pass + '}';
    }
    
}
