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

@RestController
@ComponentScan()
public class ComposerController {

    @Autowired
    ComposerRepository repository;    
    
    @RequestMapping("/composer/get")
    public List<Composer> get(@RequestParam(value="name") String name) {
        return repository.findByLastName(name);
    }
    
    @RequestMapping("/composer/getAll")
    public Iterable<Composer> getAll() {
        return repository.findAll();
    }    
}