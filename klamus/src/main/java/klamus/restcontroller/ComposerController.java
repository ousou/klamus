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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@ComponentScan()
public class ComposerController {

    private static final String basePath = "/composer/";

    @Autowired
    ComposerRepository repository;

    @RequestMapping(basePath + "get")
    public List<Composer> get(@RequestParam(value = "name") String name) {
        return repository.findByLastName(name);
    }

    @RequestMapping(basePath + "getAll")
    public Iterable<Composer> getAll() {
        return repository.findAll();
    }

    @RequestMapping(value = basePath + "/save", method = RequestMethod.POST)
    public ResponseEntity<Composer> save(@RequestBody Composer composer) {

        Composer savedComposer = repository.save(composer);

        return new ResponseEntity<>(savedComposer, HttpStatus.OK);
    }
}
