package pl.coderslab.spring01hibernatekrkw04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrkw04.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw04.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw04.entity.Author;
import pl.coderslab.spring01hibernatekrkw04.entity.Book;
import pl.coderslab.spring01hibernatekrkw04.entity.Publisher;
import pl.coderslab.spring01hibernatekrkw04.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookRepository bookRepository;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    public BookController(BookRepository bookRepository, PublisherDao publisherDao,
                          AuthorDao authorDao) {
        this.bookRepository = bookRepository;
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

        bookRepository.save(book);

        return "dodano";
    }

    @GetMapping("/all")
    @ResponseBody
    public String showAll(){
        List<Book> books = bookRepository.findAll();

        String str = books.stream()
                .map(Book::toString)
                .collect(Collectors.joining(", \r\n<br>"));

        return str;
    }

    @GetMapping("/byRating/{rating}")
    @ResponseBody
    public String byRating(@PathVariable int rating){
        List<Book> books = bookRepository.findByRatingGreaterThanEqual(rating);

        String str = books.stream()
                .map(Book::toString)
                .collect(Collectors.joining(", \r\n<br>"));

        return str;
    }

    @GetMapping("/byAuthor/{id}")
    @ResponseBody
    public String byAuthor(@PathVariable long id){
        Author author = authorDao.getById(id);
        List<Book> books = bookRepository.findByAuthors(author);

        String str = books.stream()
                .map(Book::toString)
                .collect(Collectors.joining(", \r\n<br>"));

        return str;
    }

    @GetMapping("/byCategoryId/{id}")
    @ResponseBody
    public String byCategoryId(@PathVariable long id){
        List<Book> books = bookRepository.findByCategoryId(id);

        String str = books.stream()
                .map(Book::toString)
                .collect(Collectors.joining(", \r\n<br>"));

        return str;
    }

    @GetMapping("/byCategoryName/{name}")
    @ResponseBody
    public String byCategoryName(@PathVariable String name){
        List<Book> books = bookRepository.findByCategoryName(name);

        String str = books.stream()
                .map(Book::toString)
                .collect(Collectors.joining(", \r\n<br>"));

        return str;
    }
}
