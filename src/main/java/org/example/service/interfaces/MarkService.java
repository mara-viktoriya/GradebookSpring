package org.example.service.interfaces;


import org.example.controller.dto.MarkDTO;

import java.sql.SQLException;

public interface MarkService{

    public MarkDTO save(MarkDTO markDTO) throws SQLException;

    Object getRepository();
}
