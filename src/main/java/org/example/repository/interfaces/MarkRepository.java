package org.example.repository.interfaces;


import org.example.model.entity.MarkEntity;
import org.example.model.entity.StudentEntity;
import org.example.repository.Repository;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public interface MarkRepository <T, K>  extends Repository <MarkEntity, UUID>  {

    boolean save(T t) throws SQLException;
}
