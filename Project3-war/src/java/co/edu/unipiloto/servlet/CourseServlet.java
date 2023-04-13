/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.session.CourseFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.edu.unipiloto.entity.Course;

/**
 *
 * @author Diego
 */
public class CourseServlet extends HttpServlet {

    @EJB
    private CourseFacadeLocal courseFacade;

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
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

        
        String CodigoCurso = request.getParameter("Id");
        String NombreCurso = request.getParameter("Name");
        int NumeroCreditos = Integer.parseInt(request.getParameter("Credit")) ;
        String Semestre = request.getParameter("YearLevel");
       Course course = new Course (CodigoCurso,NombreCurso,NumeroCreditos, Semestre);
        String option = request.getParameter("action");

        if (option.equals("Add")) {
            courseFacade.create(course);
        }else if (option.equals("Edit")) {
            courseFacade.edit(course);
        }else if (option.equals("Delete")) {
            courseFacade.remove(course);
        }else if (option.equals ("Search")) {
             courseFacade.find(course.getId());
        }

        //response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("cour", course);
        request.setAttribute("allCourses", courseFacade.findAll());
        request.getRequestDispatcher("courseInfo.jsp").forward (request,response);

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
