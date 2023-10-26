package org.example.model.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Pattern(regexp = "[a-zA-Z]+")
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentEntity> studentEntities;

    @OneToMany(mappedBy = "subject")
    private List<MarkEntity> markEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity subjectEntity = (SubjectEntity) o;
        return Objects.equals(id, subjectEntity.id) && Objects.equals(name, subjectEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "SubjectEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentEntities=" + studentEntities +
                ", markEntities=" + markEntities +
                '}';
    }

    public SubjectEntity() {
    }

    public SubjectEntity(Long id, String name, List<StudentEntity> studentEntities, List<MarkEntity> markEntities) {
        this.id = id;
        this.name = name;
        this.studentEntities = studentEntities;
        this.markEntities = markEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentEntity> getStudents() {
        return studentEntities;
    }

    public void setStudents(List<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }

    public List<MarkEntity> getMarks() {
        return markEntities;
    }

    public void setMarks(List<MarkEntity> markEntities) {
        this.markEntities = markEntities;
    }
}