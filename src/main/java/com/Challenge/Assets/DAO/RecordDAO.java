package com.Challenge.Assets.DAO;

import com.Challenge.Assets.DTO.Record;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RecordDAO {

    public Record postRecord(Record record) throws SQLException;

    public ArrayList<Record> getAllRecords() throws SQLException;

    public Record updateRecord(Record record, String description) throws SQLException;

    public void deleteRecord(String description) throws SQLException;

    public ArrayList<Record> getAllAssets() throws SQLException;

    public ArrayList<Record> getAllLiabilities() throws SQLException;

    public int getTotalAssets() throws SQLException;

    public int getTotalLiabilities() throws SQLException;

    public int getNetWorth() throws SQLException;
}
