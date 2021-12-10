package com.torryharris.rowMapper;

import com.torryharris.DAO.Train;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapper implements org.springframework.jdbc.core.RowMapper<Train> {
    @Override
    public Train mapRow(ResultSet resultSet, int i) throws SQLException {

        Train train = new Train();
        train.setTrainNo(resultSet.getInt("TRAIN_NO"));
        train.setTrainName(resultSet.getString("TRAIN_NAME"));
        train.setSource(resultSet.getString("SOURCE"));
        train.setDestination(resultSet.getString("DESTINATION"));
        train.setTicketPrice(resultSet.getDouble("TICKET_PRICE"));
        return train;
    }
}
