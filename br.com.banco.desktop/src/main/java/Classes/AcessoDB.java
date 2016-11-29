/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fabricio
 */
public class AcessoDB {
    public static Connection connection = null;
    public static final String driver = "org.postgresql.Driver";
    public static final String url = "jdbc:postgresql://localhost:5432/BancoDesktop";
    public static final String login = "postgres";
    public static final String passwd = "ju1nior2";
    
    static{
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, login, passwd);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver não encontrado.");
        } catch (SQLException e) {
            System.err.println("Problemas na criacao da conexao com o BD.");
        }        
    }
}
