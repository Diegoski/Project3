/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.session.StudentCourseFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.edu.unipiloto.entity.StudentCourse;
/**
 *
 * @author Diego
 */
public class StudentCourseServlet extends HttpServlet {

    @EJB
    private StudentCourseFacadeLocal studentCourseFacade;

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
     
        int id = Integer.parseInt(request.getParameter("Id"));
        String courseName = request.getParameter("Nombre");
        int qualification = Integer.parseInt(request.getParameter("Qualification"));
        StudentCourse student = new StudentCourse(id, courseName, qualification);
        String action = request.getParameter("action");
        if (action.equals("Add")) {
            studentCourseFacade.create(student);
        }else if (action.equals("Edit")) {
            studentCourseFacade.edit(student);
        }else if (action.equals("Delete")) {
            studentCourseFacade.remove(student);
        }else if (action.equals ("Search")) {
             studentCourseFacade.find(student.getStudent());
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("student", student);
        request.setAttribute("allStudents", studentCourseFacade.findAll());
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
        
        
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
