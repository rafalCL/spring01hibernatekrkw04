package pl.coderslab.spring01hibernatekrkw04.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class IsOver18YOValidator implements ConstraintValidator<IsOver18YO, Integer> {
   public void initialize(IsOver18YO constraint) {
   }

   public boolean isValid(Integer yearOfBirth, ConstraintValidatorContext context) {
      return LocalDate.now().getYear() - yearOfBirth >= 18;
   }
}
