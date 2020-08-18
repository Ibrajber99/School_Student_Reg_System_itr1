/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author jber5
 */
public class ImageIntializer {

    public void setImage(String path, JLabel j) {
        ImageIcon ic = new ImageIcon(path);
        j.setIcon(ic);
    }

    public void setImage(String path, JButton j) {
        ImageIcon ic = new ImageIcon(path);
        int w = ic.getIconWidth();
        int h = ic.getIconHeight();
        j.setIcon(ic);
    }
}
