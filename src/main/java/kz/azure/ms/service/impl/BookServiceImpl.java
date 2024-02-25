package kz.azure.ms.service.impl;

import kz.azure.ms.exceptions.ObjectNotFoundException;
import kz.azure.ms.model.Book;
import kz.azure.ms.repository.BookRepository;
import kz.azure.ms.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
  private final BookRepository bookRepository;

  @Override
  public Mono<Book> createOrUpdateBook(Book bookDTO) {
    return bookRepository.findByName(bookDTO.getName())
            .switchIfEmpty(Mono.defer(() -> Mono.just(new Book())))
            .flatMap(book -> {
              book.setName(bookDTO.getName());
              book.setAuthor(bookDTO.getAuthor());
              book.setDescription(bookDTO.getDescription());
              book.setPublisher(bookDTO.getPublisher());
              book.setYear(bookDTO.getYear());

              return bookRepository.save(book);
            });
  }

  @Override
  public Flux<Book> getBooks() {
    return bookRepository.findAll();
  }

  @Override
  public Mono<Book> getBookByName(String name) {
    return bookRepository.findByName(name)
            .switchIfEmpty(Mono.error(new ObjectNotFoundException(
                    String.format("Book %s is not found", name))));
  }

  @Override
  public Mono<Void> deleteBookByName(String name) {
    return bookRepository.deleteByName(name);
  }
}
