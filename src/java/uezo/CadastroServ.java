/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uezo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Felipe
 */
public class CadastroServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        
    protected void add(HttpServletRequest request) throws ClassNotFoundException, SQLException{
                    if(!request.getParameter("nome").equals("")){
                //Adiciona pessoa
                PessoaDAO dao = new PessoaDAO(); 
                //String acao = request.getParameter("add");
                int id = 0;
                for(Pessoa t:dao.findAll()){
                    id =t.getId();
                }
                id++; 
                Pessoa p = new Pessoa(new Integer((String)request.getParameter("id")),request.getParameter("nome"),request.getParameter("telefone"),request.getParameter("email"));
                dao.create(p);
            }
    }
    
    protected void exc(HttpServletRequest request) throws ClassNotFoundException, SQLException{
        PessoaDAO dao = new PessoaDAO();
            int id = Integer.parseInt((String)request.getParameter("idEx"));
            dao.delete(id);
    }
    
    protected void edt(HttpServletRequest request) throws ClassNotFoundException, SQLException{
            PessoaDAO dao = new PessoaDAO();
            Pessoa p = new Pessoa(Integer.parseInt(request.getParameter("idEdita")),
            request.getParameter("nomeEdita"),
            request.getParameter("telefoneEdita"),
            request.getParameter("emailEdita"));
            dao.update(p.getNome(), p.getTelefone(), p.getEmail(), p.getId());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        if(((String)request.getParameter("btn")).equals("Excluir")){
            this.exc(request);
        }
        else if(((String)request.getParameter("btn")).equals("Editar")){
            this.edt(request);
        }
        else if(((String)request.getParameter("btn")).equals("Adicionar")){
            this.add(request);
        }
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroServ.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroServ.class.getName()).log(Level.SEVERE, null, ex);
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
