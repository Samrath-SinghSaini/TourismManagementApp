package com.company;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Destination;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Dashboard extends JFrame implements ActionListener {

    JButton addCustomerDetailsBtn, updateCustomerDetailsBtn, viewCustomerDetailsBtn, deleteCustomerDetailsBtn, viewPackageBtn, viewHotelBtn, bookHotelBtn, viewBookedHotelBtn, bookPackageBtn, destinationBtn, contactBtn, aboutBtn, openCalculatorBtn, openNotepadBtn;
    private String userName;

    public Dashboard(){

        setTitle("User Dashboard");
        //setBounds(200, 100, 1200, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(236, 242, 255));
        setLayout(null);

        JPanel p1, p2, p3;
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 1600, 150);
        p1.setBackground(new Color(	0, 0, 102));
        add(p1);

        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 150, 300, 1000);
        p2.setBackground(new Color(	0, 0, 102));
        add(p2);

        p3 = new JPanel();
       // p3.setLayout(null);
        p3.setBounds(300, 150, 1300, 930);
        p3.setBackground(new Color(	0, 0, 102));
        add(p3);

        BufferedImage initLogo = null;
        BufferedImage initDashImage = null;
         try{
             initLogo = ImageIO.read(getClass().getResource("/resources/images/logo.png"));
             initDashImage = ImageIO.read(getClass().getResource("/resources/images/dash.jpg"));

         }
         catch(Exception e){
             e.printStackTrace();
         }

         ImageIcon logoImageIcon = new ImageIcon( initLogo.getScaledInstance(150, 150, Image.SCALE_DEFAULT));
         JLabel logoImageLbl = new JLabel(logoImageIcon);
         logoImageLbl.setBounds(25,0, 150, 150);
         p1.add(logoImageLbl);


        ImageIcon dashImageIcon = new ImageIcon( initDashImage.getScaledInstance(1300, 600, Image.SCALE_DEFAULT));
        JLabel dashImgLbl = new JLabel(dashImageIcon);
        dashImgLbl.setBounds(0,0, 700, 800);
        dashImgLbl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        p3.add(dashImgLbl);


         JLabel titleLabel = new JLabel("Travel and Tourism Management System");
         titleLabel.setBounds(200, 50, 500, 60);
         titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
         titleLabel.setForeground(Color.white);
         p1.add(titleLabel);

         addCustomerDetailsBtn = new JButton("Add customer details");
         //addCustomerDetailsBtn.setLayout(null);
         addCustomerDetailsBtn.setBounds(0, 0, 300, 50);
         addCustomerDetailsBtn.setForeground(Color.white);
         addCustomerDetailsBtn.setBackground(new Color(0, 0, 102));
         addCustomerDetailsBtn.addActionListener(this);
         p2.add(addCustomerDetailsBtn);

        viewCustomerDetailsBtn = new JButton("View customer details");
        viewCustomerDetailsBtn.setBounds(0, 50, 300, 50);
        viewCustomerDetailsBtn.setForeground(Color.white);
        viewCustomerDetailsBtn.setBackground(new Color(0, 0, 102));
        p2.add(viewCustomerDetailsBtn);
        viewCustomerDetailsBtn.addActionListener(this);


        updateCustomerDetailsBtn = new JButton("Update customer details");
        updateCustomerDetailsBtn.setBounds(0, 100, 300, 50);
        updateCustomerDetailsBtn.setForeground(Color.white);
        updateCustomerDetailsBtn.setBackground(new Color(0, 0, 102));
        p2.add(updateCustomerDetailsBtn);
        updateCustomerDetailsBtn.addActionListener(this);

        deleteCustomerDetailsBtn = new JButton("Delete customer details");
        deleteCustomerDetailsBtn.setBounds(0, 150, 300, 50);
        deleteCustomerDetailsBtn.setForeground(Color.white);
        deleteCustomerDetailsBtn.setBackground(new Color(0, 0, 102));
        p2.add(deleteCustomerDetailsBtn);

        viewPackageBtn = new JButton("View Packages");
        //viewPackageBtn.setLayout(null);
        viewPackageBtn.setBounds(0, 200, 300, 50);
        viewPackageBtn.setForeground(Color.white);
        viewPackageBtn.setBackground(new Color(0, 0, 102));
        viewPackageBtn.addActionListener(this);
        p2.add(viewPackageBtn);

        bookPackageBtn = new JButton("Book Packages");
        bookPackageBtn.setBounds(0, 250, 300, 50);
        bookPackageBtn.setForeground(Color.white);
        bookPackageBtn.setBackground(new Color(0, 0, 102));
        p2.add(bookPackageBtn);
        bookPackageBtn.addActionListener(this);

        viewHotelBtn = new JButton("View Hotel Packages");
        viewHotelBtn.setBounds(0, 300, 300, 50);
        viewHotelBtn.setForeground(Color.white);
        viewHotelBtn.setBackground(new Color(0, 0, 102));
        p2.add(viewHotelBtn);
        viewHotelBtn.addActionListener(this);

        bookHotelBtn = new JButton("Book Hotel Packages");
        bookHotelBtn.setBounds(0, 350, 300, 50);
        bookHotelBtn.setForeground(Color.white);
        bookHotelBtn.setBackground(new Color(0, 0, 102));
        p2.add(bookHotelBtn);
        bookHotelBtn.addActionListener(this);

        viewBookedHotelBtn = new JButton("View Booked Hotel");
        viewBookedHotelBtn.setBounds(0, 400, 300, 50);
        viewBookedHotelBtn.setForeground(Color.white);
        viewBookedHotelBtn.setBackground(new Color(0, 0, 102));
        p2.add(viewBookedHotelBtn);
        viewBookedHotelBtn.addActionListener(this);

        destinationBtn = new JButton("View Destinations");
        destinationBtn.setBounds(0, 450, 300, 50);
        destinationBtn.setForeground(Color.white);
        destinationBtn.setBackground(new Color(0, 0, 102));
        p2.add(destinationBtn);
        destinationBtn.addActionListener(this);

        contactBtn = new JButton("Contact Us");
        contactBtn.setBounds(0, 500, 300, 50);
        contactBtn.setForeground(Color.white);
        contactBtn.setBackground(new Color(0, 0, 102));
        p2.add(contactBtn);
        contactBtn.addActionListener(this);

        aboutBtn = new JButton("About us");
        aboutBtn.setBounds(0, 550, 300, 50);
        aboutBtn.setForeground(Color.white);
        aboutBtn.setBackground(new Color(0, 0, 102));
        p2.add(aboutBtn);
        aboutBtn.addActionListener(this);

        openNotepadBtn = new JButton("Notepad");
        openNotepadBtn.setBounds(0, 600, 150, 50);
        openNotepadBtn.setForeground(Color.white);
        openNotepadBtn.setBackground(new Color(0, 0, 102));
        p2.add(openNotepadBtn);
        openNotepadBtn.addActionListener(this);

        openCalculatorBtn = new JButton("Calculator");
        openCalculatorBtn.setBounds(150, 600, 150, 50);
        openCalculatorBtn.setForeground(Color.white);
        openCalculatorBtn.setBackground(new Color(0, 0, 102));
        p2.add(openCalculatorBtn);
        openCalculatorBtn.addActionListener(this);













        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event){

        if(event.getSource() == addCustomerDetailsBtn){
            setVisible(false);
            new AddCustomer();
        } else if(event.getSource() == viewCustomerDetailsBtn){
            setVisible(false);
            new ViewCustomer();
        } else if( event.getSource() == updateCustomerDetailsBtn){
            setVisible(false);
            new UpdateCustomer();
        } else if (event.getSource() == viewPackageBtn){
            setVisible(false);
            new ViewPackage();
        }
        else if (event.getSource() == bookPackageBtn){
            setVisible(false);
            new BookPackage();
        } else if(event.getSource() == viewHotelBtn){
            setVisible(false);
            new ViewHotel();
        }
        else if(event.getSource() == bookHotelBtn){
            setVisible(false);
            new BookHotel();
        } else if(event.getSource() == viewBookedHotelBtn){
            setVisible(false);
            //new ViewBookedHotel();
        }
        else if(event.getSource() == destinationBtn){
           // new Destination();
        }
        else if(event.getSource() == contactBtn){
            //new Contact();
        }
        else if(event.getSource() == aboutBtn){
            //new About();
        }else if(event.getSource() == openCalculatorBtn){
            try {
                Runtime.getRuntime().exec("Calc");
            } catch(Exception e){
                e.printStackTrace();
            }
        }else if(event.getSource() == openNotepadBtn) {
            //new About();

            try {
                Runtime.getRuntime().exec("notepad");
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
