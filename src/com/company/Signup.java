package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Signup extends JFrame implements ActionListener {

    //Declaring global variables for the labels and textfields
    JLabel fullNameLbl, userNameLbl, passwordLbl, emailLbl, securityLbl, answerLbl;
    JTextField fullnameTextField, usernameTextField, passwordTextField, emailTextField, answerTextField;
    Choice securityChoice;
    JButton submitButton;
    JButton backButton;
    String fullName, userName, password, email, security, answer;
    public Signup(){

        setBounds(200, 100, 1200, 600);
        setLayout(null);
        getContentPane().setBackground(new Color(162,185,216));

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 600, 600);
        p1.setBackground(Color.white);
        add(p1);


        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(600, 0, 600, 600);
        p2.setBackground(new Color(162,185,216));
        add(p2);

        BufferedImage signupImg = null;

        try{
            signupImg = ImageIO.read(getClass().getResource("/resources/images/signup.png"));
        }
        catch(Exception e){
            System.out.println("Sorry bosh yeh to nahi chala uwu");
            System.out.println(e);
        }
        ImageIcon signupImgIcon = new ImageIcon(signupImg.getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        JLabel signupImgLabel = new JLabel(signupImgIcon);
        signupImgLabel.setBounds(150, 130, 300, 300);
        p1.add(signupImgLabel);

        //adding labels and text fields for p2

        fullNameLbl = new JLabel("Full name: ");
        fullNameLbl.setBounds(50 , 50, 200, 40);
        fullNameLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p2.add(fullNameLbl);

        fullnameTextField = new JTextField();
        fullnameTextField.setBounds(260, 55, 200, 20);
        p2.add(fullnameTextField);

        //Adding textfields for the labels and answers

        userNameLbl = new JLabel("Username");
        userNameLbl.setBounds(50 , 100, 200, 40);
        userNameLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p2.add(userNameLbl);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(260, 105, 200, 20);
        p2.add(usernameTextField);

        passwordLbl = new JLabel("Password");
        passwordLbl.setBounds(50 , 150, 200, 40);
        passwordLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p2.add(passwordLbl);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(260, 155, 200, 20);
        p2.add(passwordTextField);

        emailLbl = new JLabel("Email:");
        emailLbl.setBounds(50 , 200, 200, 40);
        emailLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p2.add(emailLbl);

        emailTextField = new JTextField();
        emailTextField.setBounds(260, 205, 200, 20);
        p2.add(emailTextField);


        securityLbl = new JLabel("Security Question: ");
        securityLbl.setBounds(50 , 250, 200, 40);
        securityLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p2.add(securityLbl);

        securityChoice = new Choice();
        securityChoice.add("Choose a security question: ");
        securityChoice.add("What was the name of your first pet?");
        securityChoice.add("What is your favourite movie? ");
        securityChoice.add("Sach batao mai dikhne mei cute lagta hu kya?");
        securityChoice.add("What is your dream car? ");
        securityChoice.add("Maat pita ka naam");
        securityChoice.add("Kahan paida hue the?");
        securityChoice.setBounds(260, 265, 300, 40);
        p2.add(securityChoice);

        answerLbl = new JLabel("Answer:  ");
        answerLbl.setBounds(50 , 300, 200, 40);
        answerLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p2.add(answerLbl);

        answerTextField = new JTextField();
        answerTextField.setBounds(260, 305, 200, 20);
        p2.add(answerTextField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(155, 375, 130, 30);
        submitButton.setBackground(new Color(162,185,216));
        submitButton.setForeground(Color.white);
        submitButton.setBorder(new LineBorder(Color.white));
        submitButton.addActionListener(this);
        p2.add(submitButton);

        backButton = new JButton("Back");
        backButton.setBounds(300, 375, 130, 30);
        backButton.setBackground(new Color(162,185,216));
        backButton.setForeground(Color.white);
        backButton.setBorder(new LineBorder(Color.white));
        backButton.addActionListener(this);
        p2.add(backButton);








        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == submitButton){

             fullName = fullnameTextField.getText();
             userName = usernameTextField.getText();
             password = passwordTextField.getText();
             email = emailTextField.getText();
             security = securityChoice.getSelectedItem();
             answer = answerTextField.getText();

            //Creating a string with the SQL insert query to add the details from the sign up page to our sql database and table
            //table name is userAccount
            //we use the conn class to execute the query and add the details to the table in mysql and then show a pop up confirming the account set up and load the login page.
            String query = "insert into userAccount values('"+fullName+"','"+userName+"','"+password+"','"+email+"','"+security+"','"+answer+"');";
            Conn c = new Conn();
            try{
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details saved\nYour account has been successfully created.");
                setVisible(false);
                new Login();
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Sorry bosh yeh toh nahi chala");
            }

        } else if(event.getSource() == backButton){
            setVisible(false);
            new Login();
            System.out.println("bosh yeh toh chal gaya");

        }
    }
    public static void main(String[] args) {
        Signup signup = new Signup();
    }
}
