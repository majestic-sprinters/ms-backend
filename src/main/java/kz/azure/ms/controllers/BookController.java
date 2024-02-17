package kz.azure.ms.controllers;

import kz.azure.ms.models.Book;
import kz.azure.ms.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping("/all")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
