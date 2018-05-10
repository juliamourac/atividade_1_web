/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc.ufscar.web.dao;

import dc.ufscar.web.beans.Hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author juliamourac
 */
public class HotelDAO {

    DataSource dataSource;
    private final String CRIAR_HOTEL_SQL = "INSERT INTO Hotel values (?,?,?,?)";
    private final String BUSCAR_HOTEL_SQL = "SELECT nome, cidade FROM Hotel";
    private final String BUSCAR_HOTEL_SQL_CIDADE = "SELECT nome, cidade FROM Hotel WHERE cidade = ?";
    private final String BUSCA_LOGIN = "SELECT cnpj, senha FROM Hotel WHERE cnpj=? AND senha=?";

    public HotelDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Hotel gravarHotel(Hotel h) throws SQLException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CRIAR_HOTEL_SQL);) {
            ps.setString(1, h.getCnpj());
            ps.setString(2, h.getNome());
            ps.setString(3, h.getCidade());
            ps.setString(4, h.getSenha());
            ps.execute();
            con.close();
        }
        return h;
    }

    public List<Hotel> listarTodosHoteis() throws SQLException {
        List<Hotel> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_HOTEL_SQL)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Hotel h = new Hotel();
                    h.setNome(rs.getString("nome"));
                    h.setCidade(rs.getString("cidade"));
                    ret.add(h);
                }
            }
        }
        return ret;
    }

    public List<Hotel> listarHoteisPorCidade(String cidade) throws SQLException {
        List<Hotel> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_HOTEL_SQL_CIDADE)) {
            ps.setString(1, cidade);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Hotel h = new Hotel();
                    h.setNome(rs.getString("nome"));
                    h.setCidade(rs.getString("cidade"));
                    ret.add(h);
                }
            }
            return ret;
        }
    }

    public Boolean logar(String cnpj, String senha) throws SQLException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCA_LOGIN);) {
            ps.setString(1, cnpj);
            ps.setString(2, senha);

            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next())
                    return true;
                else
                    return false;
            }
        }
    }
}
