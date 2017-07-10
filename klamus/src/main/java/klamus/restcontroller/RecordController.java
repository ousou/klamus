package klamus.restcontroller;

import klamus.entity.Record;
import klamus.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sebastian Björkqvist <sebastian@sebastianbjorkqvist.com>
 */
@RestController
@ComponentScan()
@RequestMapping("/record")
public class RecordController {
    
    @Autowired
    RecordRepository repository;    
    
    @RequestMapping("")
    public Iterable<Record> get(@RequestParam(required = false) String name) {
        if (name != null) {
            return repository.findByNameContaining(name);
        }
        return repository.findAll();
    }
    
    @RequestMapping("/{id}")
    public Record getById(@PathVariable String id) {
        return repository.findOne(Long.parseLong(id));
    }       
}
