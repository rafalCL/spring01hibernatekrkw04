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
import pl.coderslab.spring01hibernatekrkw04.entity.Category;
import pl.coderslab.spring01hibernatekrkw04.entity.Publisher;
import pl.coderslab.spring01hibernatekrkw04.repository.BookRepository;
import pl.coderslab.spring01hibernatekrkw04.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    public BookController(BookRepository bookRepository,
                          CategoryRepository categoryRepository,
                          PublisherDao publisherDao,
                          AuthorDao authorDao) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
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

        return getOutputStr(books);
    }

    @GetMapping("/byRating/{rating}")
    @ResponseBody
    public String byRating(@PathVariable int rating){
        List<Book> books = bookRepository.findByRatingGreaterThanEqual(rating);

        return getOutputStr(books);
    }

    @GetMapping("/byAuthor/{id}")
    @ResponseBody
    public String byAuthor(@PathVariable long id){
        Author author = authorDao.getById(id);
        List<Book> books = bookRepository.findByAuthors(author);

        return getOutputStr(books);
    }

    @GetMapping("/byCategoryId/{id}")
    @ResponseBody
    public String byCategoryId(@PathVariable long id){
        List<Book> books = bookRepository.findByCategoryId(id);

        return getOutputStr(books);
    }

    @GetMapping("/byCategoryName/{name}")
    @ResponseBody
    public String byCategoryName(@PathVariable String name){
        List<Book> books = bookRepository.findByCategoryName(name);

        return getOutputStr(books);
    }

    @GetMapping("/dejByTitle/{title}")
    @ResponseBody
    public String dejByTitle(@PathVariable String title){
        List<Book> books = bookRepository.dejBooksByTitleNow(title);

        return getOutputStr(books);
    }

    @GetMapping("/dejByCategory/{catName}")
    @ResponseBody
    public String dejByCategory(@PathVariable String catName){
        Category cat = categoryRepository.getOne(1L);
        List<Book> books = bookRepository.dejBooksByCategoryJuz(cat);

        return getOutputStr(books);
    }

    @GetMapping("/dejByCategoryName/{catName}")
    @ResponseBody
    public String dejByCategoryName(@PathVariable String catName){
        List<Book> books = bookRepository.dejBooksByCategoryNameJuz(catName);

        return getOutputStr(books);
    }

    private String getOutputStr(List<Book> books){
        return books.stream()
                .map(Book::toString)
                .collect(Collectors.joining(", \r\n<br>"));
    }
}
