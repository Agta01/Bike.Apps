/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

/**
 *
 * @author Trias Fachrul Z
 */
public class TestConnection {
    public static void main(String[] args) {
       ConnectDB c = new ConnectDB();
       
        System.out.println(c.getConnection());
    }
}
