package kz.azure.ms.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Document(collection = "books")
public class Book {

    @Id
    private ObjectId id;

    private String name;

    private String description;

    private String author;

    private Integer year;

    private String publisher;
}
