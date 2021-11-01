package com.simona.csvReader;

import com.simona.RevolutData.TransactionRecord;

import java.text.ParseException;
import java.util.ArrayList;

public interface ICsvReader {
    ArrayList<TransactionRecord> readCsv(String filename) throws ParseException;
}
