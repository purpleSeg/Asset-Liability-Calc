package com.Challenge.Assets.DAO;

import com.Challenge.Assets.DTO.Record;
import com.Challenge.Assets.DTO.RecordType;

import java.sql.*;
import java.util.ArrayList;

public class RecordDAOImpl implements RecordDAO {

    private Connection connection;
    private Statement statement;

    public RecordDAOImpl() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://database-1.ckfwx6ecmvsn.us-east-2.rds.amazonaws.com:3306/facet_wealth?characterEncoding=latin1", "admin", "Password");
        this.statement = connection.createStatement();
    }

    @Override
    public Record postRecord(Record record) throws SQLException {
        int result = statement.executeUpdate("insert into Assets_liabilities(Type, Name, Balance) values ( '" + record.getType() + "', '" + record.getDescription() + "', '" + record.getAmount() + "')");
        if (result != 0) {
            return record;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Record> getAllRecords() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from Assets_liabilities");
        ArrayList<Record> returnedList = new ArrayList<>();
        while (resultSet.next()) {
            Record returned = new Record(RecordType.valueOf(resultSet.getString("type")), resultSet.getString("name"), resultSet.getInt("Balance"));
            returnedList.add(returned);
        }
        return returnedList;
    }

    @Override
    public Record updateRecord(Record record, String description) throws SQLException {
        Record returned = new Record(null, null, 0);
        ResultSet resultSet = statement.executeQuery("update Assets_liabilities where name = " + description);
        while (resultSet.next()) {
            returned = new Record(RecordType.valueOf(resultSet.getString("type")), resultSet.getString("name"), resultSet.getInt("Balance"));
        }
        return returned;
    }

    @Override
    public void deleteRecord(String description) throws SQLException {
        statement.executeUpdate("delete from Assets_liabilities where name = '" + description + "'");
    }

    @Override
    public ArrayList<Record> getAllAssets() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from Assets_liabilities where type = \"Asset\"");
        ArrayList<Record> returnedList = new ArrayList<>();
        while (resultSet.next()) {
            Record returned = new Record(RecordType.valueOf(resultSet.getString("type")), resultSet.getString("name"), resultSet.getInt("Balance"));
            returnedList.add(returned);
        }
        return returnedList;
    }

    @Override
    public ArrayList<Record> getAllLiabilities() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from Assets_liabilities where type = \"Liability\"");
        ArrayList<Record> returnedList = new ArrayList<>();
        while (resultSet.next()) {
            Record returned = new Record(RecordType.valueOf(resultSet.getString("type")), resultSet.getString("name"), resultSet.getInt("Balance"));
            returnedList.add(returned);
        }
        return returnedList;
    }

    @Override
    public int getTotalAssets() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select sum(Balance) from Assets_liabilities where type = \"asset\"");
        while (resultSet.next()) {
            return resultSet.getInt("sum(Balance)");
        }
        return 0;
    }

    @Override
    public int getTotalLiabilities() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select sum(Balance) from Assets_liabilities where type = \"liability\"");
        while (resultSet.next()) {
            return resultSet.getInt("sum(Balance)");
        }
        return 0;
    }

    @Override
    public int getNetWorth() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select sum(Balance) from Assets_liabilities");
        while (resultSet.next()) {
            return resultSet.getInt("sum(Balance)");
        }
        return 0;
    }
}
