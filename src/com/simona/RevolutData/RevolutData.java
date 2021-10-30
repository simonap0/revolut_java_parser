package com.simona.RevolutData;

import com.simona.csvReader.CsvReader;

import java.util.HashMap;

public class RevolutData {

    public HashMap<Integer, TransactionRecord> data = new HashMap<>();

    public void addTransaction(int transactionNumber, TransactionRecord transactionRecord) {
        this.data.put(transactionNumber, transactionRecord);
    }

    public void updateTransaction(int transactionNumber, TransactionRecord newRecord) {
        this.data.put(transactionNumber, newRecord);
    }

    public void deleteTransaction(int transactionNumber) {
        this.data.remove(transactionNumber);
    }
}
