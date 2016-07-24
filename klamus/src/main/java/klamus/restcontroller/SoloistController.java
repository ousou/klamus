package klamus.restcontroller;

/**
 *
 * @author Sebastian Björkqvist
 */

import java.util.List;
import klamus.entity.Composer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import klamus.entity.Soloist;
import klamus.repository.SoloistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@ComponentScan()
public class SoloistController {

    private static final String basePath = "/soloist/";
    
    @Autowired
    SoloistRepository repository;    
    
    @RequestMapping(basePath + "get")
    public List<Soloist> get(@RequestParam(value="name") String name) {
        return repository.findByLastName(name);
    }
    
    @RequestMapping(basePath + "getAll")
    public Iterable<Soloist> getAll() {
        return repository.findAll();
    }    
    
    @RequestMapping(value = basePath + "/save", method = RequestMethod.POST)
    public ResponseEntity<Soloist> save(@RequestBody Soloist soloist) {

        Soloist savedSoloist = repository.save(soloist);

        return new ResponseEntity<>(savedSoloist, HttpStatus.OK);
    }    
}