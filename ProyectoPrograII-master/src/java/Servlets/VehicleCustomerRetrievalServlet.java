/*
 * Muestra todos los clientes de un vehiculo y permite modificarlos
 */
package Servlets;

import Business.CustomerBusiness;
import Data.VehicleData;
import Domain.Vehicle;
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
 * @author Arturo
 */
@WebServlet(name = "VehicleCustomerRetrievalServlet", urlPatterns = {"/VehicleCustomerRetrievalServlet"})
public class VehicleCustomerRetrievalServlet extends HttpServlet {

    VehicleData vehicleBusiness;
    CustomerBusiness customerBusiness;
    ArrayList<Vehicle> vehicles;

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
            out.println("<title>Servlet VehicleRetrievalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VehicleRetrievalServlet at " + request.getContextPath() + "</h1>");
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
        vehicles = VehicleData.vehicles;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("modify_customers_by_vehicle.jsp");//adonde
        request.setAttribute("vehicles", vehicles);//qué
        requestDispatcher.forward(request, response);//llevelo
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
        return "Show the vehicle list and then the customers by vehicle";
    }// </editor-fold>

    @Override
    public void init() throws ServletException {
        vehicleBusiness = new VehicleData();
        customerBusiness = new CustomerBusiness();
        vehicles = new ArrayList<>();
    }

}
