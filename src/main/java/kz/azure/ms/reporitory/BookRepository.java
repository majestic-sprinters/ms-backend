package kz.azure.ms.reporitory;


import java.util.Optional;
import kz.azure.ms.model.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import kz.azure.ms.model.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface BookRepository extends MongoRepository<Book, Long> {

  Logger logger = LoggerFactory.getLogger(BookRepository.class);

  Optional<Book> findByName(@Param("name") String ctn);

  default Optional<Book> findByNameLogging(@Param("name") String name) {
    logger.info("Searching for a book by name: {}", name);
    return findByName(name);
  }
  
}
