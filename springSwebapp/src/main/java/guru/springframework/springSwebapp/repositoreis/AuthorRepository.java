package guru.springframework.springSwebapp.repositoreis;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.springSwebapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long>{

}
