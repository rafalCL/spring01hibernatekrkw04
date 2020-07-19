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
import pl.coderslab.spring01hibernatekrkw04.validator.PropositionValidationGroup;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/proposition")
public class PropositionController {
    private BookDao bookDao;
//    private PublisherDao publisherDao;
//    private AuthorDao authorDao;

    public PropositionController(BookDao bookDao
//            , PublisherDao publisherDao,
//                                 AuthorDao authorDao
    ) {
        this.bookDao = bookDao;
//        this.publisherDao = publisherDao;
//        this.authorDao = authorDao;
    }

    @GetMapping("/all")
    public String showAll(){
        return "proposition/list";
    }

    @GetMapping("/addForm")
    public String addForm(Model m){
        m.addAttribute("proposition", new Book());

        return "/proposition/addForm";
    }

    @PostMapping("/addForm")
    public String addFormPost(@ModelAttribute("proposition") @Validated({PropositionValidationGroup.class}) Book book,
                              BindingResult errors){
        if (errors.hasErrors()){
            return "/proposition/addForm";
        }

        book.setProposition(true);

        bookDao.create(book);

        return "redirect:all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        bookDao.deleteById(id);

        return "redirect:../all";
    }

    @ModelAttribute("propositions")
    public List<Book> propositions(){
        return bookDao.readAllPropositions();
    }
}
