package nazarii.tkachuk.com.services;

import nazarii.tkachuk.com.DAO.CustomerDAO;
import nazarii.tkachuk.com.entities.Customer;
import java.util.List;

public class CustomerService {

    CustomerDAO customerDAO = new CustomerDAO();

    public Customer getByID(int id) {
        return customerDAO.getByID(id).get();
    }

    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    public void update(Customer customer,
                       String name,
                       String lastName,
                       String phoneNumber,
                       String email){
        String[] params = new String[]{name, lastName, phoneNumber, email};
        customerDAO.update(customer,params);
    }

    public void update(Customer customer){
        customerDAO.update(customer);
    }

    public void delete(Customer customer){
        customerDAO.delete(customer);
    }

    public boolean deleteByID(Integer id){
       return customerDAO.deleteByID(id);
    }
}

