package com.company;

import com.mysql.cj.log.Log;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;

public class Password extends JFrame implements ActionListener {

    JLabel userNameLbl, fullNameLbl, fullNameDisplayLbl, securityQuestionLbl, securityQuestionDisplayLbl, answerLbl, passwordLbl, passwordDisplayLbl;
    JTextField userNametextField, answerTextField;
    JButton searchButton, submitButton, backButton;


    public Password(){
        setLayout(null);
        setBounds(100, 150, 1200, 600);
        setVisible(true);

        BufferedImage initImage = null;
        try{
            initImage = ImageIO.read(getClass().getResource("/resources/images/password.png"));
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Sorry bosh yeh toh nahi chala uwu");
        }
        ImageIcon passwordIcon = new ImageIcon(initImage.getScaledInstance(300,300, Image.SCALE_DEFAULT));
        JLabel passwordImgLbl = new JLabel(passwordIcon);
        passwordImgLbl.setBounds(110, 150, 300, 300);

        //
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 700, 600);
        p1.setBackground(new Color(162,185,216));
        add(p1);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(700, 0, 500, 600 );
        p2.setBackground(Color.white);
        add(p2);

        //adding image to p2
        p2.add(passwordImgLbl);

        //adding labels and textfields
        userNameLbl = new JLabel("Username");
        userNameLbl.setBounds(50, 100, 200, 40);
        userNameLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(userNameLbl);

        userNametextField = new JTextField();
        userNametextField.setBounds(260, 115, 200, 20);
        userNametextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(userNametextField);

        searchButton = new JButton("Search");
        searchButton.setBounds(470, 115, 100, 20);
        searchButton.setBackground(Color.white);
        searchButton.setForeground(new Color(162,185,216));
        searchButton.addActionListener(this);
        p1.add(searchButton);


        fullNameLbl = new JLabel("FullName ");
        fullNameLbl.setBounds(50, 150, 200, 40);
        fullNameLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(fullNameLbl);

        fullNameDisplayLbl = new JLabel();
        fullNameDisplayLbl.setBounds(260, 150, 200, 40);
        fullNameDisplayLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(fullNameDisplayLbl);

        securityQuestionLbl = new JLabel("Security Question ");
        securityQuestionLbl.setBounds(50, 200, 200, 40);
        securityQuestionLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(securityQuestionLbl);

        securityQuestionDisplayLbl = new JLabel("Question display");
        securityQuestionDisplayLbl.setBounds(260, 200, 300, 40);
        securityQuestionDisplayLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(securityQuestionDisplayLbl);

        answerLbl = new JLabel("Enter answer");
        answerLbl.setBounds(50, 250, 200, 40);
        answerLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(answerLbl);

        answerTextField = new JTextField();
        answerTextField.setBounds(260, 265, 200, 20);
        answerTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(answerTextField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(470, 265, 100, 20);
        submitButton.setBackground(Color.white);
        submitButton.setForeground(new Color(162,185,216));
        submitButton.addActionListener(this);
        p1.add(submitButton);

        passwordLbl = new JLabel("Your Password");
        passwordLbl.setBounds(50, 300, 200, 40);
        passwordLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(passwordLbl);

        passwordDisplayLbl = new JLabel("Password display");
        passwordDisplayLbl.setBounds(260, 300, 200, 40);
        passwordDisplayLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(passwordDisplayLbl);

        backButton = new JButton("Back");
        backButton.setBounds(50, 350, 100, 20);
        backButton.setBackground(Color.white);
        backButton.setForeground(new Color(162,185,216));
        backButton.addActionListener(this);
        p1.add(backButton);






    }
    public void actionPerformed(ActionEvent event){
        Conn conn = new Conn();
        Object sourceName = event.getSource();
        if(event.getSource() == searchButton){
            try{
                String query = "Select * from userAccount where userName = '" + userNametextField.getText() + "';";
                ResultSet resultSet = conn.s.executeQuery(query);

                while(resultSet.next()){

                    String fullName = resultSet.getString("fullName");
                    String securityQuestion = resultSet.getString("securityChoice");

                    fullNameDisplayLbl.setText(fullName);
                    securityQuestionDisplayLbl.setText(securityQuestion);
                }
                System.out.println("Chal jaa bc");
            } catch(Exception e){
                e.printStackTrace();
                System.out.println("Sorry bosh yeh toh nahi chala");
            }
        }
        else if(sourceName == submitButton){
            try{
                String query = "Select password from userAccount where answer ='" + answerTextField.getText() +"' and userName ='" + userNametextField.getText()+"';";
                ResultSet resultSet = conn.s.executeQuery(query);

                while(resultSet.next()){
                    String password = resultSet.getString("password");
                    if(password.isEmpty()){
                        answerTextField.setText("Wrong answer");
                    } else {
                        passwordDisplayLbl.setText(password);
                    }
                }
//
            } catch(Exception e){
                e.printStackTrace();
                System.out.println("Kya kar raha hai bhai nahi chala");
            }

        } else if(sourceName == backButton){
            setVisible(false);
            new Login();
        }

    }
    public static void main(String [] args){
        new Password();


    }
}
