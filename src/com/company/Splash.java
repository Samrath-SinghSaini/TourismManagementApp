package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

//This is the class that handles the welcome page for the user
//currently displays an image over the full frame
public class Splash extends JFrame {

    public Splash(){

        //Started a basic jframe and added an image
        setTitle("Travel Management System");
        setSize(1200, 600);
        setLocation(200, 100);
        setResizable(true);

        //Created a new image instance and passing it to an image icon after scaling the image to required height/width.
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
        add(iconImage);
        setVisible(true);
    }

    public static void main(String[] args) {

        Splash splash = new Splash();

    }

}
