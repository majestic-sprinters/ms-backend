package kz.azure.ms.reporitory;

import java.util.Optional;
import kz.azure.ms.model.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, Long> {
  Optional<Book> findByName(@Param("name") String ctn);
}
