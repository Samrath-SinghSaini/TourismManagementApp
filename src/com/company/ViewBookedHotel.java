package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {
    JLabel titleLbl, userNameLbl, userNameDisplayLbl, hotelNameLbl, hotelNameDisplayLbl, personLbl, personDisplayLbl, numberLbl, numberDisplayLbl, priceLbl, priceDisplayLbl, identityLbl, identityDisplayLbl, durationLbl, durationDisplayLbl;
    JButton backButton;
    Conn conn = new Conn();
    JPanel p1, p2;

    public ViewBookedHotel() {
        setBounds(200, 200, 1200, 800);
        setLayout(null);
        setTitle("Your Booked Hotel");
        getContentPane().setBackground(new Color(125, 185, 182));


        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 600, 800);
        p1.setBackground(Color.white);
        add(p1);


        Font font = new Font("Tahoma", Font.BOLD, 18);

        titleLbl = new JLabel("<HTML><u>Your Booked Packages</u></HTML>");
        titleLbl.setBounds(25, 25, 500, 75);
        titleLbl.setFont(font);
        titleLbl.setForeground(new Color(255, 243, 35));
        p1.add(titleLbl);

        userNameLbl = new JLabel("Username");
        userNameLbl.setBounds(25, 100, 300, 30);
        userNameLbl.setFont(font);
        userNameLbl.setForeground(Color.BLACK);
        p1.add(userNameLbl);

        userNameDisplayLbl = new JLabel();
        userNameDisplayLbl.setBounds(350, 100, 300, 30);
        userNameDisplayLbl.setFont(font);
        userNameDisplayLbl.setForeground(Color.BLACK);
        p1.add(userNameDisplayLbl);

        hotelNameLbl = new JLabel("Choose Pack");
        hotelNameLbl.setBounds(25, 150, 300, 30);
        hotelNameLbl.setFont(font);
        p1.add(hotelNameLbl);

        hotelNameDisplayLbl = new JLabel();
        hotelNameDisplayLbl.setBounds(25, 150, 300, 30);
        hotelNameDisplayLbl.setFont(font);
        p1.add(hotelNameDisplayLbl);

        personLbl = new JLabel("Total People");
        personLbl.setBounds(25, 200, 300, 30);
        personLbl.setFont(font);
        p1.add(personLbl);

        personDisplayLbl = new JLabel();
        personDisplayLbl.setBounds(25, 200, 300, 30);
        personDisplayLbl.setFont(font);
        p1.add(personDisplayLbl);

        numberLbl = new JLabel("Phone number");
        numberLbl.setBounds(25, 250, 300, 30);
        numberLbl.setFont(font);
        p1.add(numberLbl);

        numberDisplayLbl = new JLabel();
        numberDisplayLbl.setBounds(350, 250, 300, 30);
        numberDisplayLbl.setFont(font);
        numberDisplayLbl.setForeground(Color.BLACK);
        p1.add(numberDisplayLbl);

        priceLbl = new JLabel("Price");
        priceLbl.setBounds(25, 300, 300, 30);
        priceLbl.setFont(font);
        p1.add(priceLbl);

        priceDisplayLbl = new JLabel();
        priceDisplayLbl.setBounds(350, 300, 300, 30);
        priceDisplayLbl.setFont(font);
        p1.add(priceDisplayLbl);

        durationLbl = new JLabel("Duration");
        durationLbl.setBounds(25, 300, 350, 30);
        durationLbl.setFont(font);
        p1.add(durationLbl);

        durationDisplayLbl = new JLabel();
        durationDisplayLbl.setBounds(350, 350, 300, 30);
        durationDisplayLbl.setFont(font);
        p1.add(durationDisplayLbl);




        identityLbl = new JLabel("Identity");
        identityLbl.setBounds(25, 400, 300, 30);
        identityLbl.setFont(font);
        p1.add(identityLbl);

        identityDisplayLbl = new JLabel();
        identityDisplayLbl.setBounds(350, 400, 300, 30);
        identityDisplayLbl.setFont(font);
        p1.add(identityDisplayLbl);



        backButton = new JButton("Back");
        backButton.setBounds(375, 450, 150, 50);
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.black);
        backButton.setFont(font);
        p1.add(backButton);
        backButton.addActionListener(this);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(600, 0, 600, 800);
        p2.setBackground(Color.white);
        add(p2);

        BufferedImage customerBI = null;
        try {
            customerBI = ImageIO.read(getClass().getResource("/resources/images/newcustomer1.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon customerIcon = new ImageIcon(customerBI.getScaledInstance(450, 550, Image.SCALE_DEFAULT));
        JLabel customerImageLbl = new JLabel(customerIcon);
        customerImageLbl.setBounds(0, 50, customerIcon.getIconWidth(), customerIcon.getIconHeight());
        p2.add(customerImageLbl);

        userNameDisplayLbl.setText(conn.getUserName());
        try{
            String query = "Select * from bookedHotels where userName = '" + conn.getUserName() + "';";
            ResultSet resultSet = conn.s.executeQuery(query);
            while(resultSet.next()){
                hotelNameDisplayLbl.setText(resultSet.getString("packName"));
                personDisplayLbl.setText(resultSet.getString("numOfPeople"));
                numberDisplayLbl.setText(resultSet.getString("number"));
                priceDisplayLbl.setText(resultSet.getString("price"));
                identityDisplayLbl.setText(resultSet.getString("identification"));
                durationDisplayLbl.setText(resultSet.getString("duration"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event){

        if(event.getSource() == backButton){
            setVisible(false);
            new Dashboard();
        }
    }

    public static void main(String[] args) {
        new ViewBookedHotel();
    }
}
