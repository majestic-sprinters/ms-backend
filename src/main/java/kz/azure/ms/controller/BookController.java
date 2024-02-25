package kz.azure.ms.controller;

import kz.azure.ms.model.Book;
import kz.azure.ms.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/createOrUpdate")
    public Mono<Book> createOrUpdateBook(@RequestBody Book bookDTOMono) {
        return bookService.createOrUpdateBook(bookDTOMono);
    }

    @GetMapping("/getBooks")
    public Flux<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/getBookByName/{name}")
    public Mono<Book> getBookByName(@PathVariable String name) {
        return bookService.getBookByName(name);
    }

    @DeleteMapping("/deleteBookByName/{name}")
    public Mono<Void> deleteBookByName(@PathVariable String name) {
        return bookService.deleteBookByName(name);
    }
}