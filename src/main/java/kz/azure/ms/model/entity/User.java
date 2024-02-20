package kz.azure.ms.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;

    private String fio;

    private String gender;

    @Indexed(unique = true)
    private String username;
}
