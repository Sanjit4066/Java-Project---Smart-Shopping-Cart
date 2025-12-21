package services;

import models.Cart;
import models.Product;

public class CartService {
    private Cart cart = new Cart();

    /**
     * Adds a product to the cart.
     * @param product The product to add.
     * @param qty The quantity of the product.
     */
    public void addToCart(Product product, int qty) {
        cart.addItem(product, qty);
    }

    /**
     * Gets the current cart.
     * @return The current cart.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Clears the cart.
     */
    public void clearCart() {
        cart.clearCart();
    }
}
