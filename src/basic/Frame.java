package basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    Frame(){
        this.setBounds(100,100,800,550);
        this.setTitle("FarmApp");
        ImageIcon picture = new ImageIcon("img.png");
        this.setIconImage(picture.getImage());
        this.getContentPane().setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
