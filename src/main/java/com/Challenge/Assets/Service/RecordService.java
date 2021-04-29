package com.Challenge.Assets.Service;

import com.Challenge.Assets.DTO.Record;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RecordService {

    public ArrayList<Record> getAllRecords() throws SQLException;

    public Record postRecord(Record record) throws SQLException;

    public void deleteRecord(String description) throws SQLException;

    public Record updateRecord(Record record, String description) throws SQLException;

    public ArrayList<Record> getAllAssets() throws SQLException;

    public ArrayList<Record> getAllLiabilities() throws SQLException;

    public int getAssetsTotal() throws SQLException;

    public int getLiabilitiesTotal() throws SQLException;

    public int getNetWorth() throws SQLException;
}
