package kz.azure.ms.service;

import kz.azure.ms.model.dto.BookDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
  Mono<BookDTO> createOrUpdateBook(BookDTO bookDTO);
  Flux<BookDTO> getBooks();
  Mono<BookDTO> getBookByName(String name);
  Mono<Void> deleteBookByName(String name);
}
