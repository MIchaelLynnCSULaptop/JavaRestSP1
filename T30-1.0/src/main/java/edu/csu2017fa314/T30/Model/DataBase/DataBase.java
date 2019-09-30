package edu.csu2017fa314.T30.Model.DataBase;

import java.sql.*;
import java.util.Properties;

public class DataBase {

    public DataBase()
    {

    }

    public void myDataBase() throws SQLException {

        Connection conn = null;
        ResultSet resultSet = null;

        // Create a variable for the connection string.

        try {

            conn  = DriverManager.getConnection("jdbc:sqlserver://localhost:3306; integratedSecurity=true; database=LSI");
            Statement statement = conn.createStatement();

            if (conn != null) {
                System.out.println("Successfully connected to MySQL database test");
                // Create and execute a SELECT SQL statement.
                String selectSql = "SELECT Distinct Signal.[Signal], Signal.[Chart], Signal.[Block], Meas.[I/O name]\n" +
                        "From ([LSI].[DBO].[Nickajack_Plant_NJH_CH_AI_Signa$] AS Signal\n" +
                        "INNER JOIN [LSI].[DBO].[Nickajack_Plant_NJH_CH_AI_Range$] AS Ranges \n" +
                        "ON Signal.[Chart] = Ranges.[Chart] AND Signal.[Block] = Ranges.[Block]\n" +
                        "INNER JOIN [LSI].[DBO].[Nickajack_Plant_NJH_CH_AI_Bridg$] AS Bridge \n" +
                        "ON Bridge.[Chart] = Ranges.[Chart] AND Bridge.[nBlock] = Ranges.[nBlock]\n" +
                        "INNER JOIN [LSI].[DBO].[Nickajack_Plant_NJH_CH_AI_Meas_$] AS Meas \n" +
                        "ON Bridge.[Chart] = Meas.[Chart] AND Bridge.[nBlock] = Meas.[Block])";

                resultSet = statement.executeQuery(selectSql);

                // Print results from select statement
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
                }

            }
        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
            ex.printStackTrace();
        }

        }

}

