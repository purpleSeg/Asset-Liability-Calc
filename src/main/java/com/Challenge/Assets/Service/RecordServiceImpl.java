package com.Challenge.Assets.Service;

import com.Challenge.Assets.DAO.RecordDAO;
import com.Challenge.Assets.DAO.RecordDAOImpl;
import com.Challenge.Assets.DTO.Record;

import java.sql.SQLException;
import java.util.ArrayList;

public class RecordServiceImpl implements RecordService {
    RecordDAO dao;

    public RecordServiceImpl() throws SQLException {
        dao = new RecordDAOImpl();
    }

    @Override
    public ArrayList<Record> getAllRecords() throws SQLException {
        return dao.getAllRecords();
    }

    @Override
    public Record postRecord(Record record) throws SQLException {
        return dao.postRecord(record);
    }

    @Override
    public void deleteRecord(String description) throws SQLException {
        dao.deleteRecord(description);
    }

    @Override
    public Record updateRecord(Record record, String description) throws SQLException {
        return dao.updateRecord(record, description);
    }

    @Override
    public ArrayList<Record> getAllAssets() throws SQLException {
        return dao.getAllAssets();
    }

    @Override
    public ArrayList<Record> getAllLiabilities() throws SQLException {
        return dao.getAllLiabilities();
    }

    @Override
    public int getAssetsTotal() throws SQLException {
        return dao.getTotalAssets();
    }

    @Override
    public int getLiabilitiesTotal() throws SQLException {
        return dao.getTotalLiabilities();
    }

    @Override
    public int getNetWorth() throws SQLException {
        return dao.getNetWorth();
    }
}
