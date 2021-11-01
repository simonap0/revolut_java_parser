package com.simona.csvReader;

import com.simona.RevolutData.TransactionRecord;
import com.simona.RevolutData.TransactionType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

public class CsvReader implements ICsvReader {

    final private Logger logger;

    public CsvReader() {
        this.logger = Logger.getLogger("CsvReaderLogger");
    }

    public ArrayList<TransactionRecord> readCsv(String filename) throws ParseException {

        ArrayList<TransactionRecord> transactionRecords = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy hh:mm");
        boolean skippedHeader = false;

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                if (!skippedHeader) {
                    skippedHeader = true;
                    scanner.nextLine();
                    continue;
                }
                String nextLine = scanner.nextLine();
                String[] fields = nextLine.split(",");

                TransactionRecord transactionRecord = new TransactionRecord();
                transactionRecord.accountName = fields[1];
                transactionRecord.transactionDate = formatter.parse(fields[2]);
                transactionRecord.description = fields[4];
                transactionRecord.amount = Float.parseFloat(fields[5]);
                transactionRecord.currency = fields[7];
                transactionRecord.transactionType = TransactionType.valueOf(fields[0]);

                transactionRecords.add(transactionRecord);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            logger.severe(fileNotFoundException.getMessage());

            fileNotFoundException.printStackTrace();
        }
        return transactionRecords;
    }
}
