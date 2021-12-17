package guru.springframework.springSwebapp.repositoreis;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.springSwebapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
