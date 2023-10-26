package org.example.repository.mapper;

import org.example.model.SimpleEntity;

import java.sql.ResultSet;


// метод для преобразования ResultSet, который возвращается из БД:  ResultSet resultSet = preparedStatement.executeQuery();
public class SimpleResultSetMapperImpl implements SimpleResultSetMapper {
    @Override
    public SimpleEntity map(ResultSet resultSet) {
        return null;
    }
}
