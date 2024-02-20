package kz.azure.ms.controller;

import java.util.List;
import kz.azure.ms.model.dto.BookDTO;
import kz.azure.ms.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "book")
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;

    @PostMapping("/createOrUpdate")
    public BookDTO createOrUpdateBook(@RequestBody BookDTO bookDTO) {
        var bookDto = bookService.createOrUpdateBook(bookDTO);
        log.info("Book created or updated successfully: {}", bookDto);
        return bookDto;
    }

    @GetMapping("/getBooks")
    public List<BookDTO> getBooks() {
        log.info("Received request to get all books");
        var books = bookService.getBooks();
        log.info("Retrieved {} books", books.size());
        return books;
    }

    @GetMapping("/getBookByName/{name}")
    public BookDTO getBookByName(@PathVariable String name) {
        var bookDto = bookService.getBookByName(name);
        log.info("Retrieved book: {}", bookDto);
        return bookDto;
    }

    @DeleteMapping("/deleteBookByName/{name}")
    public void deleteBookByName(@PathVariable String name) {
        bookService.deleteBookByName(name);
        log.info("Book deleted successfully with name: {}", name);
    }
}