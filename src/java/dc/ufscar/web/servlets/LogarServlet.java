/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc.ufscar.web.servlets;

import dc.ufscar.web.beans.Hotel;
import dc.ufscar.web.dao.HotelDAO;
import dc.ufscar.web.dao.SiteReservaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
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
@WebServlet(name = "LogarServlet", urlPatterns = {"/LogarServlet"})
public class LogarServlet extends HttpServlet {
    
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
        
        PrintWriter out = response.getWriter();
        
        String user = request.getParameter("username");
        String password = request.getParameter("senha");
        HotelDAO hdao = new HotelDAO(dataSource);
        SiteReservaDAO srdao = new SiteReservaDAO(dataSource);
        Hotel h = new Hotel();
        if(user.equals("admin") && password.equals("admin")){
            request.getSession().setAttribute("user", "admin");
            request.getSession().setAttribute("tipoUser","admin");
            request.getRequestDispatcher("MenuAdmin.jsp").forward(request, response);
        }
        else if (hdao.logar(user, password)){         
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("tipoUser","hotel");
            request.getRequestDispatcher("MenuHotel.jsp").forward(request, response);
        }else if(srdao.logar(user,password)){
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("tipoUser","site");
            request.getRequestDispatcher("MenuSite.jsp").forward(request, response);
        }else{
            request.setAttribute("mensagem","CNPJ ou senha incorretos!");
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
            Logger.getLogger(LogarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LogarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
