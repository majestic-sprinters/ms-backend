package kz.azure.ms.service;

import kz.azure.ms.model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
  Mono<Book> createOrUpdateBook(Book book);
  Flux<Book> getBooks();
  Mono<Book> getBookByName(String name);
  Mono<Void> deleteBookByName(String name);
}
