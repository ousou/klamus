package klamus.restcontroller;

/**
 *
 * @author Sebastian Björkqvist
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import klamus.entity.Soloist;
import klamus.repository.SoloistRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@ComponentScan()
@RequestMapping("/soloist")
public class SoloistController {
    
    @Autowired
    SoloistRepository repository;    
    
    @RequestMapping("")
    public Iterable<Soloist> get(@RequestParam(required = false) String lastName) {
        if (lastName != null) {
            return repository.findByLastName(lastName);
        }
        return repository.findAll();
    }
    
    @RequestMapping("/{id}")
    public Soloist getById(@PathVariable String id) {
        return repository.findOne(Long.parseLong(id));
    }    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Soloist soloist) {

        Soloist savedSoloist = repository.save(soloist);
        
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedSoloist.getSoloistId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);        
    }    
}