package com.homeTask.onlineStore.utils;


import com.homeTask.onlineStore.modal.Product;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


public class CSVUtils {



    public static List<Product> loadCsvFile(InputStream is) {


        String[] CSV_HEADER = { "product_id", "product_name", "product_company",
                "category" , "product_size" , "product_price"};

        Reader fileReader = null;
        CsvToBean<Product> csvToBean = null;

        List<Product> products = new ArrayList<Product>();

        try {
            fileReader = new InputStreamReader(is);

            ColumnPositionMappingStrategy<Product> mappingStrategy =
                    new ColumnPositionMappingStrategy<Product>();

            mappingStrategy.setType(Product.class);
            mappingStrategy.setColumnMapping(CSV_HEADER);

            csvToBean = new CsvToBeanBuilder<Product>(fileReader)
                    .withMappingStrategy(mappingStrategy).withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true).build();

            products = csvToBean.parse();

            return products;
        } catch (Exception e) {
            System.out.println("Reading CSV Error!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Closing fileReader/csvParser Error!");
                e.printStackTrace();
            }
        }
        return products;
    }
}
