/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

/**
 *
 * @author Crawlers
 * 
 * Padrao Singleton - Permite que apenas uma instancia dessa classe 
 * exista durante a execução do programa
 */
public class Sessao {
    
    private static Sessao instancia;
    
    private int idUsuario;
    private String loginUsuario;
    
    private Sessao() {
        
    }
    
    public static Sessao getInstancia() {
        if (instancia == null) {
            instancia = new Sessao();
        }
        
        return instancia;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(int valor) {
        idUsuario = valor;
    }
    
    public String getLoginUsuario() {
        return loginUsuario;
    }
    
    public void setLoginUsuario(String valor) {
        loginUsuario = valor;
    }
    
    public void finalizar() {
        idUsuario = -1;
        loginUsuario = null;
    }
}
