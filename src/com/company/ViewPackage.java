package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ViewPackage extends JFrame implements ActionListener {
    ///    ///titleLbl, packNameLbl, durationLbl, destinationLbl, activitiesLbl, mealLbl, drinksLbl, flightLbl, priceLbl;

    String[] package1 = {"GOLD PACKAGE", "3 nights 4 days", "Bali, Indonesia", "Scuba Diving, Boating, sightseeing", "Discounted Meals", "Soft Drinks Free", "Deals on flights", "RS 10000", "package1.jpg"};
    String[] package2 = {"PLATINUM PACKAGE", "5 nights 6 days", "Venice, Italy", "City Tours, Boating, sightseeing", "Half off Meals", "Hard Drinks Discounted", "Returned flights free", "RS 30000", "package2.jpg"};
    String[] package3 = {"TITANIUM PACKAGE", "8 nights 9 days", "Tosh, Himachal Pradesh", "Spiritual Experience, Trekking, sightseeing", "Free Meals", "Alcohol and Substances free", "Deals on flights", "RS 6000", "package3.jpg"};


    public ViewPackage(){

        setTitle("View Package");
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(new Color(39, 55, 77));

        JPanel p1 = getJPanel(package1);
        JPanel p2 = getJPanel(package2);
        JPanel p3 = getJPanel(package3);

        JTabbedPane tab = new JTabbedPane();
        tab.addTab("Package 1", null, p1);
        tab.addTab("Package 2", null, p2);
        tab.addTab("Package 3", null, p3);
        tab.setBackground(Color.white);
        tab.setBounds(0, 0, 1600, 1000);
        add(tab);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent event){

    }

    public JPanel getJPanel(String [] array){
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0, 0, 1600, 1000);
        p.setBackground(new Color(39, 55, 77));
        add(p);

        JLabel titleLbl, packNameLbl, durationLbl, destinationLbl, activitiesLbl, mealLbl, drinksLbl, flightLbl, priceLbl;
        Font font = new Font("Tahoma", Font.BOLD, 20);

        titleLbl = new JLabel("<HTML><u>BOOK PACKAGE</u></HTML>");
        titleLbl.setBounds(25, 25, 500, 75);
        titleLbl.setFont(font);
        titleLbl.setForeground(Color.white);
        p.add(titleLbl);

        packNameLbl = new JLabel(array[0]);
        packNameLbl.setBounds(25, 100, 300, 30);
        packNameLbl.setFont(font);
        packNameLbl.setForeground(Color.white);

        p.add(packNameLbl);

        durationLbl = new JLabel(array[1]);
        durationLbl.setBounds(30, 200, 500, 50);
        durationLbl.setFont(font);
        durationLbl.setForeground(Color.white);
        p.add(durationLbl);

        destinationLbl = new JLabel(array[2]);
        destinationLbl.setBounds(30, 250, 500, 50);
        destinationLbl.setFont(font);
        destinationLbl.setForeground(Color.white);
        p.add(destinationLbl);

        activitiesLbl = new JLabel(array[3]);
        activitiesLbl.setBounds(30, 300, 500, 50);
        activitiesLbl.setFont(font);
        activitiesLbl.setForeground(Color.white);
        p.add(activitiesLbl);

        mealLbl = new JLabel(array[4]);
        mealLbl.setBounds(30, 350, 500, 50);
        mealLbl.setFont(font);
        mealLbl.setForeground(Color.white);
        p.add(mealLbl);

        drinksLbl = new JLabel(array[5]);
        drinksLbl.setBounds(30, 400, 500, 50);
        drinksLbl.setFont(font);
        drinksLbl.setForeground(Color.white);
        p.add(drinksLbl);

        flightLbl = new JLabel(array[6]);
        flightLbl.setBounds(35, 450, 500, 50);
        flightLbl.setFont(font);
        flightLbl.setForeground(Color.white);
        p.add(flightLbl);

        priceLbl = new JLabel(array[7]);
        priceLbl.setBounds(40, 500, 500, 50);
        priceLbl.setFont(font);
        priceLbl.setForeground(Color.white);
        p.add(priceLbl);


        BufferedImage customerBI = null;
        try{customerBI = ImageIO.read(getClass().getResource("/resources/images/" + array[8]));}
        catch(Exception e){
            e.printStackTrace();
        }

        ImageIcon customerIcon = new ImageIcon(customerBI.getScaledInstance(450,550, Image.SCALE_DEFAULT ));
        JLabel customerImageLbl = new JLabel(customerIcon);
        customerImageLbl.setBounds(800, 50,customerIcon.getIconWidth(), customerIcon.getIconHeight());
        p.add(customerImageLbl);












        return p;
    }


    public static void main(String [] args){
        new ViewPackage();
    }

}
