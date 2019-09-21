package th.ku.Bookstore;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDataAccessObjectImp implements BookDataAccessObject {

    private JdbcTemplate jdbcTemplate;

    public BookDataAccessObjectImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Book book) {
        String query = "INSERT INTO book (id, name, price) VALUES (?, ?, ?);";
        Object[] data = new Object[]
                { book.getId(), book.getName(), book.getPrice() };
        jdbcTemplate.update(query, data);
    }

    public void update(int id, Book book) {
        String query = "UPDATE book SET name = ?, price = ? WHERE id = ?;";
//        Object[] data = new Object[]{ book.getId(), book.getName(), book.getPrice() };
        jdbcTemplate.update(query,book.getName(), book.getPrice(), book.getId());
    }

    public void deleteById(int id) {
        String query = "DELETE FROM book WHERE id = " + id;
        jdbcTemplate.update(query);
    }

    public Book findById(int id) {
        String query = "SELECT * FROM book WHERE id = " + id;
        Book book = jdbcTemplate.queryForObject(query, (RowMapper<Book>) new BookRowMapper());
        return book;
    }

    public List<Book> findAll() {
        String query = "SELECT * FROM book";
        List<Book> books = jdbcTemplate.query(query, new BookRowMapper());
        return books;
    }


    public class BookRowMapper implements RowMapper {
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {

            Book book = new Book(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"));
            return book;
        }
    }
}
