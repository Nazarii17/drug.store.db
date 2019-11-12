package nazarii.tkachuk.com;

import nazarii.tkachuk.com.DAO.CustomerDAO;
import nazarii.tkachuk.com.DAO.ProductDAO;
import nazarii.tkachuk.com.entities.Customer;
import nazarii.tkachuk.com.entities.Product;
import nazarii.tkachuk.com.services.CustomerService;
import nazarii.tkachuk.com.services.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();
        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
//
//        Optional<Customer> customerOptional = customerDAO.getByID(1);
//        Customer customer = null;
//
//        if (customerOptional.isPresent()) {
//            customer = customerOptional.orElseThrow(RuntimeException::new);
//        }
//        System.out.println(customer);
//
//        List<Customer> customers = customerDAO.getAll();
//        System.out.println(customers);
//
//        Customer customer1 = customerDAO.getByID(1).get();
//        customer1.setName("QAbsgirfevqiwe");
//        System.out.println(customer1);
//
////        customerDAO.update(customer1);

//        System.out.println(customerDAO.getAll());
//
//        Customer c = customerDAO.getByID(13).get();
//        c.setName("Lola");
//        c.setLastName("Cool");
//        c.setPhoneNumber("507737412");
//        c.setEmail("cool.lola@gmail.com");
//        System.out.println(c);
//
//        customerDAO.update(c);
//
//
//        String[] strings = new String[]{"Anna", "Black", "507737498", "anna.black.@gmail.com"};
//
//        customerDAO.update(c,strings);
//
////        System.out.println(customerDAO.deleteByID(8));


//        Customer customer = new Customer("Kitty", "Hobs", "507737490", "kitty@mail.com");
////        customerDAO.save(customer);
//        System.out.println(customerDAO.getAll());
//
//        customerService.update(customerService.getByID(12),"Angela", "Chick", "507737444", "angela@mail.com");


        List<Product> products = productDAO.getAll();
//        System.out.println(products);
        Product product = products.get(0);
        product.setPrice(new BigDecimal(25));
        product.setName("Lipton");
        product.setInfo("qazwsx");

//        System.out.println(productDAO.getByID(2).get());

//        productDAO.save(product);
        String[] strings = new String[]{"Bubble Tea", "300", "Tasty", "0"};

        Product p = productDAO.getByID(1).get();
        p.setName("Lipton");
        p.setInfo("qazwsx");
        System.out.println(p);
        productDAO.update(p);

//        productDAO.delete(productDAO.getByID(3).get());

        productService.deleteByName("nana");
//        productService.save("nana", new BigDecimal("454.5"),"ddd", 78);

//        productService.deleteByID(4);



    }
}
