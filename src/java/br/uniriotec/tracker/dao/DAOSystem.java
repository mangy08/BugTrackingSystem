/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.dao;

import static br.uniriotec.tracker.dao.DAOMysqlConector.abrirConexao;
import static br.uniriotec.tracker.dao.DAOMysqlConector.conn;
import static br.uniriotec.tracker.dao.DAOMysqlConector.fecharConexao;
import br.uniriotec.tracker.model.BugTrackerSystem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author afonso
 */
public class DAOSystem extends DAOMysqlConector {

    // CREATE NEW SYSTEM
    public boolean createSystem(String systemName) {

        abrirConexao();

        String sqlVerifySystem = "";
        sqlVerifySystem += "SELECT * FROM ticketManager.SYSTEM";
        sqlVerifySystem += " WHERE systemName = " + "'" + systemName + "'";

        String sqlCreateSystem = "";
        sqlCreateSystem += "INSERT INTO ticketManager.SYSTEM (systemName)";
        sqlCreateSystem += "VALUES (" + "'"
                + systemName + "')";

        try {
            Statement st = conn.createStatement();
            System.out.println(sqlVerifySystem);
            ResultSet rs = st.executeQuery(sqlVerifySystem);
            if (rs.next()) {
                System.out.println("SISTEMA JA ESTA CADASTRADO");
                return false;
            } else {
                System.out.println("SISTEMA NAO EXISTE E VAI SER CRIADO");
                System.out.println(sqlCreateSystem);
                Statement stUser = conn.createStatement();
                int rsUser = stUser.executeUpdate(sqlCreateSystem);
                if (rsUser == 1) {
                    System.out.println("GRAVOU O NOVO SISTEMA!");
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
    
    public BugTrackerSystem getSystem(int id){
        BugTrackerSystem system = new BugTrackerSystem();
        system.setId(1);
        system.setName("sunda");
        return system;
    }
    
     // CHANGE USER NAME 
    public ArrayList getSystemList() {
         abrirConexao();
         
         ArrayList retorno = new ArrayList();
         
         String sql = "";
         sql += "SELECT * FROM ticketManager.SYSTEM";
         
         try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                BugTrackerSystem system = new BugTrackerSystem();
                system.setId(rs.getInt("id"));
                system.setName(rs.getString("systemName"));
                retorno.add(system);
            }
            return retorno;
        } catch (Exception e) {
            System.err.println(e);
        }
         
        fecharConexao();
        return null;
    }

    // CHANGE USER NAME 
    public boolean changeSystemName(String systemName) {

        abrirConexao();

        String sqlVerifySystem = "";
        sqlVerifySystem += "SELECT * FROM ticketManager.SYSTEM";
        sqlVerifySystem += " WHERE systemName = " + "'" + systemName + "'";

        String sqlNewSystemName = "";
        sqlNewSystemName += "INSERT INTO ticketManager.SYSTEM (systemName)";
        sqlNewSystemName += "VALUES (" + "'"
                + systemName + "')";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlVerifySystem);
            if (rs.next()) {
                System.out.println("JA EXISTE SISTEMA COM O NOME INFORMADO). DIGITE OUTRO NOME.");
                System.out.println(sqlVerifySystem);
                return false;
            } else {
                Statement stUser = conn.createStatement();
                int rsUser = stUser.executeUpdate(sqlNewSystemName);
                return true;

            }

        } catch (Exception e) {
            System.err.println(e);
        }

        fecharConexao();
        return false;
    }

    public boolean deleteTicket(String parameter) {
        return true;
    }
    
     
}