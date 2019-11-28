package nazarii.tkachuk.com;

import nazarii.tkachuk.com.dao.CustomerDAO;
import nazarii.tkachuk.com.dao.OrderDao;
import nazarii.tkachuk.com.dao.ProductDAO;
import nazarii.tkachuk.com.services.CustomerService;
import nazarii.tkachuk.com.services.OrderService;
import nazarii.tkachuk.com.services.ProductService;

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
