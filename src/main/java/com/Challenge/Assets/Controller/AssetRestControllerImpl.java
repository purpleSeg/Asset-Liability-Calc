package com.Challenge.Assets.Controller;

import com.Challenge.Assets.DTO.Record;
import com.Challenge.Assets.Service.RecordService;
import com.Challenge.Assets.Service.RecordServiceImpl;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.sql.SQLException;
import java.util.ArrayList;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin
@RequestMapping
public class AssetRestControllerImpl implements AssetRestController {

    private static Logger LOGGER = LoggerFactory.getLogger(RestController.class);
    Gson gson = new Gson();

    RecordService recordService;

    public AssetRestControllerImpl() throws SQLException {
        recordService = new RecordServiceImpl();
    }

    @Override
    @PostMapping(value = "/postRecord", consumes = "application/json", produces = "application/json")
    public ResponseEntity postRecord(@RequestBody Record record) {
        try {
            recordService.postRecord(record);
            return new ResponseEntity<>(record.toString(), HttpStatus.OK);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @DeleteMapping(value = "/deleteRecord/{description}", consumes = "application/json", produces = "application/json")
    public ResponseEntity deleteRecord(@PathVariable String description) {
        try {
            recordService.deleteRecord(description);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PutMapping(value = "/update/?description=", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateRecord(@RequestBody Record record, @QueryParam("description") String description) {
        try {
            recordService.updateRecord(record, description);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @CrossOrigin
    @GetMapping(value = "records/", consumes = "application/json", produces = "application/json")
    public ResponseEntity getAllRecords() {
        ArrayList<Record> records = new ArrayList<>();
        try {
            records = recordService.getAllRecords();
            return new ResponseEntity<>(gson.toJson(records), HttpStatus.OK);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @GetMapping(value = "/assets", consumes = "application/json", produces = "application/json")
    public ResponseEntity getAllAssets() {
        ArrayList<Record> records = new ArrayList<>();
        try {
            records = recordService.getAllAssets();
            return new ResponseEntity<>(gson.toJson(records), HttpStatus.OK);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @GetMapping(value = "/liabilities", consumes = "application/json", produces = "application/json")
    public ResponseEntity getAllLiabilities() {
        ArrayList<Record> records = new ArrayList<>();
        try {
            records = recordService.getAllLiabilities();
            return new ResponseEntity<>(gson.toJson(records), HttpStatus.OK);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @GetMapping(value = "/assetsTotal", consumes = "application/json", produces = "application/json")
    public ResponseEntity getAllAssetsTotal() {
        try {
            int assetsTotal = recordService.getAssetsTotal();
            return new ResponseEntity<>(assetsTotal, HttpStatus.OK);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @GetMapping(value = "/liabilitiesTotal", consumes = "application/json", produces = "application/json")
    public ResponseEntity getAllLiabilitiesTotal() {
        try {
            int liabilitiesTotal = recordService.getLiabilitiesTotal();
            return new ResponseEntity<>(liabilitiesTotal, HttpStatus.OK);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @GetMapping(value = "/netWorth", consumes = "application/json", produces = "application/json")
    public ResponseEntity getNetWorth() {
        try {
            int netWorth = recordService.getNetWorth();
            return new ResponseEntity<>(netWorth, HttpStatus.OK);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

