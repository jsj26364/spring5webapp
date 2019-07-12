/**
 * 
 */
package software.jsj.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import software.jsj.spring5webapp.model.Author;
import software.jsj.spring5webapp.model.Book;
import software.jsj.spring5webapp.repositories.AuthorRepository;
import software.jsj.spring5webapp.repositories.BookRepository;

/**
 * @author jsanyang
 *
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  
  /**
   * @param authorRepository
   * @param bookRepository
   */
  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
    super();
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    initData();
  }
  
  private void initData() {
    
    //Eric
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    authorRepository.save(eric);
    bookRepository.save(ddd);
    
  //Rod
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "23444", "Wrox");
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);
    authorRepository.save(rod);
    bookRepository.save(noEJB);
  }

}
