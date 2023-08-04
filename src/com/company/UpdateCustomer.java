package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Locale;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel userNameLbl, userNameDisplayLbl, fullNameLbl, ageLbl, numberLbl, genderLbl, countryLbl, addressLbl, emailLbl, identificationLbl, errorLbl;
    JTextField  fullNameTf, ageTf, numberTf, addressTf, emailTf, countryTf;
    JButton submitBtn, homeBtn;
    JRadioButton maleBtn, femaleBtn, otherBtn;
    ButtonGroup genderGroup;
    JComboBox identificationList;
    JPanel p1;
    Conn conn = new Conn();

    public UpdateCustomer(){
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("update customer details");
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

        fullNameTf = new JTextField();
        fullNameTf.setBounds(260, 220, 250, 25);
        p1.add(fullNameTf);


        ageLbl = new JLabel("Age");
        ageLbl.setBounds(50, 250, 200, 50);
        ageLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(ageLbl);

        ageTf = new JTextField();
        ageTf.setBounds(260, 270, 100, 25);
        p1.add(ageTf);

        numberLbl = new JLabel("Phone number");
        numberLbl.setBounds(50, 300, 200, 50);
        numberLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        p1.add(numberLbl);

        numberTf = new JTextField();
        numberTf.setBounds(260, 315, 200, 25);
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


        countryTf = new JTextField();
        countryTf.setBounds(260, 415, 400, 25);
        p1.add(countryTf);


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

        homeBtn = new JButton("Home");
        homeBtn.setBounds(260, 650, 100, 25);
        homeBtn.setBackground(Color.gray);
        homeBtn.setForeground(new Color(222, 245, 229));
        p1.add(homeBtn);
        homeBtn.addActionListener(this);

        errorLbl = new JLabel("");
        errorLbl.setBounds(260, 750, 400, 50);
        errorLbl.setFont(new Font("San serif", Font.PLAIN, 20));
        errorLbl.setForeground(Color.red);
        p1.add(errorLbl);


        try{
            String query = "Select * from userDetails where userName = '" + userNameDisplayLbl.getText()+ "';";
            ResultSet resultSet = conn.s.executeQuery(query);
            while(resultSet.next()){

                fullNameTf.setText(resultSet.getString("fullName"));
                numberTf.setText(resultSet.getString("phoneNumber"));
                ageTf.setText(resultSet.getString("age"));
                countryTf.setText(resultSet.getString("country"));
                addressTf.setText(resultSet.getString("address"));
                emailTf.setText(resultSet.getString("email"));
                identificationList.setSelectedItem(resultSet.getString("identification"));
                String gender = resultSet.getString("gender");
                if(gender.equals("male") || gender.equals("Male") ){
                    maleBtn.setSelected(true);
                }
                else if(gender.equals("female") || gender.equals("Female") ){
                    femaleBtn.setSelected(true);
                }
                else if(gender.equals("other") || gender.equals("Other") ){
                    otherBtn.setSelected(true);
                }

            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("errrrrr");
        }






        setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        String gender = null;
        if (maleBtn.isSelected()) {
            gender = "Male";
        } else if (femaleBtn.isSelected()) {
            gender = "Female";
        } else if (otherBtn.isSelected()) {
            gender = "Other";
        }

        if(event.getSource() == submitBtn){
            try{
                String query = "update userDetails set fullName ='" + fullNameTf.getText()+ "', age ='" + ageTf.getText() + "', phoneNumber = '" +
                        Integer.parseInt(numberTf.getText())+ "', gender = '" + gender+ "', country = '" + countryTf.getText()+ "', address = '" +
                        addressTf.getText()+ "', email ='" + emailTf.getText()+ "', identification = '" + identificationList.getSelectedItem()+ "' where userName ='" + userNameDisplayLbl.getText()+ "';";
                conn.s.executeUpdate(query);
                JOptionPane successMessage = new JOptionPane("Customer details have been updated successfully");
                successMessage.setBounds(300, 300, 400, 50);
                p1.add(successMessage);
                errorLbl.setText("Success");
            }
            catch (Exception e){
                e.printStackTrace();
                errorLbl.setText("Error occurred, try later");

            }
        }
        else if (event.getSource() == homeBtn){
            setVisible(false);
            new Dashboard();
        }
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
    public static void main(String[] args) {
        new UpdateCustomer();
    }
}
