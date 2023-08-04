package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ViewDestination extends JFrame implements ActionListener, Runnable {

    JButton leftButton, rightButton;
    JLabel imgLbl;
    Thread thread;

    public ViewDestination() {
        thread = new Thread(this);
        setBounds(100, 100, 1200, 800);
        setLayout(null);

        getContentPane().setBackground(Color.gray);

        rightButton = new JButton("RIGHT");
        rightButton.setBounds(10, 400, 10, 10);
        rightButton.setBackground(Color.white);
        rightButton.setForeground(Color.white);
        rightButton.addActionListener(this);

        leftButton = new JButton("LEFT");
        leftButton.setBounds(1170, 400, 10, 10);
        leftButton.setBackground(Color.white);
        leftButton.setForeground(Color.white);
        leftButton.addActionListener(this);
        add(rightButton);
        add(leftButton);

        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("/resources/images/hotel1.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(1200, 800, Image.SCALE_DEFAULT));
        imgLbl = new JLabel(imageIcon);
        imgLbl.setBounds(0, 0, 1200, 800);
        add(imgLbl);

        thread.start();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        BufferedImage image = null;
        int i = 1;
        String source = "/resources/images/hotel" + 3 + ".jpg";
        if (event.getSource() == leftButton) {
            if(i == 2){
                source = "/resources/images/hotel" + 3 + ".jpg";
            } else if(i == 3){source = "/resources/images/hotel" + 4 + ".jpg";}
            else if( i == 4){source = "/resources/images/hotel" + 5 + ".jpg";}
            i++;
            if(i > 4){i = 1;}
            try {

                image = ImageIO.read(getClass().getResource(source));

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(i);




            ImageIcon newimageIcon = new ImageIcon(image.getScaledInstance(1200, 800, Image.SCALE_DEFAULT));
            imgLbl.setIcon(newimageIcon);
            imgLbl.setBounds(0, 0, 1200, 800);
        }

    }
    public void run(){
        int j = 0;
        for(int i = 2; i<11; i++){
            BufferedImage image = null;
            try {

                image = ImageIO.read(getClass().getResource("/resources/images/hotel" + i +".jpg"));


            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(i);

            ImageIcon newimageIcon = new ImageIcon(image.getScaledInstance(1200, 800, Image.SCALE_DEFAULT));
            imgLbl.setIcon(newimageIcon);
            imgLbl.setBounds(0, 0, 1200, 800);
            try{Thread.sleep(1000);}
            catch (Exception e){e.printStackTrace();}
            if(i == 4){
                i = 1;
                j+=1;
            }
            if(j == 2){
                break;
            }

        }
    }

    public static void main(String[] args) {
        new ViewDestination();
    }
}
