package pl.coderslab.spring01hibernatekrkw04.controller;

import org.hibernate.Hibernate;
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
import java.util.Optional;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    public AuthorController(BookDao bookDao, PublisherDao publisherDao,
                            AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/getBooks/{authorId}")
    @ResponseBody
    @Transactional
    public String getBooks(@PathVariable Long authorId){
        Author author = authorDao.getById(authorId);

        Hibernate.initialize(author.getBooks());

        return author.getBooks().toString();
    }
}
