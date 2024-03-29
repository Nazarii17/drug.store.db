package nazarii.tkachuk.com.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> getByID(int id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[]params);

    void delete(T t);
}
