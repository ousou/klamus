package klamus.restcontroller;

import klamus.entity.Category;
import klamus.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Sebastian Björkqvist
 */
@RestController
@ComponentScan()
@RequestMapping("/category/")
public class CategoryController {
    
    @Autowired
    CategoryRepository repository;     
    
    @RequestMapping("getAll")
    public Iterable<Category> getAll(@RequestParam(value = "userId") String userId) {
        return repository.findByUserId(Long.parseLong(userId));
    }

    @RequestMapping("{id}")
    public Category getById(@PathVariable String id) {
        return repository.findOne(Long.parseLong(id));
    }      
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Category category) {

        Category savedCategory = repository.save(category);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedCategory.getCategoryId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }
}
