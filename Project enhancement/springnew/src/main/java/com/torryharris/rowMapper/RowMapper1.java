package com.torryharris.rowMapper;

import com.torryharris.DAO.Train;
import com.torryharris.model.UserLogin;
import com.torryharris.model.UserRegDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapper1  implements org.springframework.jdbc.core.RowMapper<UserRegDTO> {
    @Override
    public UserRegDTO mapRow(ResultSet resultSet, int i) throws SQLException {

        UserRegDTO userRegDTO = new UserRegDTO();
        userRegDTO.setuserName(resultSet.getString("user_name"));
        userRegDTO.setuserEmail(resultSet.getString("user_email"));
        userRegDTO.setPassword(resultSet.getString("user_password"));
        userRegDTO.setCountry(resultSet.getString("country"));
        return userRegDTO;
    }
}

