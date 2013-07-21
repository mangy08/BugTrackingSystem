/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.dao;

import static br.uniriotec.tracker.dao.DAOMysqlConector.abrirConexao;
import static br.uniriotec.tracker.dao.DAOMysqlConector.conn;
import static br.uniriotec.tracker.dao.DAOMysqlConector.fecharConexao;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author afonso
 */
public class DAOUser extends DAOMysqlConector {

    // VERIFICA EXISTENCIA DO USUARIO E SENHA
    public boolean verificaUsuario(String login, String senha) {

        abrirConexao();

        String sql = "";
        sql += "SELECT * FROM ticketManager.USER";
        sql += " WHERE email = " + "'" + login + "'";
        sql += " AND password = " + "'" + senha + "'";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                System.out.println("EXISTE USUARIO");
                return true;
            }
            else{
                System.out.println("NAO EXISTE USUARIO");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        fecharConexao();
        return false;
    }
    
    // CREATE NEW USER
    public boolean createUser(String email, String password, String name, String lastName) {

        abrirConexao();

        String sqlVerifyUser = "";
        sqlVerifyUser += "SELECT * FROM ticketManager.USER";
        sqlVerifyUser += " WHERE email = " + "'" + email + "'";
        
        String sqlCreateUser = "";
        sqlCreateUser += "INSERT INTO ticketManager.USER (name, lastName, email, password)";
        sqlCreateUser += "VALUES (" + "'" + name + "','" 
                + lastName + "','" 
                + email + "','"
                + password + "')";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlVerifyUser);
            if(rs.next()){
                System.out.println("EXISTE USUARIO");
                return false;
            }
            else {
                System.out.println("NAO EXISTE USUARIO, LETS CREATE IT");
                Statement stUser = conn.createStatement();
                int rsUser = stUser.executeUpdate(sqlCreateUser);
                if(rsUser == 0){
                    System.out.println("Gravou");
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        fecharConexao();
        return false;
    }
}