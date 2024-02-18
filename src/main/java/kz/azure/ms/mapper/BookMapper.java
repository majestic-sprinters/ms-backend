package kz.azure.ms.mapper;

import java.util.List;
import kz.azure.ms.model.dto.BookDTO;
import kz.azure.ms.model.entity.Book;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = org.mapstruct.MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
  BookDTO bookToDto(Book book);

  @Mapping(target = "id", ignore = true)
  Book bookDtoToModel(BookDTO bookDTO);

  List<BookDTO> bookToDtos(List<Book> books);


  @Mapping(target = "id", ignore = true)
  void updateOnly(BookDTO bookDTO, @MappingTarget Book book);

  default String map(ObjectId objectId) {
    return objectId != null ? objectId.toString() : null;
  }
}
