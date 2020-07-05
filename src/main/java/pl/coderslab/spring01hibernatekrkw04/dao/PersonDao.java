package pl.coderslab.spring01hibernatekrkw04.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrkw04.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager em;

    public void create(Person person){
        em.persist(person);
    }
}
