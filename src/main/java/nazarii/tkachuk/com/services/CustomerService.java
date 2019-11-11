package nazarii.tkachuk.com.services;

import nazarii.tkachuk.com.DAO.CustomerDAO;
import nazarii.tkachuk.com.entities.Customer;

import java.util.Optional;

public class CustomerService {

    CustomerDAO customerDAO = new CustomerDAO();

    public Optional<Customer> getByID(int id) {
        return customerDAO.getByID(id);
    }
}

