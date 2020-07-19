package pl.coderslab.spring01hibernatekrkw04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernatekrkw04.entity.Author;
import pl.coderslab.spring01hibernatekrkw04.entity.Book;
import pl.coderslab.spring01hibernatekrkw04.entity.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByRatingGreaterThanEqual(int rating);
    List<Book> findByAuthors(Author author);
    List<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);
    List<Book> findByCategoryId(Long categoryId);
    List<Book> findByCategoryName(String name);
}
