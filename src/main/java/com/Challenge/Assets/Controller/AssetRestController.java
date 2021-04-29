package com.Challenge.Assets.Controller;

import com.Challenge.Assets.DTO.Record;
import org.springframework.http.ResponseEntity;

public interface AssetRestController {

    public ResponseEntity postRecord(Record record);

    public ResponseEntity deleteRecord(String description);

    public ResponseEntity updateRecord(Record updatedRecord, String description);

    public ResponseEntity getAllRecords();

    public ResponseEntity getAllAssets();

    public ResponseEntity getAllLiabilities();

    public ResponseEntity getAllAssetsTotal();

    public ResponseEntity getAllLiabilitiesTotal();

    public ResponseEntity getNetWorth();
}
