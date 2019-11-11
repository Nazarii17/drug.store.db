package nazarii.tkachuk.com.DAO;

import nazarii.tkachuk.com.entities.Customer;
import nazarii.tkachuk.com.providers.JdbcProvider;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.List;
import java.util.Optional;

public class CustomerDAO implements DAO<Customer> {

    @Override
    public Optional<Customer> getByID(int id) {

        Customer customer = JdbcProvider.getJdbcTemplate().queryForObject(
                "select id, name, lastName, phoneNumber, email " +
                        "from drugstoredb.customer " +
                        "where id = " + id + ";",
                BeanPropertyRowMapper.newInstance(Customer.class));

        return Optional.of(customer);
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = JdbcProvider.getJdbcTemplate().query(
                "select id, name, lastName, phoneNumber, email from drugstoredb.customer;",
                new BeanPropertyRowMapper(Customer.class));
        return customers;
    }
    //    @Override
//    public List<Customer> getAll() {
//        List<Customer> customers = JdbcProvider.getJdbcTemplate().query(
//                "SELECT * FROM CUSTOMER;",
//                new BeanPropertyRowMapper(Customer.class));
//        return customers;
//    }
    @Override
    public void save(Customer customer) {

        String sql = "INSERT INTO `drugstoredb`.`customer` (`name`, `lastName`, `phoneNumber`, `email`) VALUES ( ?, ?, ?, ?)";

        JdbcProvider.getJdbcTemplate().update(sql,
                customer.getName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail()
        );
    }

    @Override
    public void update(Customer customer, String[] params) {

        String sql = "UPDATE `drugstoredb`.`customer` t SET " +
                "t.`name` = ?, " +
                "t.`lastName` = ?, " +
                "t.`phoneNumber` = ?, " +
                "t.`email` = ? " +
                "WHERE t.`id` = " + customer.getId() + ";";
//                new Object[]{
//                customer.getName(),
//                customer.getLastName(),
//                customer.getPhoneNumber(),
//                customer.getEmail(),
//                customer.getId()};
        JdbcProvider.getJdbcTemplate().update(sql, params);
    }

    public void update(Customer customer) {
//        String s = "UPDATE `drugstoredb`.`customer` t SET " +
//                "t.`name` = '" + customer.getName() + "', " +
//                "t.`lastName` = '" + customer.getLastName() + "', " +
//                "t.`phoneNumber` = '" + customer.getPhoneNumber() + "', " +
//                "t.`email` = '" + customer.getEmail() + "' " +
//                "WHERE t.`id` = " + customer.getId() + ";";
//
//        JdbcProvider.getJdbcTemplate().update(s);
        String sql = "UPDATE `drugstoredb`.`customer` t SET " +
                "t.`name` = ?, " +
                "t.`lastName` = ?, " +
                "t.`phoneNumber` = ?, " +
                "t.`email` = ? " +
                "WHERE t.`id` = ?;";

        JdbcProvider.getJdbcTemplate().update(sql,
                customer.getName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getId());
    }

    @Override
    public void delete(Customer customer) {
        deleteByID(customer.getId());
    }

    public boolean deleteByID(Integer id) {
        String sql = "DELETE FROM `drugstoredb`.`customer` WHERE `id` = ?";
        Object[] args = new Object[]{id};

        return JdbcProvider.getJdbcTemplate().update(sql, args) == 1;
    }



}
