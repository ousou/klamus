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
import klamus.entity.Composer;
import klamus.repository.ComposerRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@ComponentScan()
@RequestMapping("/composer")
public class ComposerController {

    @Autowired
    ComposerRepository repository;

    @RequestMapping("")
    public List<Composer> get(@RequestParam String lastName) {
        return repository.findByLastName(lastName);
    }

    @RequestMapping("/getAll")
    public Iterable<Composer> getAll() {
        return repository.findAll();
    }

    @RequestMapping("/{id}")
    public Composer getById(@PathVariable String id) {
        return repository.findOne(Long.parseLong(id));
    }      
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Composer composer) {

        Composer savedComposer = repository.save(composer);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedComposer.getComposerId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }
}
