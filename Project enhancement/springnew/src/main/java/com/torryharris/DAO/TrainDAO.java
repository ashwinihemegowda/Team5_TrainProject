package com.torryharris.DAO;

import com.torryharris.DAO.Train;

import java.util.List;

public interface TrainDAO {
    List<Train> loadTrains();

    List<Train> loadTrains(int trainNo);
    void saveTrain(Train train);
    Train getTrain(int trainNo);
    void update(Train train);
    void deleteTrain(int trainNo);
}
