package th.ku.Bookstore;

import java.util.List;

public interface BookDataAccessObject {
    void save(Book book);
    void update(int id, Book book);
    void deleteById(int id);
    Book findById(int id);
    List<Book> findAll();

}
