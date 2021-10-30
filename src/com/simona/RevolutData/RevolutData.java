package com.simona.RevolutData;

import com.simona.csvReader.CsvReader;
import com.simona.csvReader.ICsvReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class RevolutData {

    public HashMap<Integer, TransactionRecord> data = new HashMap<>();
    public ICsvReader reader;
    final private String sourceFilename;
    final private Logger logger;

    public RevolutData(String filename, ICsvReader reader) {
        this.logger = Logger.getLogger("RevolutDataLoader", RevolutData.class.getName());

        this.reader = reader;
        this.sourceFilename = filename;
    }

    public void loadData() {
        ArrayList<TransactionRecord> transactions = reader.readCsv(sourceFilename);
        for (int i = 0; i < transactions.size(); i++) {
            this.addTransaction(i, transactions.get(i));
        }

        logger.info("Finished loading data from csv. Transactions loaded: " + this.data.size());
    }

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
