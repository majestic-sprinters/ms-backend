package kz.azure.ms.model.dto;

import lombok.Data;

@Data
public class BookDTO {

    private String id;

    private String name;

    private String description;

    private String author;

    private Integer year;

    private String publisher;
}
