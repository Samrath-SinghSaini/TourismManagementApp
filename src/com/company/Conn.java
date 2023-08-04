package com.company;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    private static String userName;
    private static String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        Conn.fullName = fullName;
    }

    public void setUserName(String userName){
        Conn.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
    public Conn(){
        try{
            //importing the sql driver class
            //we had to add the sql jdbc connector jar file from the project structure module to execute this line of code
            //Getting the driver class from the sql connector file
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establishing a connection - we provide the host, database name, sql username and password
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelManagementSystem", "root", "root");

            //creating a statement
            s = c.createStatement(); 

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
