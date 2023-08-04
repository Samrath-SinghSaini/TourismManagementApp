package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField userNameTf, passwordTf;
    JButton loginButton, registerButton, forgotPassButton;
    JLabel errorLbl;
    private String userName;

    public String getUserName(){
        return userName;
    }
    //Signup signup = new Signup();
     public Login (){
         //created a basic frame and removed default swing layout

         setSize(1200, 600);
         setLocation(200, 100);
         setLayout(null);
         getContentPane().setBackground(Color.black);
         //Added a jpanel and created new layout
         JPanel p1 = new JPanel();
         p1.setLayout(null);
         p1.setBounds(0, 0, 600, 600);
         p1.setBackground(new Color(162,185,216));
         add(p1);

         //adding an image to the login panel
         BufferedImage loginImage = null;
         try{
             loginImage = ImageIO.read(getClass().getResource("/resources/images/login.png"));
         }
         catch(Exception e){
             System.out.println("Sorry bosh yeh to nahi chala uwu");
             System.out.println(e);
         }
         ImageIcon loginIcon = new ImageIcon(loginImage.getScaledInstance(300, 300, Image.SCALE_DEFAULT));
         JLabel loginImageLabel = new JLabel(loginIcon);
         loginImageLabel.setBounds(170,150, 200, 200);
         p1.add(loginImageLabel);

         //Creating right panel
         JPanel p2 = new JPanel();
         p2.setLayout(null);
         p2.setBounds(600, 0, 600, 600);
         add(p2);

         //adding labels and buttons
         JLabel userNameLbl = new JLabel("Username: ");
         userNameLbl.setBounds(100, 50, 130, 40);
         userNameLbl.setFont(new Font("San serif", Font.PLAIN, 20));
         p2.add(userNameLbl);

         userNameTf = new JTextField();
         userNameTf.setBounds(100, 110, 300, 30);
         p2.add(userNameTf);


         JLabel passwordLbl = new JLabel("Password: ");
         passwordLbl.setBounds(100, 160, 130, 40);
         passwordLbl.setFont(new Font("San serif", Font.PLAIN, 20));
         p2.add(passwordLbl);

         passwordTf = new JTextField();
         passwordTf.setBounds(100, 220, 300, 30);
         p2.add(passwordTf);

         loginButton = new JButton("Login");
         loginButton.setBounds(100, 280, 130, 30);
         loginButton.setBackground(new Color(162,185,216));
         loginButton.setForeground(Color.white);
         loginButton.setBorder(new LineBorder(Color.white));
         loginButton.addActionListener(this);
         p2.add(loginButton);

         registerButton = new JButton("Register");
         registerButton.setBounds(250, 280, 130, 30);
         registerButton.setBackground(new Color(162,185,216));
         registerButton.setForeground(Color.white);
         registerButton.setBorder(new LineBorder(Color.white));
         registerButton.addActionListener(this);
         p2.add(registerButton);

         forgotPassButton = new JButton("Forgot Password?");
         forgotPassButton.setBounds(175, 330, 130, 30);
         forgotPassButton.setBackground(new Color(162,185,216));
         forgotPassButton.setForeground(Color.white);
         forgotPassButton.setBorder(new LineBorder(Color.white));
         forgotPassButton.addActionListener(this);
         p2.add(forgotPassButton);


         errorLbl = new JLabel("");
         errorLbl.setBounds(330, 330, 130, 30);
         errorLbl.setForeground(Color.red);
         p2.add(errorLbl);






         setVisible(true);
     }

    @Override
    public void actionPerformed(ActionEvent event){
         Conn conn = new Conn();
         if(event.getSource() == loginButton){
             try{
                String query = "Select * from userAccount where userName = '" + userNameTf.getText()+"' and password = '" + passwordTf.getText()+"';";
                ResultSet resultSet = conn.s.executeQuery(query);
                if(resultSet.next()){
                    userName = userNameTf.getText();
                    conn.setUserName(userName);
                    String fullName = resultSet.getString("fullName");
                    conn.setFullName(fullName);
                    JOptionPane.showMessageDialog(null, "You have been validated");
                    setVisible(false);
                    new BufferScreen();
                } else{
                    errorLbl.setText("Trouble loggin in!!!");
                }

             }
             catch(Exception e){
                 e.printStackTrace();
             }
         } else if(event.getSource() == registerButton){
             setVisible(false);
             new Signup();
         }
         else if(event.getSource() == forgotPassButton){
             setVisible(false);
             new Password();
         }

    }

    public static void main(String [] args){
        new Login();
    }
}
