/*
 *Muestra los clientes registrados de un vehiculo
 */
package Servlets;

import Business.CustomerBusiness;
import Data.VehicleData;
import Domain.Customer;
import Domain.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
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
@WebServlet(name = "VehicleCustomerInfoServlet", urlPatterns = {"/VehicleCustomerInfoServlet"})
public class VehicleCustomerInfoServlet extends HttpServlet {

    CustomerBusiness customerBusiness;
    VehicleData vehicleBusiness;
    ArrayList<Customer> customers;

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
            out.println("<title>Servlet VehicleCustomerInfoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VehicleCustomerInfoServlet at " + request.getContextPath() + "</h1>");
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
        String plate = request.getParameter("plate");
        Vehicle vehicle = vehicleBusiness.findVehicleByPlate(plate);
        customers = customerBusiness.getCustomersByVehicle(vehicle);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show_all_customers.jsp");//adonde
        request.setAttribute("customers", customers);//què
        requestDispatcher.forward(request, response);//llevelo
        processRequest(request, response);
        System.out.println("sii");

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
        return "Muestra los clientes registrados de un vehiculo";
    }// </editor-fold>

    @Override
    public void init() throws ServletException {
        customerBusiness = new CustomerBusiness();
        vehicleBusiness = new VehicleData();
        customers = new ArrayList<>();
    }

}
