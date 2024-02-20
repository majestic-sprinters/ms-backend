package kz.azure.ms.service.impl;

import java.util.List;
import kz.azure.ms.exceptions.ObjectNotFoundException;
import kz.azure.ms.mapper.BookMapper;
import kz.azure.ms.model.dto.BookDTO;
import kz.azure.ms.model.entity.Book;
import kz.azure.ms.reporitory.BookRepository;
import kz.azure.ms.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
  private final BookRepository bookRepository;
  private final BookMapper bookMapper;
  private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);


  @Override
  public BookDTO createOrUpdateBook(BookDTO bookDTO) {
    logger.info("Received request to create or update book: {}", bookDTO);
    var byName = bookRepository.findByName(bookDTO.getName());
    var book = byName.orElseGet(Book::new);
    bookMapper.updateOnly(bookDTO, book);
    return saveAndMapToDto(book);
  }

  @Override
  public BookDTO createOrUpdateBook(BookDTO bookDTO) {
    var byName = bookRepository.findByName(bookDTO.getName());
    var book = byName.orElseGet(Book::new);
    bookMapper.updateOnly(bookDTO, book);
    return saveAndMapToDto(book);
  }

  public BookDTO saveAndMapToDto(Book book) {
    return bookMapper.bookToDto(bookRepository.save(book));
  }

  @Override
  public List<BookDTO> getBooks() {
    return bookMapper.bookToDtos(bookRepository.findAll());
  }

  @Override
  public BookDTO getBookByName(String name) {
    return bookMapper.bookToDto(bookRepository.findByName(name)
        .orElseThrow(() -> new ObjectNotFoundException(
            String.format("Book %s is not found", name))));
  }

  @Override
  public void deleteBookByName(String name) {
    var book =
        bookRepository.findByName(name)
            .orElseThrow(
                () -> new ObjectNotFoundException(
                    String.format("Book %s is not found", name)));

    bookRepository.delete(book);

  }
}
