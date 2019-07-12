/**
 * 
 */
package software.jsj.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import software.jsj.spring5webapp.model.Publisher;

/**
 * @author jsanyang
 *
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
