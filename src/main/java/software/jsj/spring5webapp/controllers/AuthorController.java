/**
 * 
 */
package software.jsj.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import software.jsj.spring5webapp.repositories.AuthorRepository;

/**
 * @author jsanyang
 *
 */
@Controller
public class AuthorController {

  AuthorRepository authorRepository;
  
  public AuthorController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }


  @RequestMapping("/authors")
  public String getAuthors(Model model) {
    model.addAttribute("authors", authorRepository.findAll());
    
    return "authors";
  }
}
