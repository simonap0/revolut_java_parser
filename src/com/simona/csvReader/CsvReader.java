package com.simona.csvReader;

import java.util.logging.Logger;

public class CsvReader {

    private Logger logger;

    public CsvReader(String filename){
        logger = Logger.getLogger("CsvReader");
    }

    public void test() {
        logger.info("test");
    }
}
