package kz.azure.ms.repository;


import kz.azure.ms.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, String> {
  Mono<Book> findByName(String name);
  Mono<Void> deleteByName(String name);
}
