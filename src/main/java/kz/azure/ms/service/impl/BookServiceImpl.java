package kz.azure.ms.service.impl;

import kz.azure.ms.exceptions.ObjectNotFoundException;
import kz.azure.ms.mapper.BookMapper;
import kz.azure.ms.model.dto.BookDTO;
import kz.azure.ms.model.entity.Book;
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
  private final BookMapper bookMapper;

  @Override
  public Mono<BookDTO> createOrUpdateBook(BookDTO bookDTO) {
    return bookRepository.findByName(bookDTO.getName())
            .switchIfEmpty(Mono.defer(() -> Mono.just(new Book())))
            .flatMap(book -> {
              bookMapper.updateOnly(bookDTO, book);
              return saveAndMapToDto(book);
            });
  }

  public Mono<BookDTO> saveAndMapToDto(Book book) {
    return bookRepository.save(book).map(bookMapper::bookToDto);
  }

  @Override
  public Flux<BookDTO> getBooks() {
    return bookRepository.findAll().map(bookMapper::bookToDto);
  }

  @Override
  public Mono<BookDTO> getBookByName(String name) {
    return bookRepository.findByName(name)
            .map(bookMapper::bookToDto)
            .switchIfEmpty(Mono.error(new ObjectNotFoundException(
                    String.format("Book %s is not found", name))));
  }

  @Override
  public Mono<Void> deleteBookByName(String name) {
    return bookRepository.deleteByName(name);
  }
}
