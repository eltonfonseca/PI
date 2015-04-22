/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Crawlers
 */
public class Cadastros {
    public static int key;
    
    Sessao sessaoAtiva = Sessao.getInstancia();
    int idUsuario = sessaoAtiva.getIdUsuario();
    //Metodo que cadastra usuario
    public void cadastroUsuario(String nome, String repetirSenha, String email){
       Conexao cadastrarUsuario = new Conexao();
       cadastrarUsuario.abrirConexao();
       cadastrarUsuario.rs = null;
                    
       try {
       cadastrarUsuario.st = cadastrarUsuario.con.createStatement();
       PreparedStatement st = cadastrarUsuario.con.prepareStatement("INSERT INTO users(nome,senha,email) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
       st.setString(1, nome);
       st.setString(2, repetirSenha);
       st.setString(3, email);
       st.executeUpdate();
       ResultSet keys = st.getGeneratedKeys();
       keys.next();
       key = keys.getInt(1);
       JOptionPane.showMessageDialog(null,"Cadastrado com Sucesso!","Sucesso!", JOptionPane.INFORMATION_MESSAGE);
       } catch (SQLException | HeadlessException e) {
            }
    }
    
    //Metodo que cadastra a receita
    public void cadastroRendaInicial(String descricao, double valorFinal, String periodo, String categoria){
        
        Conexao cadastraReceitaInicial = new Conexao();
        cadastraReceitaInicial.abrirConexao();
        cadastraReceitaInicial.rs = null;
        
        try {
            cadastraReceitaInicial.st = cadastraReceitaInicial.con.createStatement();
            PreparedStatement st = cadastraReceitaInicial.con.prepareStatement("INSERT INTO receitas(descricao,valor,periodo,categoria,ID_usuario) VALUES(?,?,?,?,?)");
            st.setString(1, descricao);
            st.setDouble(2, valorFinal);
            st.setString(3, periodo);
            st.setString(4, categoria);
            st.setInt(5, key);
            st.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
        }
    }
    
    public void cadastroReceita(String descricao, double valorFinal, String periodo, String categoria){
        
        Conexao cadastraReceita = new Conexao();
        cadastraReceita.abrirConexao();
        cadastraReceita.rs = null;
                
        try {
            cadastraReceita.st = cadastraReceita.con.createStatement();
            PreparedStatement st = cadastraReceita.con.prepareStatement("INSERT INTO receitas(descricao,valor,periodo,categoria,ID_usuario) VALUES(?,?,?,?,?)");
            st.setString(1, descricao);
            st.setDouble(2, valorFinal);
            st.setString(3, periodo);
            st.setString(4, categoria);
            st.setInt(5, idUsuario);
            st.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!","Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
        }
    }
    
    public void cadastraDespesa(String descricao, double valorFinal, String periodo, String categoria){
        
        Conexao cadastraDespesa = new Conexao();
        cadastraDespesa.abrirConexao();
        cadastraDespesa.rs = null;       
        try {
            cadastraDespesa.st = cadastraDespesa.con.createStatement();
            PreparedStatement st = cadastraDespesa.con.prepareStatement("INSERT INTO despesas(descricao,valor,periodo,categoria,ID_usuario) VALUES(?,?,?,?,?)");
            st.setString(1, descricao);
            st.setDouble(2, valorFinal);
            st.setString(3, periodo);
            st.setString(4, categoria);
            st.setInt(5, idUsuario);
            st.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!","Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
        }
    }

    void cadastroRenda(String descricao, double valorFinal, String periodo, String categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
