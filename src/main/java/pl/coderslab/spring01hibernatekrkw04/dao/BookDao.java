package pl.coderslab.spring01hibernatekrkw04.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw04.entity.Author;
import pl.coderslab.spring01hibernatekrkw04.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Book book){
        em.persist(book);
    }

    public List<Book> readAll(){
        Query q = this.em.createQuery("SELECT b FROM Book b");

        return q.getResultList();
    }

    public List<Book> getRatingList(int rating){
        Query q = this.em.createQuery("SELECT b FROM Book b WHERE b.rating >= :rating");
        q.setParameter("rating", rating);

        return q.getResultList();
    }

    public List<Book> getByAuthor(Author author){
        Query q = this.em.createQuery("SELECT b FROM Book b WHERE :author MEMBER OF b.authors");
        q.setParameter("author", author);

        return q.getResultList();
    }

}
