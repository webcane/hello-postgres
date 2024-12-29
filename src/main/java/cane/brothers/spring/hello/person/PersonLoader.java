package cane.brothers.spring.hello.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonLoader {

    //    private JdbcTemplate jdbcTemplate;
    private final PersonRepository repo;

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent() {
        Iterable<Person> allPersons = this.repo.findAll();
        long count = StreamSupport.stream(allPersons.spliterator(), false).count();
        log.info("Number of persons: " + count);

        Person newPerson = new Person();
        newPerson.setFirstName("John");
        newPerson.setLastName("Doe");
        log.info("Saving new person...");
        // jdbcTemplate.execute("INSERT INTO Person(first_name,last_name) VALUES('Victor', 'Hugo')");
        this.repo.save(newPerson);

        allPersons = this.repo.findAll();
        count = StreamSupport.stream(allPersons.spliterator(), false).count();
        log.info("Number of persons: " + count);
    }
}


