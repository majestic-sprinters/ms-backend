package kz.azure.ms.reporitory;

import java.util.Optional;
import kz.azure.ms.model.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

  Logger logger = LoggerFactory.getLogger(UserRepository.class);
  Optional<User> findByFio(@Param("fio") String ctn);
  Optional<User> findByUsername(@Param("username") String ctn);

  default Optional<User> findByFioLogging(@Param("fio") String fio) {
    logger.info("Searching for a user by fio: {}", fio);
    return findByFio(fio);
  }

  default Optional<User> findByUsernameLogging(@Param("username") String username) {
    logger.info("Searching for a user by username: {}", username);
    return findByUsername(username);
  }
  
}
