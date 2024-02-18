package kz.azure.ms.reporitory;

import java.util.Optional;
import kz.azure.ms.model.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
  Optional<User> findByFio(@Param("fio") String ctn);
  Optional<User> findByUsername(@Param("username") String ctn);
  
}
