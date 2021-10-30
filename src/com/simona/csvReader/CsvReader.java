package com.simona.csvReader;

import java.util.logging.Logger;

public class CsvReader {

    final private Logger logger;

    public CsvReader(String filename){
        logger = Logger.getLogger("CsvReader");
    }

    public void read() {
        logger.info("salut");
    }
}
