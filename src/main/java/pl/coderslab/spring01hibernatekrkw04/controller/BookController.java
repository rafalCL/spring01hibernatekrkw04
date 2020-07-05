package pl.coderslab.spring01hibernatekrkw04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrkw04.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw04.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw04.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw04.entity.Author;
import pl.coderslab.spring01hibernatekrkw04.entity.Book;
import pl.coderslab.spring01hibernatekrkw04.entity.Publisher;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao,
                          AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/addNew")
    @ResponseBody
    public String addNew(){
        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisherDao.create(publisher);

        Author author = new Author();
        author.setFirstName("Henryk");
        author.setLastName("Sienkiewicz");
        authorDao.create(author);

        Book book = new Book();
        book.setTitle("W pustyni i w puszczy");
        book.setPublisher(publisher);
        book.getAuthors().add(author);

        bookDao.create(book);

        return "dodano";
    }

    @GetMapping("/all")
    @ResponseBody
    public String showAll(){
        List<Book> books = bookDao.readAll();

        String str = books.stream()
                .map(Book::toString)
                .collect(Collectors.joining(", \r\n<br>"));

        return str;
    }

    @GetMapping("/byRating/{rating}")
    @ResponseBody
    public String byRating(@PathVariable int rating){
        List<Book> books = bookDao.getRatingList(rating);

        String str = books.stream()
                .map(Book::toString)
                .collect(Collectors.joining(", \r\n<br>"));

        return str;
    }
}
