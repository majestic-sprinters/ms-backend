package kz.azure.ms.controller;

import java.util.List;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(value = "book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @PostMapping("/createOrUpdate")
    public BookDTO createOrUpdateBook(@RequestBody BookDTO bookDTO) {
        logger.info("Received request to create or update book: {}", bookDTO);
        return bookService.createOrUpdateBook(bookDTO);
    }


    @PostMapping("/createOrUpdate")
    public BookDTO createOrUpdateBook(@RequestBody BookDTO bookDTO) {
        return bookService.createOrUpdateBook(bookDTO);
    }

    @GetMapping("/getBooks")
    public List<BookDTO> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/getBookByName/{name}")
    public BookDTO getBookByName(@PathVariable String name) {
        return bookService.getBookByName(name);
    }

    @DeleteMapping("/deleteBookByName/{name}")
    public void deleteBookByName(@PathVariable String name) {
        bookService.deleteBookByName(name);
    }
}