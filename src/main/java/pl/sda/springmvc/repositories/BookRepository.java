package pl.sda.springmvc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springmvc.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


}
