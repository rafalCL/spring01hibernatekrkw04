package pl.coderslab.spring01hibernatekrkw04.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class IsOverXYOValidator implements ConstraintValidator<IsOverXYO, Integer> {
   private int allowedAge;

   public void initialize(IsOverXYO constraint) {
      this.allowedAge = constraint.value();
   }

   public boolean isValid(Integer yearOfBirth, ConstraintValidatorContext context) {
      return LocalDate.now().getYear() - yearOfBirth >= this.allowedAge;
   }
}
