import java.util.*;


interface Identifiable<ID> {
    ID getId();
}


interface Repository<ID, T extends Identifiable<ID>> {

    void save(T entity);

    T findById(ID id);

    List<T> findAll();

    void update(T entity);

    void deleteById(ID id);
}


class InMemoryRepository<ID, T extends Identifiable<ID>>
        implements Repository<ID, T> {

    private Map<ID, T> storage = new HashMap<>();

    @Override
    public void save(T entity) {
        storage.put(entity.getId(), entity);
    }

    @Override
    public T findById(ID id) {
        return storage.get(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void update(T entity) {
        if (!storage.containsKey(entity.getId())) {
            throw new RuntimeException("Entity not found");
        }
        storage.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(ID id) {
        storage.remove(id);
    }
}


class Student implements Identifiable<Integer> {
    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}


class Product implements Identifiable<String> {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String getId() {
        return id;
    }

    public String toString() {
        return "Product{id='" + id + "', name='" + name + "', price=" + price + "}";
    }
}


public class GenericRepositorySystem {

    public static void main(String[] args) {

        
        Repository<Integer, Student> studentRepo =
                new InMemoryRepository<>();

        studentRepo.save(new Student(1, "stone"));
        studentRepo.save(new Student(2, "oduor"));

        System.out.println("All Students: " + studentRepo.findAll());
        System.out.println("Find Student ID 1: " + studentRepo.findById(1));

        studentRepo.update(new Student(1, "Stone Updated"));
        System.out.println("Updated Student: " + studentRepo.findById(1));

        studentRepo.deleteById(2);
        System.out.println("Students after delete: " + studentRepo.findAll());

        
        Repository<String, Product> productRepo =
                new InMemoryRepository<>();

        productRepo.save(new Product("P1", "Laptop", 80000));
        productRepo.save(new Product("P2", "Phone", 45000));

        System.out.println("\nAll Products: " + productRepo.findAll());
        System.out.println("Find Product P1: " + productRepo.findById("P1"));

        productRepo.deleteById("P2");
        System.out.println("Products after delete: " + productRepo.findAll());
    }
}
