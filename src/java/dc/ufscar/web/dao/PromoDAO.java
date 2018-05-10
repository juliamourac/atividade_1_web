/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc.ufscar.web.dao;

import dc.ufscar.web.beans.Promo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author juliamourac
 */
public class PromoDAO {
    
    DataSource dataSource;
    
    private final String CRIAR_PROMO = "INSERT INTO Promos (?,?,?,?,?)";
    private final String BUSCAR_PROMO_SITE = "SELECT * FROM Promos WHERE url=?";
    private final String BUSCAR_PROMO_HOTEL = "SELECT * FROM Promos WHERE cnpj=?";
    
    public PromoDAO(DataSource dataSource){ this.dataSource = dataSource; }
    
    public Promo gravarPromo(Promo p){
         try(Connection con = dataSource.getConnection();
                 PreparedStatement ps = con.prepareStatement(CRIAR_PROMO);){
             ps.setString(1, p.getUrl());
             ps.setString(2, p.getCnpj());
             ps.setString(3, p.getPreco());
             ps.setString(4, p.getDataInicio());
             ps.setString(5, p.getDataFim());
             ps.executeQuery();
             con.close();
         }catch(Exception e){
         
         }
         return p;
    }
    
    public List<Promo> listarPromoSite(String _url) throws SQLException{
        List<Promo> lista = new ArrayList<>();
        try(Connection con= dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_PROMO_SITE);){
            ps.setString(1,_url);
            
            try(ResultSet rs = ps.executeQuery())
            {
                while (rs.next()) {
                    Promo p = new Promo();
                    p.setCnpj(rs.getString("cnpj"));
                    p.setUrl(rs.getString("url"));
                    p.setPreco(rs.getString("preco"));
                    p.setDataInicio(rs.getString("dataInicio"));
                    p.setDataFim(rs.getString("dataFinal"));
                    lista.add(p);
                }
            }
            return lista;
        }          
    }
    
    public List<Promo> listarPromoHotel(String cnpj) throws SQLException{
        List<Promo> lista = new ArrayList<>();
        try(Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_PROMO_HOTEL);){
            ps.setString(1,cnpj);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Promo p = new Promo();
                    p.setCnpj(rs.getString("cnpj"));
                    p.setUrl(rs.getString("url"));
                    p.setPreco(rs.getString("preco"));
                    p.setDataInicio(rs.getString("dataInicio"));
                    p.setDataFim(rs.getString("dataFim"));
                    lista.add(p);
                }
                return lista;
            }            
        }
    }
    
}
