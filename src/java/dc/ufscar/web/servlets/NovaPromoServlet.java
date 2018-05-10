/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc.ufscar.web.servlets;

import dc.ufscar.web.beans.Promo;
import dc.ufscar.web.dao.PromoDAO;
import dc.ufscar.web.forms.NovaPromoFormBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author juliamourac
 */
@WebServlet(name = "NovaPromoServlet", urlPatterns = {"/NovaPromoServlet"})
public class NovaPromoServlet extends HttpServlet {
    
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        NovaPromoFormBean npfb = new NovaPromoFormBean();
        
        try {
            BeanUtils.populate(npfb, request.getParameterMap());
            List<String> mensagens = new ArrayList<>();
            mensagens = null;
            mensagens = npfb.validar();

            if (mensagens == null) {
                PromoDAO pdao = new PromoDAO(dataSource);

                try {
                    Promo p = new Promo();
                    p.setCnpj(npfb.getCnpj());
                    p.setUrl(npfb.getUrl());
                    p.setPreco(npfb.getPreco());
                    p.setDataInicio(npfb.getDataInicio());
                    p.setDataFim(npfb.getDataFim());
                    out.println("<h1>" + p.getUrl() + "</h1>");
                    p = pdao.gravarPromo(p);
                } catch (Exception e) {
                    request.setAttribute("mensagem", e.getLocalizedMessage());
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("mensagens", mensagens);
                request.getRequestDispatcher("PromoHotelForm.jsp").forward(request, response);
            }

        } catch (Exception e) {
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
        processRequest(request, response);
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
        processRequest(request, response);
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
