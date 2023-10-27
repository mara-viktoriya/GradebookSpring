package org.example.repository.mapper;

import org.example.model.SimpleEntity;

import java.sql.ResultSet;

//интерфейс с методами получения объектов Entity из ResultSet
public interface SimpleResultSetMapper {
    SimpleEntity map(ResultSet resultSet);
}
