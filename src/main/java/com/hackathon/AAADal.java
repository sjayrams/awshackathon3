package com.hackathon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guptga1 on 11/28/16.
 */
public class AAADal {
    Connection connection = null;
    Statement st = null;

    public AAADal() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://db.runizar.net:5432/vitalsigns_staging", "postgres", "postgres");

    }


    public List<AAA> getData(String lat, String lon) throws SQLException {

        List<AAA> aaaList = new ArrayList<>();

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        System.out.println("PostgreSQL JDBC Driver Registered!");
        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM aaa where lat='" +lat + "' and lon='"+ lon +"'");
            while (rs.next())
            {
                AAA aaa = new AAA();
                aaa.setCountry(rs.getString("country"));
                aaa.setAccess(rs.getString("access"));
                aaa.setCiaf(rs.getString("ciaf"));
                aaa.setK(rs.getString("k"));
                aaa.setN(rs.getString("n"));
                aaa.setP(rs.getString("p"));
                aaa.setLandscape(rs.getString("landscape"));
                aaa.setLat(rs.getString("lat"));
                aaa.setLon(rs.getString("lon"));
                aaaList.add(aaa);
            }


        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }  finally {
            rs.close();
            st.close();
        }

//        if (connection != null) {
//            System.out.println("You made it, take control your database now!");
//        } else {
//            System.out.println("Failed to make connection!");
//        }
        return aaaList;
    }

    public List<AAA> getRandomLocationData(String country) throws SQLException {

        List<AAA> aaaList = new ArrayList<>();

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        System.out.println("PostgreSQL JDBC Driver Registered!");

        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM aaa where country='" +country + "'");
            while (rs.next())
            {
                AAA aaa = new AAA();
//                aaa.setCountry(rs.getString("country"));
//                aaa.setAccess(rs.getString("access"));
//                aaa.setCiaf(rs.getString("ciaf"));
//                aaa.setK(rs.getString("k"));
//                aaa.setN(rs.getString("n"));
//                aaa.setP(rs.getString("p"));
//                aaa.setLandscape(rs.getString("landscape"));
                aaa.setLat(rs.getString("lat"));
                aaa.setLon(rs.getString("lon"));
                aaaList.add(aaa);
            }


        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }  finally {
            rs.close();
            st.close();
        }

//        if (connection != null) {
//            System.out.println("You made it, take control your database now!");
//        } else {
//            System.out.println("Failed to make connection!");
//        }
        return aaaList.size() > 20 ? aaaList.subList(0,20) : aaaList;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AAADal aaaDal = new AAADal();
        System.out.println(aaaDal.getData("-1.809272314","29.38478538"));
        System.out.println(aaaDal.getRandomLocationData("RWA"));
    }
}
