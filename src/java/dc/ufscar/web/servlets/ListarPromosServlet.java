/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc.ufscar.web.servlets;

import dc.ufscar.web.beans.Promo;
import dc.ufscar.web.beans.SiteReservas;
import dc.ufscar.web.dao.PromoDAO;
import dc.ufscar.web.dao.SiteReservaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author juliamourac
 */
@WebServlet(name = "ListarPromosServlet", urlPatterns = {"/ListarPromosServlet"})
public class ListarPromosServlet extends HttpServlet {
    
    @Resource(name="jdbc/ReservaHotelDBLocal")
    DataSource dataSource;


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        PromoDAO pdao = new PromoDAO(dataSource);
        List<Promo> listaPromos = new ArrayList<>();
        listaPromos = null;

        try {
            if (request.getSession().getAttribute("tipoUser").equals("site")) {
                listaPromos = pdao.listarPromoSite(request.getSession().getAttribute("user").toString());
            } else if (request.getSession().getAttribute("tipoUser").equals("hotel")) {
                listaPromos = pdao.listarPromoHotel(request.getSession().getAttribute("user").toString());
            } else {
                request.setAttribute("mensagem", "Você deve estar logado para conseguir utilizar este recurso!");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }

            request.setAttribute("listapromos", listaPromos);
            RequestDispatcher r = request.getRequestDispatcher("ListaPromos.jsp");
            r.forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("mensagem", e.getLocalizedMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarPromosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListarPromosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
