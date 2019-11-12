package nazarii.tkachuk.com;

import nazarii.tkachuk.com.DAO.CustomerDAO;
import nazarii.tkachuk.com.DAO.OrderDao;
import nazarii.tkachuk.com.DAO.ProductDAO;
import nazarii.tkachuk.com.entities.Order;
import nazarii.tkachuk.com.entities.Product;
import nazarii.tkachuk.com.services.CustomerService;
import nazarii.tkachuk.com.services.ProductService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();
        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
        OrderDao orderDao = new OrderDao();

        Order order = orderDao.getByID(1).get();
        System.out.println(order);

        String[] strings = new String[]{
                "2019-11-12 13:57:28",
                "20",
                "1",
                "1",
                "2582.32"
        };

        order.setPrice(new BigDecimal("1111"));

//        orderDao.save(order);

        orderDao.update(order);

        System.out.println(orderDao.getAll());

        System.out.println(orderDao.getAllByDate("2019-11-12 11:57:28"));







    }
}
