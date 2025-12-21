package web;

import models.Cart;
import models.Product;
import services.CartService;
import services.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private CartService cartService = new CartService();
    private ProductService productService = new ProductService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addToCart(request, response);
                    return;
                case "remove":
                    removeFromCart(request, response);
                    return;
            }
        }

        Cart cart = cartService.getCart();
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductById(id);
        if (product != null) {
            cartService.addToCart(product, 1);
        }
        response.sendRedirect("cart");
    }

    private void removeFromCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        cartService.getCart().removeItem(id);
        response.sendRedirect("cart");
    }
}
