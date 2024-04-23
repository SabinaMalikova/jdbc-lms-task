package peaksoft.model;
import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Long jobId;

    public Employee(String firstName, String lastName, int age, String email, Long jobId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.jobId = jobId;
    }
}
