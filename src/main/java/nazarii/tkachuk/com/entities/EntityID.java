package nazarii.tkachuk.com.entities;

public abstract class EntityID {
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id.toString() ;
    }
}
