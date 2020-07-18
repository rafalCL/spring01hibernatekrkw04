package pl.coderslab.spring01hibernatekrkw04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrkw04.entity.Book;
import pl.coderslab.spring01hibernatekrkw04.entity.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@Controller
@RequestMapping("/validation")
public class ValidationController {
    @Autowired
    private Validator validator;

    @GetMapping("/validateBook")
    @ResponseBody
    public String validateBook(){
        Book b = new Book().setPublisher(new Publisher());
        Set<ConstraintViolation<Book>> errors = validator.validate(b);
        if(errors.isEmpty()){
            return "Zapis książki: " + b.toString();
        } else {
            String msg = "Nie można zapisać. Błędy walidacji: <br/>\r\n";
            for (ConstraintViolation<Book> err : errors){
                msg += err.getPropertyPath()
                        + " : " + err.getInvalidValue()
                        + " : " + err.getMessage()
                        + "<br>\r\n";
            }

            return msg;
        }
    }
}
