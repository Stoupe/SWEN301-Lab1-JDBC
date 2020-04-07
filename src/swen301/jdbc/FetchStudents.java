package swen301.jdbc;

import java.sql.*;

public class FetchStudents {

    public static void main(String[] args) throws Exception {

        System.out.println("Fetch All");
        fetchAll();

        System.out.println("Fetch by ID");
        fetchById(3);

        System.out.println("Done");

    }

    private static void fetchById(int id) throws Exception {
        doFetch("SELECT * FROM students WHERE ID='" + id + "'");
    }

    private static void fetchAll() throws Exception {
        doFetch("SELECT * FROM students");
    }

    private static void doFetch(String sql) throws Exception {

        String url =
                "jdbc:relique:csv:db" +
                        "?separator=," +
                        "&fileExtension=.csv";

        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery(sql);


        while (results.next()) {

            StringBuilder row = new StringBuilder();

            row.append(results.getString("ID"));
            row.append("\t\t");
            row.append(results.getString("FIRSTNAME"));
            row.append("\t\t");
            row.append(results.getString("LASTNAME"));
            row.append("\t\t");
            row.append(results.getString("DEGREE"));
            row.append("\t\t");
            row.append(results.getString("MAJOR"));


            System.out.println(row.toString());
        }

    }

}
