package kz.azure.ms.repository;

import kz.azure.ms.model.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, ObjectId> {
  Mono<User> findByFio(String fio);
  Mono<User> findByUsername(String username);
}
