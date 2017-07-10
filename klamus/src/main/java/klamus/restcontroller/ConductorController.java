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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@ComponentScan()
@RequestMapping("/conductor")
public class ConductorController {

    @Autowired
    ConductorRepository repository;    
    
    @RequestMapping("")
    public List<Conductor> get(@RequestParam String lastName) {
        return repository.findByLastName(lastName);
    }
    
    @RequestMapping("/getAll")
    public Iterable<Conductor> getAll() {
        return repository.findAll();
    }
    
    @RequestMapping("/{id}")
    public Conductor getById(@PathVariable String id) {
        return repository.findOne(Long.parseLong(id));
    }       
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Conductor conductor) {

        Conductor savedConductor = repository.save(conductor);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedConductor.getConductorId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }    
}