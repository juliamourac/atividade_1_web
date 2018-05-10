/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc.ufscar.web.servlets;

import dc.ufscar.web.beans.Hotel;
import dc.ufscar.web.dao.HotelDAO;
import dc.ufscar.web.forms.NovoHotelFormBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "NovoHotelServlet", urlPatterns = {"/NovoHotelServlet"})
public class NovoHotelServlet extends HttpServlet {
    
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
        
        NovoHotelFormBean nhb = new NovoHotelFormBean();
                
        try {
            BeanUtils.populate(nhb, request.getParameterMap());
            if (nhb.getCNPJ().equals("")) {
                request.setAttribute("mensagem", "Não pode haver campos vazios!");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
            if (nhb.getCidade().equals("")) {
                request.setAttribute("mensagem", "Não pode haver campos vazios!");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
            if (nhb.getNome().equals("")) {
                request.setAttribute("mensagem", "Não pode haver campos vazios!");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
            if (nhb.getSenha().equals("")) {
                request.setAttribute("mensagem", "Não pode haver campos vazios!");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }

            HotelDAO hdao = new HotelDAO(dataSource);
            try {
                Hotel h = new Hotel();
                h.setCnpj(nhb.getCNPJ());
                h.setNome(nhb.getNome());
                h.setCidade(nhb.getCidade());
                h.setSenha(nhb.getSenha());
                h = hdao.gravarHotel(h);
            } catch (Exception e) {
                request.setAttribute("mensagem", e.getLocalizedMessage());
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }

        }
        catch(Exception e){
            request.setAttribute("mensagem", e.getLocalizedMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);            
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
