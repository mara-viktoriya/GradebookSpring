package org.example.service.interfaces;


import org.example.servlet.dto.AddMarkDTO;

import java.sql.SQLException;

public interface MarkService<T, K>{

    public boolean addMark(AddMarkDTO addMarkDTO) throws SQLException;

    Object getRepository();
}
