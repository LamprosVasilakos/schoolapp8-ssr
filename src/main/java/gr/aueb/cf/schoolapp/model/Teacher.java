package gr.aueb.cf.schoolapp.model;

import gr.aueb.cf.schoolapp.model.static_data.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "teachers")
public class Teacher extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(unique = true)
    private String afm;

    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @PrePersist // Everytime we insert a teacher the uuid value is pre persisted
    public void initializeUUID(){
        if (uuid == null) uuid = UUID.randomUUID().toString();
    }


}
