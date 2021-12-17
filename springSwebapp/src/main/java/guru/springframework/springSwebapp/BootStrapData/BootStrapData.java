package guru.springframework.springSwebapp.BootStrapData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.springSwebapp.domain.Author;
import guru.springframework.springSwebapp.domain.Book;
import guru.springframework.springSwebapp.domain.Publisher;
import guru.springframework.springSwebapp.repositoreis.AuthorRepository;
import guru.springframework.springSwebapp.repositoreis.BookRepository;
import guru.springframework.springSwebapp.repositoreis.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher= new Publisher();
		publisher.setName("SFG Publisher");
		//publisher.setAddress1("ST Petersbug");
		publisher.setCity("Pune");
		publisher.setState("Maharashatra");
		
		publisherRepository.save(publisher);
		
		System.out.println("Publisher Count:" +publisherRepository.count());
	
		Author erio= new Author("Eric","Evans");
		Book ddd = new Book("Domain Driven Design", "34243");
		
		erio.getBooks().add(ddd);
		ddd.getAuthors().add(erio);
		
		ddd.setPublishers(publisher);
		publisher.getBooks().add(ddd);
		
		
		
		authorRepository.save(erio);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);
		
		Author rod= new Author("Rod", "Johson");
		Book noEBJ = new Book( "J2EE Development", "2233433");
		
		rod.getBooks().add(noEBJ);
		noEBJ.getAuthors().add(rod);
		
		noEBJ.setPublishers(publisher);
		publisher.getBooks().add(noEBJ);
		
		authorRepository.save(rod);
		bookRepository.save(noEBJ);
		publisherRepository.save(publisher);
		
		System.out.println("Started In Repository");
		System.out.println("Number Of Books " +bookRepository.count());
		System.out.println("Publisher Number of Books :"+ publisher.getBooks().size());
	}
	
	

}
