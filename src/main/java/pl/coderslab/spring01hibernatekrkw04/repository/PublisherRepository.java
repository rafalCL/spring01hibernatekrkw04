package pl.coderslab.spring01hibernatekrkw04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernatekrkw04.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
