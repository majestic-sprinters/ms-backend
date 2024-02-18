package kz.azure.ms.service;

import java.util.List;
import kz.azure.ms.model.dto.BookDTO;

public interface BookService {
  BookDTO createOrUpdateBook(BookDTO bookDTO);

  List<BookDTO> getBooks();

  BookDTO getBookByName(String name);

  void deleteBookByName(String name);
}
