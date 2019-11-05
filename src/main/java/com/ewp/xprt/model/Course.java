package com.ewp.xprt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
Направления
 */
@Entity
@Table(name = "course")
@NoArgsConstructor @RequiredArgsConstructor @ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    @Getter @Setter
    private Long id;

    @Column(name = "course_name", nullable = false, unique = true)
    @Getter @Setter @NonNull
    private String name;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    @Getter @Setter
    private List<Student> student;

    /**
     * Количество вакансий, на которые нуджно откликнуться
     */
    @Column(name = "vac_to_resp")
    @Getter @Setter
    private Integer vacToResp;

}
