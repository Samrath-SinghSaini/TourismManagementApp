package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel userNameLbl, userNameDisplayLbl, fullNameLbl, fullNameDisplayLbl, ageLbl, numberLbl, genderLbl, countryLbl, addressLbl, emailLbl, identificationLbl, errorLbl;
    JTextField ageTf, numberTf, addressTf, emailTf;
    JButton submitBtn;
    JRadioButton maleBtn, femaleBtn, otherBtn;
    ButtonGroup genderGroup;
    JComboBox identificationList, countryChoice;
    JPanel p1;
    Conn conn = new Conn();


    public AddCustomer(){

        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Add customer details");
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
       // new Color(236,242,255)
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 1000, 1000);
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
        fullNameDisplayLbl.setText(conn.getFullName());

        ageLbl = new JLabel("Age");
        ageLbl.setBounds(50, 250, 200, 50);
        ageLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(ageLbl);

        ageTf = new JTextField("Age");
        ageTf.setBounds(260, 270, 100, 25);
        p1.add(ageTf);


        numberLbl = new JLabel("Phone number");
        numberLbl.setBounds(50, 300, 200, 50);
        numberLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(numberLbl);

        numberTf = new JTextField();
        numberTf.setBounds(260, 315, 100, 25);
        p1.add(numberTf);


        genderLbl = new JLabel("Gender");
        genderLbl.setBounds(50, 350, 200, 50);
        genderLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(genderLbl);

        maleBtn = new JRadioButton("Male");
        maleBtn.setBounds(260, 350, 70, 50);
        maleBtn.setBackground(new Color(222, 245, 229));
        p1.add(maleBtn);

        femaleBtn = new JRadioButton("Female");
        femaleBtn.setBounds(340, 350, 70, 50);
        femaleBtn.setBackground(new Color(222, 245, 229));
        p1.add(femaleBtn);

        otherBtn = new JRadioButton("Other");
        otherBtn.setBounds(440, 350, 70, 50);
        otherBtn.setBackground(new Color(222, 245, 229));
        p1.add(otherBtn);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        genderGroup.add(otherBtn);

        countryLbl = new JLabel("Country");
        countryLbl.setBounds(50, 400, 200, 50);
        countryLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(countryLbl);

        countryChoice = new JComboBox(getCountryList());
        countryChoice.setBounds(260, 410, 100, 25);
        p1.add(countryChoice);


        addressLbl = new JLabel("Address");
        addressLbl.setBounds(50, 450, 200, 50);
        addressLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(addressLbl);

        addressTf = new JTextField();
        addressTf.setBounds(260, 465, 400, 25);
        p1.add(addressTf);


        emailLbl = new JLabel("Email");
        emailLbl.setBounds(50, 500, 400, 50);
        emailLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(emailLbl);

        emailTf = new JTextField();
        emailTf.setBounds(260, 515, 100, 25);
        p1.add(emailTf);

        identificationLbl = new JLabel("Identification");
        identificationLbl.setBounds(50, 550, 200, 25);
        identificationLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(identificationLbl);


        identificationList = new JComboBox(new String [] {"Aadhar", "Pan Card", "Voter ID", "Passport"});
        identificationList.setBounds(260, 550, 100, 25);
        p1.add(identificationList);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(50, 650, 100, 25);
        submitBtn.setBackground(Color.gray);
        submitBtn.setForeground(new Color(222, 245, 229));
        p1.add(submitBtn);
        submitBtn.addActionListener(this);

        errorLbl = new JLabel("");
        errorLbl.setBounds(260, 650, 400, 50);
        errorLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        errorLbl.setForeground(Color.red);
        p1.add(errorLbl);








        setVisible(true);
    }

    public String[] getCountryList(){
        String[] countryList;
        countryList = Locale.getISOCountries();
        String [] countryNames = new String[Locale.getISOCountries().length];
        for(int i = 0; i < countryList.length; i++){
            String countryCode = countryList[i];
            //countryNames = new String[countryList.length];
            Locale countryLocale = new Locale("", countryCode);
            countryNames[i] = countryLocale.getDisplayCountry();
        }

        Arrays.sort(countryNames);
        return countryNames;

    }

    public void actionPerformed(ActionEvent event){

        boolean execute = false;


            if (event.getSource() == submitBtn) {
                //String query1 = "Insert into userDetails (fullName, userName) values ('" +  + "','" ++ "');";
                if (ageTf.getText().isEmpty() || numberTf.getText().isEmpty() || countryChoice.getSelectedItem() == null || emailTf.getText().isEmpty() || addressTf.getText().isEmpty() || identificationList.getSelectedItem() == null) {
                    execute = false;
                    errorLbl.setText("Error");

                } else {
                    execute = true;

                    String gender = null;
                    if (maleBtn.isSelected()) {
                        gender = "Male";
                    } else if (femaleBtn.isSelected()) {
                        gender = "Female";
                    } else if (otherBtn.isSelected()) {
                        gender = "Other";
                    }
                    String query2 = "Insert into userDetails(fullName, userName, age, phoneNumber, gender, country, email, address, identification) values('" + fullNameDisplayLbl.getText() + "','" + userNameDisplayLbl.getText() + "','" + ageTf.getText() + "', '" + Integer.parseInt(numberTf.getText()) + "','" + gender + "','" + countryChoice.getSelectedItem() + "', '" + emailTf.getText() + "','" +
                            addressTf.getText() + "','" + identificationList.getSelectedItem() + "');";
                    if(execute) {
                        try {
                            //conn.s.executeUpdate(query1);
                            conn.s.executeUpdate(query2);
                            /*JOptionPane successMessage = new JOptionPane("Customer details have been saved successfully");
                            successMessage.setBounds(300, 300, 400, 50);
                            p1.add(successMessage);*/
                            JOptionPane.showMessageDialog(null, "Customer details saved successfully");
                            setVisible(false);
                            new Dashboard();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else{
                        errorLbl.setText("Error");
                    }



                }
            }
    }
    public static void main(String[] args) {
        new AddCustomer();


    }


}
