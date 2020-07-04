package pl.coderslab.spring01hibernatekrkw04.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw04.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Publisher publisher){
        em.persist(publisher);
    }
}
