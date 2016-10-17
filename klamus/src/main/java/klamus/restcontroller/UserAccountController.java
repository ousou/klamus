package klamus.restcontroller;

import klamus.entity.UserAccount;
import klamus.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Sebastian Björkqvist
 */
@RestController
@ComponentScan()
@RequestMapping("/user/")
public class UserAccountController {
    @Autowired
    UserAccountRepository repository;     
    
    @RequestMapping("getAll")
    public Iterable<UserAccount> getAll() {
        return repository.findAll();
    }

    @RequestMapping("{id}")
    public UserAccount getById(@PathVariable String id) {
        return repository.findOne(Long.parseLong(id));
    }      
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody UserAccount userAccount) {

        UserAccount savedUserAccount = repository.save(userAccount);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedUserAccount.getUserId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }
}
