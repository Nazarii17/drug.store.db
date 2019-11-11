package nazarii.tkachuk.com;

import nazarii.tkachuk.com.DAO.CustomerDAO;
import nazarii.tkachuk.com.entities.Customer;
import nazarii.tkachuk.com.services.CustomerService;

public class App {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        CustomerDAO customerDAO = new CustomerDAO();
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


        Customer customer = new Customer("Kitty", "Hobs", "507737490", "kitty@mail.com");
//        customerDAO.save(customer);
        System.out.println(customerDAO.getAll());

        customerService.update(customerService.getByID(12),"Angela", "Chick", "507737444", "angela@mail.com");


    }
}
