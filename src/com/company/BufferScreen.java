package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BufferScreen extends JFrame implements Runnable{
    Thread thread;
    JLabel title;
    JProgressBar progressBar;

    public BufferScreen(){
        thread = new Thread(this);
        setBounds(200, 200, 1200, 600);
        setLayout(null);

        getContentPane().setBackground(Color.GRAY);

        title = new JLabel(" Travel and Tourism Management System");
        title.setLayout(null);
        title.setBounds(400, 50, 450, 100);
        title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        title.setOpaque(true);
        title.setBackground(Color.BLACK);
        title.setForeground(Color.white);
        add(title);

        BufferedImage image = null;
        try{
            image = ImageIO.read(getClass().getResource("/resources/images/travel.jpeg"));
        }
        catch(Exception e){
            System.out.println("Sorry bosh yeh to nahi chala");
        }
        Image scaledImage = image.getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(scaledImage);

        JLabel iconImage = new JLabel(imageIcon);
        iconImage.setBounds(0, 0, 1200, 600);
        ///add(iconImage);
        setVisible(true);

        //
        progressBar = new JProgressBar();
        progressBar.setBounds(500, 200,200, 50 );
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.white);
        progressBar.setOpaque(true);
        progressBar.setValue(0);
        add(progressBar);
        thread.start();

    }

    public void run(){
        try{
            int i = 0;
            while(i <= 100){
                progressBar.setValue(i + 1);
                i += 1;
                Thread.sleep(10);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        if(progressBar.getValue() == 100){
            setVisible(false);
            new Dashboard();
        }
    }


    public static void main(String[] args) {

        new BufferScreen();
    }
}
