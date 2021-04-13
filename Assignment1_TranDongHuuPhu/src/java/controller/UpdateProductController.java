/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import dto.ProductDTO;
import dto.ProductErrorDTO;
import dto.UserDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
public class UpdateProductController extends HttpServlet {

    private static final String SUCCESS = "LoadProductAdminController";
    private static final String ERROR = "productManager.jsp";
    private final static Logger log = Logger.getLogger(UpdateProductController.class);

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
        String url = ERROR;
        boolean check = true;
        try {
            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user.getRoleID().equals("AD")) {

                String productID = request.getParameter("txtProductID");
                String productName = request.getParameter("txtProductName");
                String category = request.getParameter("txtCategory");
                String image = request.getParameter("txtImage");
                float price = Float.parseFloat(request.getParameter("txtPrice"));
                String description = request.getParameter("txtDescription");
                int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
                String status = request.getParameter("txtStatus");
                String checkQuatity = request.getParameter("txtQuantity");
                ProductErrorDTO error = new ProductErrorDTO("", "", "", "", "", "");
                if (price <= 0) {
                    check = false;
                    error.setPriceError("Price cannot equal or less than 0");
                }
                if (productName.length() <= 0) {
                    check = false;
                    error.setNameError("Name cannot empty");
                }
                if (checkQuatity.length() <= 0) {
                    check = false;
                    error.setQuantityError("Quantity cannot empty");
                }
                if (quantity <= 0) {
                    check = false;
                    error.setQuantityError("Quantity cannot equal or less than 0");
                }
                if (price <= 0) {
                    check = false;
                    error.setPriceError("Price cannot equal or less than 0");
                }
                if (image.length() > 500) {
                    check = false;
                    error.setImageError("Max length is 500");
                }
                if (description.length() > 300) {
                    check = false;
                    error.setDescriptionError("Max length is 300");
                }
                if (check) {
                    boolean st = true;
                    if (status == null) {
                        st = false;
                    }
                    ProductDAO dao = new ProductDAO();
                    ProductDTO dto = new ProductDTO(productID, productName, quantity, price, description, category, image, st);
                    dao.updateProduct(dto);
                    url = SUCCESS;
                }
            }

        } catch (Exception e) {
            log.error(e);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
