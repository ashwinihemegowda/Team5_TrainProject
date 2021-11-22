package com.torryharris.DAO;

import com.torryharris.DAO.Train;

import java.util.List;

public interface TrainDAO {
    List<Train> loadTrains();

    List<Train> loadTrains(int trainNo);
}
