package org.example.repository.mapper;

import org.example.model.SimpleEntity;

import java.sql.ResultSet;



public class SimpleResultSetMapperImpl implements SimpleResultSetMapper {

    // метод для преобразования ResultSet, который возвращается из БД:  ResultSet resultSet = preparedStatement.executeQuery();
    @Override
    public SimpleEntity map(ResultSet resultSet) {
        return null;
    }
}
