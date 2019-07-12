/**
 * 
 */
package software.jsj.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import software.jsj.spring5webapp.model.Author;

/**
 * @author jsanyang
 *
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
