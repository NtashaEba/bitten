/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ProfAlexandre
 */
public class ConexaoDb {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            // "com.mysql.jdbc.Driver"
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String url ="jdbc:mysql://localhost:3306/amsfateczl";
            String usuario = "root";
            String senha = "";
            Connection c = DriverManager.getConnection(url,usuario,senha); 
            System.out.println("Conex�o OK");
            return c;
        } catch (SQLException e) {
            System.out.println("ConexÃ£o NOK");
            throw new RuntimeException(e);
        }
    }
}