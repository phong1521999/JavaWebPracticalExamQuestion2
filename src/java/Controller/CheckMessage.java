/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.DAOMessageTBL;
import Model.MessageTBL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PhongFPT
 */
@WebServlet(name = "Message", urlPatterns = {"/message"})
public class CheckMessage extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Message</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Message at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //  processRequest(request, response);
        String isLogin = (String) request.getSession().getAttribute("login");
        //     request.getRequestDispatcher("Login.jsp").forward(request, response);
        String id_raw = request.getParameter("id").trim();
        ArrayList<String> receivedList=new DAOMessageTBL().getReceivedMessageID("mra");
        
        if (isLogin == null||!receivedList.contains(id_raw)) {
            response.getWriter().println("Access Denied");
        } else {
            int id = Integer.parseInt(id_raw);
            MessageTBL checkMess = new DAOMessageTBL().checkMessage(id);
            if (checkMess != null) {
                new DAOMessageTBL().updateRead(id);
                request.setAttribute("checkMessage", checkMess);
                request.getRequestDispatcher("CheckMessage.jsp").forward(request, response);
            }else{
                response.getWriter().println("<h1>Access Denied</h1>");
            }

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
