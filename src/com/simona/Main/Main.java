package com.simona.Main;

import com.simona.RevolutData.RevolutData;
import com.simona.RevolutData.TransactionRecord;
import com.simona.csvReader.CsvReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String version = "v0.0.1";

    public static void main(String[] args) {
        System.out.println("Revolut Statement Parser " + version);

        CsvReader csvReader = new CsvReader();
        RevolutData revolutData = new RevolutData("Data/account-statement_2020-01-01_2021-10-30_b60c17.csv", csvReader);
        try {
            revolutData.loadData();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
