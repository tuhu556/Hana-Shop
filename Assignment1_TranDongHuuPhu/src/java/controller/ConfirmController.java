/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDAO;
import dao.ProductDAO;
import dto.CartDTO;
import dto.ProductDTO;
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
public class ConfirmController extends HttpServlet {

    private static final String SUCCESS = "confirm.jsp";
    private static final String ERROR = "confirm.jsp";
    private final static Logger log = Logger.getLogger(ConfirmController.class);

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
        try {
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");

            if (cart != null) {
                OrderDAO order = new OrderDAO();
                ProductDAO dao = new ProductDAO();
                if (checkQuantity(request, response)) {
                    if (order.createOrder(cart)) {
                        for (ProductDTO dto : cart.getCart().values()) {
                            int quantity = dao.getQuantity(dto.getID());
                            dao.calculateQuantity(dto.getQuantity(), quantity, dto.getID());
                            List<String> list = dao.getListProductID();
                            for (int i = 0; i < list.size(); i++) {
                                cart.delete(list.get(i));
                            }
                            url = SUCCESS;
                            request.setAttribute("CONFIRM", "Congratulations! Your order has been confirmed! ");
                        }
                    } else {
                        url = SUCCESS;
                        request.setAttribute("CONFIRM", "Sorry! We don't have enough products!");
                    }
                } else {
                    url = SUCCESS;
                    request.setAttribute("CONFIRM", "Sorry! Your order has problem!");
                }
            } else {
                url = ERROR;
            }
        } catch (Exception e) {
            log.error(e);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    public static boolean checkQuantity(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");

            ProductDAO dao = new ProductDAO();

            for (ProductDTO dto : cart.getCart().values()) {
                if (dto.getQuantity() > dao.getQuantity(dto.getID())) {
                    System.out.println(dao.getQuantity(dto.getID()));
                    return false;
                }
            }
        } catch (Exception e) {
            log.error(e);
        }
        return true;
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
