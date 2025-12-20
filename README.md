# Smart Shopping Cart

This is a simple web-based smart shopping cart application built with Java, Servlets, and JSP.

## Features

*   View a list of products.
*   Search for products.
*   Add products to a shopping cart.
*   View the shopping cart.
*   Remove items from the shopping cart.

## How to Run

1.  **Prerequisites:**
    *   Java 11 or higher
    *   Maven 3.6 or higher

2.  **Build the project:**
    ```bash
    mvn clean install
    ```

3.  **Run the application:**
    ```bash
    mvn jetty:run
    ```

4.  **Access the application:**
    Open your web browser and go to `http://localhost:8080`

## Project Structure

*   `src/main/java`: Contains the Java source code.
    *   `models`: Contains the data models (Product, Cart, CartItem).
    *   `services`: Contains the business logic (ProductService, CartService, DatabaseService).
    *   `web`: Contains the servlets (ProductServlet, CartServlet).
*   `src/main/webapp`: Contains the JSP files and other web resources.
*   `src/main/resources`: Contains the SQLite database file (`smartcart.db`).
*   `pom.xml`: The Maven project configuration file.
