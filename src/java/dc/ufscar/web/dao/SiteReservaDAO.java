 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc.ufscar.web.dao;

import dc.ufscar.web.beans.SiteReservas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author 619655
 */
public class SiteReservaDAO {
    private final static String CRIAR_SITE = "INSERT INTO SiteDeReservas(url, nome, telefone,senha) values (?,?,?,?)";
    private final static String BUSCA_SITE_URL="SELECT url FROM SiteDeReservas WHERE url=?";
    private final static String RECUPERA_SITES = "SELECT url FROM SiteDeReservas";
    private final static String LOGAR_SITE = "SELECT url, senha FROM SiteDeReservas WHERE url=? AND senha = ?";
    
    DataSource dataSource;
    
    public SiteReservaDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    
    public SiteReservas gravaSiteReservas(SiteReservas s) throws SQLException, NamingException{
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CRIAR_SITE);){
            ps.setString(1, s.getUrl());
            ps.setString(2,s.getNome());
            ps.setString(3,s.getTelefone());
            ps.setString(4,s.getSenha());
            ps.execute();
        }
        return s;            
    }
    
    public List<String> listaUrlSiteReservas() throws SQLException{
        List<String> ret = new ArrayList<>();
        try(Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(RECUPERA_SITES)){
            try(ResultSet rs = ps.executeQuery()){
                    while(rs.next()){
                        String sr = rs.getString("url");
                        ret.add(sr);
                    }
                  return ret;
                }
            
        }
    }
    
    public Boolean logar(String url, String password) throws SQLException{
        try(Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LOGAR_SITE);){
            ps.setString(1, url);
            ps.setString(2, password);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next())
                    return true;
                else
                    return false;
            }
        }
    }
   
    
}
