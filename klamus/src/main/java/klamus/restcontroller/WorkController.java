package klamus.restcontroller;

import klamus.entity.Work;
import klamus.repository.WorkRepository;
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
 * @author Sebastian Björkqvist <sebastian@sebastianbjorkqvist.com>
 */
@RestController
@ComponentScan()
@RequestMapping("/work")
public class WorkController {
    @Autowired
    WorkRepository repository;    
    
    @RequestMapping("")
    public Iterable<Work> get(@RequestParam(required = false) String name) {
        if (name != null) {
            return repository.findByNameContaining(name);
        }
        return repository.findAll();
    }
    
    @RequestMapping("/{id}")
    public Work getById(@PathVariable String id) {
        return repository.findOne(Long.parseLong(id));
    }    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Work soloist) {

        Work savedWork = repository.save(soloist);
        
        HttpHeaders httpHeaders = new ControllerHelper().getHeadersForCreatedResource(savedWork.getWorkId());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);        
    }     

}
