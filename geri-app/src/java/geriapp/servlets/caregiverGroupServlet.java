package geriapp.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import geriapp.dao.CaregiverDAO;
import geriapp.dao.CaregiverGroupDAO;
import geriapp.dao.PatientDAO;
import geriapp.entity.Caregiver;
import geriapp.entity.CaregiverGroup;
import geriapp.entity.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(urlPatterns = {"/caregiverGroupServlet"})
public class caregiverGroupServlet extends HttpServlet {

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

            //Retrieve Information
            String patientName = request.getParameter("inputPatientName");
            String patientNric = request.getParameter("inputPatientNRIC");
            String patientPhone = request.getParameter("inputPatientPhone");
            String patientAddress = request.getParameter("inputPatientAddress");
            String patientPhoto = request.getParameter("inputPatientPhoto");
            String addtionalInformation = request.getParameter("inputPatientInformation");

            CaregiverDAO caregiveDao = new CaregiverDAO();
            ArrayList<Caregiver> caregiverList = new ArrayList<Caregiver>();

            RequestDispatcher dispatcher = request.getRequestDispatcher("createCaregiverGroup.jsp");

            //Checking for blanks fields
            if (patientName != null && patientNric != null && patientPhone != null && patientAddress != null && patientPhoto != null && addtionalInformation != null) {
                System.out.println("hi");
                //CaregiverList
                for (int i = 0; i <= 10; i++) {
                    String caregiverName = request.getParameter("fields" + (i + 1));
                    if (caregiverName != null && !caregiverName.isEmpty()) {
                        if (caregiveDao.getCaregiverById(caregiverName) != null) {
                            caregiverList.add(caregiveDao.getCaregiverById(caregiverName));
                        } else {
                            request.setAttribute("errorMsg", "Invalid Caregiver");
                            dispatcher.forward(request, response);
                            return;
                        }
                    }
                }

                if (caregiverList.size() > 10) {
                    request.setAttribute("errorMsg", "Number of Caregiver added cannot be more than 10.");
                    dispatcher.forward(request, response);
                    return;
                } else if (caregiverList.size() < 1) {
                    request.setAttribute("errorMsg", "Kindly assign a caregiver.");
                    dispatcher.forward(request, response);
                    return;
                } else {
                    //Pass the readings into objects then, display information next page

                    //Create Patient and add into database
                    Patient patient = new Patient(patientName, patientNric, patientPhone, patientAddress, addtionalInformation, patientPhoto);
                    PatientDAO patientDao = new PatientDAO();
                    patientDao.AddPatient(patient);
                    System.out.println("Here");
                    //Create Caregiver Group 
                    CaregiverGroup caregiverGroup = new CaregiverGroup(patient.getNRIC(), caregiverList);
                    
                    for(Caregiver caregiver: caregiverList){
                        CaregiverGroupDAO.addCaregiverToGroup(patient,caregiver);
                    }                 
                    System.out.println("Here3");
                    System.out.println("Testing");
                    System.out.println(caregiverList.size());
                    response.sendRedirect("displayCaregiverGroup.jsp");
                    return;
                }

            } else {
                request.setAttribute("errorMsg", "Kindly fill up all the fields.");
                dispatcher.forward(request, response);
                return;
            }
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
