package th.ku.Bookstore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        BookDataAccessObject bookDao = context.getBean("BookDataAccessObjectImp", th.ku.Bookstore.BookDataAccessObjectImp.class);
        // ---- insert book ----
        System.out.println("insert ===========================");
        Book newBook = new Book(4, "Basic of Spring Framework", 556);
        bookDao.save(newBook);

        // ---- select book ----
        System.out.println("select ===========================");
        Book spring = bookDao.findById(3);
        System.out.println("---getOne: " + spring);

        List<Book> bookList = bookDao.findAll();
        for (Book book : bookList) {
            System.out.println(book);
        }

        // ---- update book ----
        System.out.println("update ===========================");
        newBook.setPrice(600);
        bookDao.update(4, newBook);

        spring = bookDao.findById(4);
        System.out.println("---fineById: " + spring);

        // ---- delete book ----
        System.out.println("delete ===========================");
        bookDao.deleteById(4);

        bookList = bookDao.findAll();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

}

