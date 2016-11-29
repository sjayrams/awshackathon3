package com.hackathon;

import java.sql.*;

/**
 * Created by guptga1 on 11/28/16.
 */
public class AAADal {

    public static void main(String[] argv) throws SQLException {

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            connection = DriverManager.getConnection("jdbc:postgresql://db.runizar.net:5432/vitalsigns_staging", "postgres", "postgres");
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM aaa");
            while (rs.next())
            {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(1));
            }


        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        } finally {
            rs.close();
            st.close();
            connection.close();
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

    }

}
