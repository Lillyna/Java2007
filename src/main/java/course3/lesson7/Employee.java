package course3.lesson7;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

//@EqualsAndHashCode
//@Getter
//@Setter
//@ToString
//@Data //включает все предыдущее
//@AllArgsConstructor
//@NoArgsConstructor
@Value //включает все предыдущие
@Builder
@With
public class Employee {
    private String name;
    private int age;
    private LocalDate birthdate;

}
