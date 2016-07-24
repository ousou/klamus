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
import klamus.entity.Conductor;
import klamus.repository.ConductorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@ComponentScan()
public class ConductorController {

    private static final String basePath = "/conductor/";
    
    @Autowired
    ConductorRepository repository;    
    
    @RequestMapping(basePath + "get")
    public List<Conductor> get(@RequestParam(value="name") String name) {
        return repository.findByLastName(name);
    }
    
    @RequestMapping(basePath + "getAll")
    public Iterable<Conductor> getAll() {
        return repository.findAll();
    }
    
    @RequestMapping(value = basePath + "/save", method = RequestMethod.POST)
    public ResponseEntity<Conductor> save(@RequestBody Conductor conductor) {

        Conductor savedConductor = repository.save(conductor);

        return new ResponseEntity<>(savedConductor, HttpStatus.OK);
    }    
}