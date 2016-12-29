/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import View.Logins;
import Model.UserModel;

/**
 *
 * @author sulistiana
 */
public class LoginControl {
    private final Logins l = new Logins();
    private final UserModel uM = new UserModel();
    
    public Boolean login(String username, String password) {
        uM.setUsername(username);
        uM.setPassword(password);
        if (!username.isEmpty()) {
            if (!password.isEmpty()) {
                switch (uM.login()) {
                    case "manager":
//                        mM.setVisible(true);
//                        l.dispose();
                        JOptionPane.showMessageDialog(l, "Success ini manager!!");
                        return true;
                    
                    default:
                        JOptionPane.showMessageDialog(l, "Username atau Password salah");
                        return false;
                }
            } else {
                JOptionPane.showMessageDialog(l, "Password harus diisi");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(l, "Username harus diisi");
            return false;
        }

    }

    public void setFrameIcon(Logins login) {
        try {
            final List<Image> icons = new ArrayList<Image>();
            File file16 = new File("lib/BikeApps16.png");
            File file32 = new File("lib/BikeApps32.png");
            
            
            icons.add(ImageIO.read(file16));
            icons.add(ImageIO.read(file32));
            login.setIconImages(icons);
        } catch (Exception e) {
            System.out.println("e : " + e);
        }
    }
}
