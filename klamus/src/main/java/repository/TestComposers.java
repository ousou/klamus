package repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"repository"})
public class TestComposers implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TestComposers.class);

    @Autowired
    ComposerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(TestComposers.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        // fetch all customers
        log.info("Composers found with findAll():");
        log.info("-------------------------------");
        for (Composer composer : repository.findAll()) {
            log.info(composer.toString());
        }
        System.out.println();

        // fetch an individual customer by ID
        Composer composer = repository.findOne(1L);
        log.info("Composers found with findOne(1L):");
        log.info("--------------------------------");
        if (composer != null) {
            log.info(composer.toString());
        }
        // fetch customers by last name
        log.info("Composer found with findByLastName('Beethoven'):");
        log.info("--------------------------------------------");
        for (Composer composers : repository.findByLastName("Beethoven")) {
            log.info(composers.toString());
        }
    }
}
