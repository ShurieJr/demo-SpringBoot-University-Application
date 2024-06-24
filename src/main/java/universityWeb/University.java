package universityWeb;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "university")
public class University {
    @Id
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    private String location;
}
