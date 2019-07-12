/**
 * 
 */
package software.jsj.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import software.jsj.spring5webapp.model.Book;

/**
 * @author jsanyang
 *
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
