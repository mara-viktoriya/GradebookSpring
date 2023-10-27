package org.example.repository.interfaces;


import org.example.model.entity.StudentEntity;
import org.example.model.entity.SubjectEntity;
import org.example.repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface StudentRepository<T, K>  extends Repository<StudentEntity, UUID>  {

     boolean addNewStudent(T t) throws SQLException;

     String getStudentIDBySurname(T t) throws SQLException;

     boolean isStudentExists (T t) throws SQLException;

     boolean deleteStudent(T t) throws SQLException;

     StudentEntity getMarksBySubject(T t, SubjectEntity subjectEntity) throws SQLException;

     boolean changeStudent (T t1, T t2) throws SQLException;


}
