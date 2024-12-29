package cane.brothers.spring.hello.person;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Person {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}
