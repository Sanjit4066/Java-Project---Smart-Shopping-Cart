package services;

import models.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private DatabaseService db = new DatabaseService();

    /**
     * Retrieves all products from the database.
     * @return A list of all products.
     */
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();

        try (Connection conn = db.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * Retrieves a single product by its ID.
     * @param id The ID of the product to retrieve.
     * @return The product with the given ID, or null if not found.
     */
    public Product getProductById(int id) {
        try (Connection conn = db.connect();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM products WHERE id=?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Searches for products by name.
     * @param query The search query.
     * @return A list of products that match the query.
     */
    public List<Product> searchProducts(String query) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE name LIKE ?";

        try (Connection conn = db.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + query + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
