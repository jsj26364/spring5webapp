/**
 * 
 */
package software.jsj.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import software.jsj.spring5webapp.model.Author;
import software.jsj.spring5webapp.model.Book;
import software.jsj.spring5webapp.model.Publisher;
import software.jsj.spring5webapp.repositories.AuthorRepository;
import software.jsj.spring5webapp.repositories.BookRepository;
import software.jsj.spring5webapp.repositories.PublisherRepository;

/**
 * @author jsanyang
 *
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;
  
  /**
   * @param authorRepository
   * @param bookRepository
   * @param publisherRepository
   */
  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    super();
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    initData();
  }
  
  private void initData() {
    
    Publisher publisher1 = new Publisher();
    publisher1.setName("Foo");
    publisher1.setAddress("address 1");
    publisherRepository.save(publisher1);
    
    //Eric
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "1234", publisher1 );
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    authorRepository.save(eric);
    bookRepository.save(ddd);
    
    Publisher publisher2 = new Publisher();
    publisher2.setName("Bar");
    publisher2.setAddress("address 2");
    publisherRepository.save(publisher2);
    
    //Rod
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2);
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);
    authorRepository.save(rod);
    bookRepository.save(noEJB);
  }

}
