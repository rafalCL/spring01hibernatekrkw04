package pl.coderslab.spring01hibernatekrkw04.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw04.entity.Author;
import pl.coderslab.spring01hibernatekrkw04.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Author author){
        em.persist(author);
    }

    public Author getById(Long authorId) {
        return this.em.find(Author.class, authorId);
    }

    public List<Author> readAll(){
        Query q = this.em.createQuery("SELECT a FROM Author a");

        return q.getResultList();
    }
}
