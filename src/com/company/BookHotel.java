package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {
    JLabel userNameLbl, userNameDisplayLbl, hotelNameLbl, peopleLbl, durationLbl, identificationLbl, identificationDisplayLbl, numberLbl, numberDisplayLbl, priceLbl, priceDisplayLbl, title;
    JTextField peopleTf, durationTf;
    JComboBox hotelChoice;
    JButton bookHotel, backButton, checkPrice;
    Conn conn = new Conn();
    JPanel p1;
    public BookHotel(){
        setBounds(0,0, 1200, 800);
        setLayout(null);
        getContentPane().setBackground(Color.white);


        p1 = new JPanel();
        p1.setBounds(0,0, 600, 800);
        p1.setLayout(null);
        add(p1);

        JPanel p2 = new JPanel();
        p2.setBounds(600, 0, 600, 800);
        p2.setLayout(null);
        add(p2);
        Font font = new Font("Tahoma", Font.PLAIN, 18);

        title = new JLabel("Book Hotel");
        title.setBounds(200, 25,300, 30 );
        title.setFont(font);
        p1.add(title);

        userNameLbl = new JLabel("Username");
        userNameLbl.setBounds(25, 150,250, 30 );
        userNameLbl.setFont(font);
        p1.add(userNameLbl);

        userNameDisplayLbl = new JLabel();
        userNameDisplayLbl.setBounds(300, 150,250, 30 );
        userNameDisplayLbl.setFont(font);
        p1.add(userNameDisplayLbl);

        hotelNameLbl = new JLabel("Hotel");
        hotelNameLbl.setBounds(25, 200,250, 30 );
        hotelNameLbl.setFont(font);
        p1.add(hotelNameLbl);

        hotelChoice = new JComboBox(new String [] {"Marriot", "Radisson", "Taj", "Collesium"});
        hotelChoice.setBounds(300, 210, 200, 20);
        p1.add(hotelChoice);

        peopleLbl = new JLabel("People");
        peopleLbl.setBounds(25, 250,250, 30 );
        peopleLbl.setFont(font);
        p1.add(peopleLbl);

        peopleTf = new JTextField();
        peopleTf.setBounds(300, 260, 250, 20);
        p1.add(peopleTf);

        durationLbl = new JLabel("Duration");
        durationLbl.setBounds(25, 300,250, 30 );
        durationLbl.setFont(font);
        p1.add(durationLbl);

        durationTf = new JTextField();
        durationTf.setBounds(300, 310, 250, 20);
        p1.add(durationTf);

        priceLbl = new JLabel("Price");
        priceLbl.setBounds(25, 350,250, 30 );
        priceLbl.setFont(font);
        p1.add(priceLbl);

        priceDisplayLbl = new JLabel();
        priceDisplayLbl.setBounds(300, 350,250, 30 );
        priceDisplayLbl.setFont(font);
        p1.add(priceDisplayLbl);

        identificationLbl = new JLabel("Identification");
        identificationLbl.setBounds(25, 400,250, 30 );
        identificationLbl.setFont(font);
        p1.add(identificationLbl);

        identificationDisplayLbl = new JLabel();
        identificationDisplayLbl.setBounds(300, 400,250, 30 );
        identificationDisplayLbl.setFont(font);
        p1.add(identificationDisplayLbl);

        numberLbl = new JLabel("Number");
        numberLbl.setBounds(25, 450,250, 30 );
        numberLbl.setFont(font);
        p1.add(numberLbl);

        numberDisplayLbl = new JLabel();
        numberDisplayLbl.setBounds(300, 450,250, 30 );
        numberDisplayLbl.setFont(font);
        p1.add(numberDisplayLbl);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(10, 500, 250, 30);
        bookHotel.setForeground(Color.white);
        bookHotel.setBackground(Color.black);
        bookHotel.setFont(font);
        p1.add(bookHotel);
        bookHotel.addActionListener(this);


        backButton = new JButton("Back");
        backButton.setBounds(300, 500, 250, 30);
        backButton.setForeground(Color.white);
        backButton.setBackground(Color.black);
        backButton.setFont(font);
        p1.add(backButton);
        backButton.addActionListener(this);

        checkPrice = new JButton("Check Price");
        checkPrice.setBounds(10, 550, 250, 30);
        checkPrice.setForeground(Color.white);
        checkPrice.setBackground(Color.black);
        checkPrice.setFont(font);
        p1.add(checkPrice);
        checkPrice.addActionListener(this);

        userNameDisplayLbl.setText(conn.getUserName());

        try{
            String query = "Select * from userDetails where userName = '" + userNameDisplayLbl.getText() + "'; ";
            ResultSet resultSet = conn.s.executeQuery(query);
            while(resultSet.next()){
            identificationDisplayLbl.setText(resultSet.getString("identification"));
            numberDisplayLbl.setText(resultSet.getString("phoneNumber"));}

        } catch (Exception e){
            e.printStackTrace();
        }



        setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == bookHotel){
            setPrice();
            String query = "insert into bookedHotels (userName, hotelName, numofPeople, duration, identification, number, price) values ('" + userNameDisplayLbl.getText()+ "','" + hotelChoice.getSelectedItem() + "','" + peopleTf.getText() + "','" + durationTf.getText()+ "','" + identificationDisplayLbl.getText() + "','" + numberDisplayLbl.getText()+ "','" + priceDisplayLbl.getText() + "');";


            try{
            conn.s.executeUpdate(query);
            /*JOptionPane successMsg = new JOptionPane("Booked Successfully");
            successMsg.setBounds(0, 350, 100, 100);
            p1.add(successMsg);*/

                JOptionPane.showMessageDialog(null, "Hotel has been booked successfully");
                setVisible(false);
                new Dashboard();

            }
            catch(Exception e){
                e.printStackTrace();
            }


        }
        else if(event.getSource() == backButton){
            setVisible(false);
            new Dashboard();
        }
        else if(event.getSource() == checkPrice){
        setPrice();
        }


    }

    public void setPrice(){
        String selectedPackage = (String)hotelChoice.getSelectedItem();
        int price = 0;
        int numOfPeople = 0;
        int duration = 0;
        try{
            numOfPeople = Integer.parseInt(peopleTf.getText());
            duration =  Integer.parseInt(durationTf.getText());
        }
        catch (Exception e){peopleTf.setText("Invalid Input");}
        if(selectedPackage.equals("Collesium")){
            price = numOfPeople*1000*duration;
            priceDisplayLbl.setText("Rs " + price);
        } else if(selectedPackage.equals("Marriot")){
            price = numOfPeople*2000*duration;
            priceDisplayLbl.setText("Rs " + price);
        } else if(selectedPackage.equals("Taj")){
            price = numOfPeople*5000*duration;
            priceDisplayLbl.setText("Rs " + price);
        } else if(selectedPackage.equals("Radisson")){
            price = numOfPeople*3000*duration;
            priceDisplayLbl.setText("Rs " + price);
        }
    }

    public static void main(String[] args) {

        new BookHotel();
    }
}
