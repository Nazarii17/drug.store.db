package nazarii.tkachuk.com;

import nazarii.tkachuk.com.DAO.CustomerDAO;
import nazarii.tkachuk.com.DAO.OrderDao;
import nazarii.tkachuk.com.DAO.ProductDAO;
import nazarii.tkachuk.com.entities.Order;
import nazarii.tkachuk.com.entities.Product;
import nazarii.tkachuk.com.services.CustomerService;
import nazarii.tkachuk.com.services.OrderService;
import nazarii.tkachuk.com.services.ProductService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
        OrderDao orderDao = new OrderDao();

    }
}
