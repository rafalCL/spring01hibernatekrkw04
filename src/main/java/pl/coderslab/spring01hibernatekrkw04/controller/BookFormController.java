package pl.coderslab.spring01hibernatekrkw04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw04.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw04.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw04.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw04.entity.Author;
import pl.coderslab.spring01hibernatekrkw04.entity.Book;
import pl.coderslab.spring01hibernatekrkw04.entity.Publisher;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bookForm")
public class BookFormController {
    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao,
                              AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/all")
    public String showAll(){
        return "book/list";
    }

    @GetMapping("/addForm")
    public String addForm(Model m){
        m.addAttribute("book", new Book());

        return "/book/addForm";
    }

    @PostMapping("/addForm")
    public String addFormPost(@ModelAttribute("book") @Validated Book book,
                              BindingResult errors){
        if (errors.hasErrors()){
            return "/book/addForm";
        }

        bookDao.create(book);

        return "redirect:all";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers(){
        return publisherDao.readAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors(){
        return authorDao.readAll();
    }

    @ModelAttribute("books")
    public List<Book> books(){
        return bookDao.readAll();
    }
}
