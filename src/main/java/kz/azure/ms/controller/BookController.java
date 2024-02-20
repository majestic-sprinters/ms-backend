package kz.azure.ms.controller;

import kz.azure.ms.model.dto.BookDTO;
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
    public Mono<BookDTO> createOrUpdateBook(@RequestBody BookDTO bookDTOMono) {
        return bookService.createOrUpdateBook(bookDTOMono);
    }

    @GetMapping("/getBooks")
    public Flux<BookDTO> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/getBookByName/{name}")
    public Mono<BookDTO> getBookByName(@PathVariable String name) {
        return bookService.getBookByName(name);
    }

    @DeleteMapping("/deleteBookByName/{name}")
    public Mono<Void> deleteBookByName(@PathVariable String name) {
        return bookService.deleteBookByName(name);
    }
}