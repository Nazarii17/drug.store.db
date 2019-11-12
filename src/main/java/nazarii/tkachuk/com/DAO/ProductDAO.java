package nazarii.tkachuk.com.DAO;

import nazarii.tkachuk.com.entities.Customer;
import nazarii.tkachuk.com.entities.Product;
import nazarii.tkachuk.com.providers.JdbcProvider;
import nazarii.tkachuk.com.providers.JdbcWorkProvider;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO implements DAO<Product>{

    @Override
    public Optional<Product> getByID(int id) {

        String sql = "select id, name, price, info, discount " +
                "from drugstoredb.product " +
                "where id = " + id + ";";

        ResultSet resultSet;
        Product product = null;

        try {
            resultSet = JdbcWorkProvider.getPreparedStation(sql).executeQuery();

            while (resultSet.next()) {
                product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        BigDecimal.valueOf(Double.parseDouble(resultSet.getString("price"))),
                        resultSet.getString("info"),
                        resultSet.getInt("discount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(product);
    }

    @Override
    public List<Product> getAll() {

        String sql = "SELECT t.* FROM drugstoredb.product t;";

        ResultSet resultSet;
        List<Product> productList = new ArrayList<>();
        try {
            resultSet = JdbcWorkProvider.getPreparedStation(sql).executeQuery();

            while (resultSet.next()) {
                productList.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        BigDecimal.valueOf(Double.parseDouble(resultSet.getString("price"))),
                        resultSet.getString("info"),
                        resultSet.getInt("discount")
                ));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        if (productList.isEmpty()) {
            throw new RuntimeException("Got nothing from db!");
        }
        return productList;
    }

    @Override
    public void save(Product product) {

        String sql = "INSERT INTO `drugstoredb`.`product` (`name`, `price`, `info`, `discount`) VALUES ( ?, ?, ?, ?)";

        PreparedStatement preparedStatement = JdbcWorkProvider.getPreparedStation(sql);
        int rowsInserted = 0;
        try {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice().toString());
            preparedStatement.setString(3, product.getInfo());
            preparedStatement.setString(4, product.getDiscount().toString());

            rowsInserted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }

    @Override
    public void update(Product product, String[] params) {

        String sql = "UPDATE `drugstoredb`.`product` t SET " +
                "t.`name` = ?, " +
                "t.`price` = ?, " +
                "t.`info` = ?, " +
                "t.`discount` = ? " +
                "WHERE t.`id` = " + product.getId() + ";";

        PreparedStatement preparedStatement = JdbcWorkProvider.getPreparedStation(sql);

        try {
            preparedStatement.setString(1, params[0]);
            preparedStatement.setBigDecimal(2, new BigDecimal(params[1]));
            preparedStatement.setString(3, params[2]);
            preparedStatement.setShort(4, Short.valueOf(params[3]));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Product product) {

        String sql = "UPDATE `drugstoredb`.`product` t SET " +
                "t.`name` = ?, " +
                "t.`price` = ?, " +
                "t.`info` = ?, " +
                "t.`discount` = ? " +
                "WHERE t.`id` = " + product.getId() + ";";

        PreparedStatement preparedStatement = JdbcWorkProvider.getPreparedStation(sql);

        try {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setBigDecimal(2, product.getPrice());
            preparedStatement.setString(3, product.getInfo());
            preparedStatement.setShort(4, Short.valueOf(String.valueOf(product.getDiscount())));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product product) {

        String sql = "DELETE FROM `drugstoredb`.`product` WHERE `id` = ?";

        PreparedStatement preparedStatement = JdbcWorkProvider.getPreparedStation(sql);
        try {
            preparedStatement.setInt(1,product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByID(Integer id) {

        String sql = "DELETE FROM `drugstoredb`.`product` WHERE `id` = ?";

        PreparedStatement preparedStatement = JdbcWorkProvider.getPreparedStation(sql);
        try {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByName(String name) {

        String sql = "DELETE FROM `drugstoredb`.`product` WHERE `name` = ?";

        PreparedStatement preparedStatement = JdbcWorkProvider.getPreparedStation(sql);
        try {
            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
