package org.example.model.entity;


import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class SubjectEntity {


    private UUID id;

    private String name;


    private List<StudentEntity> studentEntitiesList;


    private List<MarkEntity> markEntitiesList;

    public SubjectEntity() {
        this.id = UUID.randomUUID();
    }

    public SubjectEntity(UUID id, String name, List<StudentEntity> studentEntitiesList, List<MarkEntity> markEntitiesList) {
        this.id = id;
        this.name = name;
        this.studentEntitiesList = studentEntitiesList;
        this.markEntitiesList = markEntitiesList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentEntity> getStudentEntitiesList() {
        return studentEntitiesList;
    }

    public void setStudentEntitiesList(List<StudentEntity> studentEntities) {
        this.studentEntitiesList = studentEntities;
    }

    public List<MarkEntity> getMarkEntitiesList() {
        return markEntitiesList;
    }

    public void setMarkEntitiesList(List<MarkEntity> markEntities) {
        this.markEntitiesList = markEntities;
    }

    @Override
    public String toString() {
        return "SubjectEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentEntitiesList=" + studentEntitiesList +
                ", markEntitiesList=" + markEntitiesList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(studentEntitiesList, that.studentEntitiesList) && Objects.equals(markEntitiesList, that.markEntitiesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), studentEntitiesList, markEntitiesList);
    }
}