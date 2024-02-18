package kz.azure.ms.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Entity
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;

    private String fio;

    private String gender;

    @Indexed(unique = true)
    private String username;
}
