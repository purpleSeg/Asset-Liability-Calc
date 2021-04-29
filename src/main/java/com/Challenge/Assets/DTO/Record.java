package com.Challenge.Assets.DTO;

public class Record {
    private RecordType type;
    private String description;
    private int amount;

    public RecordType getType() {
        return type;
    }

    public void setType(RecordType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Record(RecordType type, String description, int amount) {
        this.type = type;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Record{" +
                "type=" + type +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
