package org.example.model.entity;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "subject")
public class SubjectEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
    private List<MarkEntity> markList;

    public SubjectEntity() {

    }

    public SubjectEntity(UUID id, String name, List<MarkEntity> markList) {
        this.id = id;
        this.name = name;
        this.markList = markList;
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

    public List<MarkEntity> getMarkList() {
        return markList;
    }

    public void setMarkList(List<MarkEntity> markList) {
        this.markList = markList;
    }

    @Override
    public String toString() {
        return "SubjectEntity{" +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectEntity that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(markList, that.markList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), markList);
    }
}