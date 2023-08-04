package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;

public class DeleteCustomer extends JFrame implements ActionListener {
    JLabel userNameLbl, userNameDisplayLbl, fullNameLbl, fullNameDisplayLbl, ageLbl, ageDisplayLbl, numberLbl, numberDisplayLbl, genderLbl, genderDisplayLbl, countryLbl, countryDisplayLbl, addressLbl, addressDisplayLbl, emailLbl, emailDisplayLbl, identificationLbl, identificationDisplayLbl, errorLbl, errorDisplayLbl;
    JButton homeBtn, deleteBtn;
    Conn conn = new Conn();

    public DeleteCustomer(){
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Delete customer details");
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        // new Color(236,242,255)
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0  , 1000, 1000);
        p1.setBackground(new Color(222, 245, 229));
        add(p1);


        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(1000, 0, 600, 1000);
        p2.setBackground(Color.DARK_GRAY);
        add(p2);



        BufferedImage customerBI = null;
        try{customerBI = ImageIO.read(getClass().getResource("/resources/images/newCustomer1.png"));}
        catch(Exception e){
            e.printStackTrace();
        }

        ImageIcon customerIcon = new ImageIcon(customerBI.getScaledInstance(450,550, Image.SCALE_DEFAULT ));
        JLabel customerImageLbl = new JLabel(customerIcon);
        customerImageLbl.setBounds(50, 200,customerIcon.getIconWidth(), customerIcon.getIconHeight());
        p2.add(customerImageLbl);

        userNameLbl = new JLabel("Username");
        userNameLbl.setBounds(50, 150, 200, 50);
        userNameLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(userNameLbl);


        userNameDisplayLbl = new JLabel("");
        userNameDisplayLbl.setBounds(260, 150, 200, 50);
        userNameDisplayLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(userNameDisplayLbl);
        userNameDisplayLbl.setText(conn.getUserName());

        fullNameLbl = new JLabel("Fullname");
        fullNameLbl.setBounds(50, 200, 200, 50);
        fullNameLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(fullNameLbl);

        fullNameDisplayLbl = new JLabel("");
        fullNameDisplayLbl.setBounds(260, 200, 200, 50);
        fullNameDisplayLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(fullNameDisplayLbl);

        ageLbl = new JLabel("Age");
        ageLbl.setBounds(50, 250, 200, 50);
        ageLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(ageLbl);

        ageDisplayLbl = new JLabel();
        ageDisplayLbl.setBounds(260, 250, 100, 50);
        ageDisplayLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(ageDisplayLbl);

        numberLbl = new JLabel("Phone number");
        numberLbl.setBounds(50, 300, 200, 50);
        numberLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(numberLbl);

        numberDisplayLbl = new JLabel();
        numberDisplayLbl.setBounds(260, 300, 100, 50);
        numberDisplayLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(numberDisplayLbl);


        genderLbl = new JLabel("Gender");
        genderLbl.setBounds(50, 350, 200, 50);
        genderLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(genderLbl);

        genderDisplayLbl = new JLabel("");
        genderDisplayLbl.setBounds(260, 350, 100, 50);
        genderDisplayLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(genderDisplayLbl);

        countryLbl = new JLabel("Country");
        countryLbl.setBounds(50, 400, 200, 50);
        countryLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(countryLbl);

        countryDisplayLbl = new JLabel("");
        countryDisplayLbl.setBounds(260, 400, 200, 50);
        countryDisplayLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(countryDisplayLbl);




        addressLbl = new JLabel("Address");
        addressLbl.setBounds(50, 450, 200, 50);
        addressLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(addressLbl);


        addressDisplayLbl = new JLabel();
        addressDisplayLbl.setBounds(260, 450, 500, 50);
        addressDisplayLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(addressDisplayLbl);


        emailLbl = new JLabel("Email");
        emailLbl.setBounds(50, 500, 500, 50);
        emailLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(emailLbl);

        emailDisplayLbl = new JLabel();
        emailDisplayLbl.setBounds(260, 500, 500, 50);
        emailDisplayLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(emailDisplayLbl);


        identificationLbl = new JLabel("Identification");
        identificationLbl.setBounds(50, 550, 200, 50);
        identificationLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(identificationLbl);


        identificationDisplayLbl = new JLabel();
        identificationDisplayLbl.setBounds(260, 550, 200, 50);
        identificationDisplayLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(identificationDisplayLbl);

        homeBtn = new JButton("Home");
        homeBtn.setBounds(50, 650, 100, 25);
        homeBtn.setBackground(Color.gray);
        homeBtn.setForeground(new Color(222, 245, 229));
        p1.add(homeBtn);
        homeBtn.addActionListener(this);


        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(260, 650, 100, 25);
        deleteBtn.setBackground(Color.gray);
        deleteBtn.setForeground(new Color(222, 245, 229));
        p1.add(deleteBtn);
        deleteBtn.addActionListener(this);
        setVisible(true);

        try{

            String query = "Select * from userDetails where userName = '" + userNameDisplayLbl.getText()+ "';";
            ResultSet resultSet = conn.s.executeQuery(query);
            while(resultSet.next()){
                fullNameDisplayLbl.setText(resultSet.getString("fullName"));
                ageDisplayLbl.setText(resultSet.getString("age"));
                numberDisplayLbl.setText(resultSet.getString("phoneNumber"));
                genderDisplayLbl.setText(resultSet.getString("gender"));
                countryDisplayLbl.setText(resultSet.getString("country"));
                addressDisplayLbl.setText(resultSet.getString("address"));
                emailDisplayLbl.setText(resultSet.getString("email"));
                identificationDisplayLbl.setText(resultSet.getString("identification"));


            }
        }
        catch (Exception e){e.printStackTrace();}



    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == homeBtn){
            setVisible(false);
            new Dashboard();
        } else if(event.getSource() == deleteBtn){
            String query = "Delete * from userDetails where userName = '" + userNameDisplayLbl.getText()+ "'; ";
            try{
                conn.s.executeQuery(query);
                System.out.println("Deleted successfully");
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
            }
            catch(Exception e){
                e.printStackTrace();
                System.out.println("Cannot delete");
            }
            setVisible(false);
            new Dashboard();
        }
    }

    public static void main(String[] args) {
        new DeleteCustomer();

    }
}
