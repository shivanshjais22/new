package Model;

import jakarta.persistence.*;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Basemodel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,updatable = false)
    private Long id;

}
