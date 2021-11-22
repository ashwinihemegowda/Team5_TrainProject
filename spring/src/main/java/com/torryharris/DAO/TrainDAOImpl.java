package com.torryharris.DAO;

import com.torryharris.rowMapper.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainDAOImpl implements TrainDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Train> loadTrains() {
        String sql="select * from TRAINS";
        List<Train>listOfTrains=jdbcTemplate.query(sql, new RowMapper());
        return listOfTrains;
    }

    @Override
    public List<Train> loadTrains(int trainNo) {
        List<Train>list=new ArrayList<Train>();
        String sql="select * from trains where train_no="+trainNo;
        List<Train>listOfTrains=jdbcTemplate.query(sql,new RowMapper());
        return listOfTrains;
    }
}
