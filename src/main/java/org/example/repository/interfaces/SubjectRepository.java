package org.example.repository.interfaces;

import org.example.model.entity.SubjectEntity;
import org.example.repository.Repository;

import java.sql.SQLException;
import java.util.UUID;

public interface SubjectRepository<T, K> extends Repository <SubjectEntity, UUID>  {



    String getSubjectIdByName(T t) throws SQLException;

    boolean isSubjectExists (T t) throws SQLException;

    boolean addNewSubject (SubjectEntity subjectEntity) throws SQLException;

    boolean deleteSubject(SubjectEntity subjectEntity) throws SQLException;



}
