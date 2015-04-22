/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Crawlers
 */
public class Conexao {
    
    //Variaveis de conexao com o MYSql
    
    Connection con;
    Statement st;
    ResultSet rs;
    
    //Atributos do Driver de Coonexao
    
    String url = "jdbc:mysql://localhost/pi";
    String driver = "com.mysql.jdbc.Driver";
    String usuario = "root";
    String senha = "root";
    
    public void abrirConexao(){
        
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, usuario, senha);
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
