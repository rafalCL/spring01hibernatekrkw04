package pl.coderslab.spring01hibernatekrkw04.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw04.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Book book){
        em.persist(book);
    }
}
