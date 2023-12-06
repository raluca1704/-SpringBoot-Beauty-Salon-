package org.salon_frumusete.repository;

import org.salon_frumusete.databasemodell.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    // Consider initializing or connecting to your database here

    public void addProduct(Product product) {
        String sql = "INSERT INTO product (name, price, quantityInStock) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantityInStock());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    // Assuming your Product has an ID field, set it from the generated key
                    product.setProductID(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public Product getProductById(int productID) {
        String sql = "SELECT * FROM product WHERE productID = ?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, productID);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return extractProductFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null; // Product not found
    }

    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (Statement stmt = SqlServer.conn().createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);
                allProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return allProducts;
    }

    public void updateProduct(Product updatedProduct) {
        String sql = "UPDATE product SET name=?, price=?, quantityInStock=? WHERE productID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setString(1, updatedProduct.getName());
            stmt.setDouble(2, updatedProduct.getPrice());
            stmt.setInt(3, updatedProduct.getQuantityInStock());
            stmt.setInt(4, updatedProduct.getProductID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public void deleteProduct(int productID) {
        String sql = "DELETE FROM product WHERE productID=?";
        try (PreparedStatement stmt = SqlServer.conn().prepareStatement(sql)) {
            stmt.setInt(1, productID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    // Helper method to extract Product from ResultSet
    private Product extractProductFromResultSet(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setProductID(resultSet.getInt("productID"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getDouble("price"));
        product.setQuantityInStock(resultSet.getInt("quantityInStock"));
        return product;
    }
}
