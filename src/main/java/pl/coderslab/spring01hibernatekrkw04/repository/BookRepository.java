package pl.coderslab.spring01hibernatekrkw04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Query("SELECT b FROM Book b WHERE b.title=?1")
    List<Book> dejBooksByTitleNow(String title);
    @Query("SELECT b FROM Book b WHERE b.category=:category")
    List<Book> dejBooksByCategoryJuz(@Param("category") Category cat);
    @Query("SELECT b FROM Book b WHERE b.category.name=:catName")
    List<Book> dejBooksByCategoryNameJuz(@Param("catName") String name);
}
