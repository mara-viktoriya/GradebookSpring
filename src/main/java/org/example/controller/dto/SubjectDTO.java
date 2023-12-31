package org.example.controller.dto;

import java.util.List;
import java.util.UUID;

public class SubjectDTO {

    private UUID id;

    private String name;

    private List<MarkDTO> markList;

    public SubjectDTO() {
    }

    public SubjectDTO(UUID id, String name, List<MarkDTO> markList) {
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

    public List<MarkDTO> getMarkList() {
        return markList;
    }

    public void setMarkList(List<MarkDTO> markList) {
        this.markList = markList;
    }

}
