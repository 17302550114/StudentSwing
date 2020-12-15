package com.geng.student;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageFilter;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;

public class JframeTest extends JFrame {
    JButton jButton;

    public JframeTest() {
        super("this is title");

        jButton = new JButton("this is a button");
        Container contentPane = getContentPane();
        contentPane.add(jButton);

        URL resource = JframeTest.class.getClassLoader().getResource("xiaoji.png");
        Image  image= new ImageIcon(resource).getImage();
        setIconImage(image);
        setSize(600, 400);//px
        /*juzhong*/
        setLocationRelativeTo(null);
        //guanbiyaotuichuchengxu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //daxiaobubian
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JframeTest();
    }
}
