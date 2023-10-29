package org.example.repository;


import org.example.db.ConnectionManager;

import java.sql.SQLException;


public interface Repository<T, K> {

    public ConnectionManager getConnectionManager();
    public void clearAll() throws SQLException;

}
