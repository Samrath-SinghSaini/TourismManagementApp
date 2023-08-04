package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    JLabel titleLbl, userNameLbl, userNameDisplayLbl, packNameLbl, personLbl, numberLbl, numberDisplayLbl, priceLbl, priceDisplayLbl, identityLbl, identityDisplayLbl;
    JTextField personTf;
    JButton checkPriceButton, bookButton, backButton;
    JComboBox packageList;
    Conn conn = new Conn();
    JPanel p1;
    public BookPackage(){
        setBounds(200, 200, 1200, 800);
        setLayout(null);
        setTitle("Book Package");
        getContentPane().setBackground(new Color(125, 185, 182));



        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 600, 800);
        p1.setBackground(Color.white);
        add(p1);




        Font font = new Font("Tahoma", Font.BOLD, 18);

        titleLbl = new JLabel("<HTML><u>BOOK PACKAGE</u></HTML>");
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

        packNameLbl = new JLabel("Choose Pack");
        packNameLbl.setBounds(25, 150, 300, 30);
        packNameLbl.setFont(font);
        p1.add(packNameLbl);

        packageList = new JComboBox(new String [] {"Gold", "Premium", "Millionaire"});
        packageList.setBounds(350, 150, 200, 30);
        p1.add(packageList);


        personLbl = new JLabel("Total People");
        personLbl.setBounds(25, 200, 300, 30);
        personLbl.setFont(font);
        p1.add(personLbl);

        personTf = new JTextField();
        personTf.setBounds(350, 210, 200, 30);
        p1.add(personTf);


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
        priceDisplayLbl.setBounds(350,300, 300, 30);
        priceDisplayLbl.setFont(font);
        p1.add(priceDisplayLbl);


        identityLbl = new JLabel("Identity");
        identityLbl.setBounds(25, 350, 300, 30);
        identityLbl.setFont(font);
        p1.add(identityLbl);

        identityDisplayLbl = new JLabel();
        identityDisplayLbl.setBounds(350,350, 300, 30);
        identityDisplayLbl.setFont(font);
        p1.add(identityDisplayLbl);

        checkPriceButton = new JButton("Check Price");
        checkPriceButton.setBounds(25, 400, 150, 50);
        checkPriceButton.setForeground(Color.white);
        checkPriceButton.setBackground(Color.black);
        p1.add(checkPriceButton);
        checkPriceButton.setFont(font);
        checkPriceButton.addActionListener(this);

        bookButton = new JButton("Book");
        bookButton.setBounds(200, 400, 150, 50);
        bookButton.setForeground(Color.white);
        bookButton.setBackground(Color.black);
        p1.add(bookButton);
        bookButton.addActionListener(this);

        bookButton.setFont(font);

        backButton = new JButton("Back");
        backButton.setBounds(375, 400, 150, 50);
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
        try{customerBI = ImageIO.read(getClass().getResource("/resources/images/newcustomer1.png"));}
        catch(Exception e){
            e.printStackTrace();
        }

        ImageIcon customerIcon = new ImageIcon(customerBI.getScaledInstance(450,550, Image.SCALE_DEFAULT ));
        JLabel customerImageLbl = new JLabel(customerIcon);
        customerImageLbl.setBounds(0, 50,customerIcon.getIconWidth(), customerIcon.getIconHeight());
        p2.add(customerImageLbl);

        //
        userNameDisplayLbl.setText(conn.getUserName());
        String query = "Select * from userDetails where userName = '"+ userNameDisplayLbl.getText()+ "';";
        ResultSet resultSet = null;
        try{
           resultSet = conn.s.executeQuery(query);
           while(resultSet.next()) {
               String number = resultSet.getString("phoneNumber");
               numberDisplayLbl.setText(number);
               identityDisplayLbl.setText(resultSet.getString("identification"));
           }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Errorrrrrrrrrr");
        }









        setVisible(true);
    }
    public void actionPerformed(ActionEvent event){

        if (event.getSource() == checkPriceButton){
           setPrice();
        }
        else if(event.getSource() == bookButton){
            setPrice();
            //create table bookedPackages(userName varchar(50), packName varchar (255), numOfPeople varchar (50), phoneNumber varchar (255), identity varchar(255), price varchar (255));
            String query = "Insert into userDetails (userName, packName, numOfPeople, phoneNumber, identity, price)values ('" + userNameDisplayLbl.getText()+ "','" + packageList.getSelectedItem() +  "','" + personTf.getText()+  "','" + numberDisplayLbl.getText()+  "','" + identityDisplayLbl.getText()+  "','" + priceDisplayLbl.getText() +  "'); ";
            ResultSet resultSet = null;
            try{
                 conn.s.executeUpdate(query);
                 JOptionPane successMessage = new JOptionPane("Your package has been booked successfully");
                 successMessage.setBounds(500, 300, 200, 100);
                 p1.add(successMessage);
                JOptionPane.showMessageDialog(null, "Package booked successfully");
                 setVisible(false);
                 new ViewBookedPackage();
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("Errrrrorrrrrr");
            }
        }
        else if(event.getSource() == backButton){
            new Dashboard();
            setVisible(false);
        }
    }

    public void setPrice(){
        String selectedPackage = (String)packageList.getSelectedItem();
        int price = 0;
        int numOfPeople = 0;
        try{numOfPeople = Integer.parseInt(personTf.getText()); }
        catch (Exception e){personTf.setText("Invalid Input");}
        if(selectedPackage.equals("Gold")){
            price = numOfPeople*10000;
            priceDisplayLbl.setText("Rs " + price);
        } else if(selectedPackage.equals("Premium")){
            price = numOfPeople*20000;
            priceDisplayLbl.setText("Rs " + price);
        } else if(selectedPackage.equals("Millionaire")){
            price = numOfPeople*50000;
            priceDisplayLbl.setText("Rs " + price);
        }
    }
    public static void main(String[] args) {
 new BookPackage();

    }
}
