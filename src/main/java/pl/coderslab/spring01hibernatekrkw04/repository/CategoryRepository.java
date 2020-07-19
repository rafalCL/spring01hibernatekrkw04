package pl.coderslab.spring01hibernatekrkw04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernatekrkw04.entity.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
