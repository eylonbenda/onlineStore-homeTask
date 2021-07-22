package com.homeTask.onlineStore;

import com.homeTask.onlineStore.modal.Product;
import com.homeTask.onlineStore.utils.CSVUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CSVFileTest {

    @Autowired
    private ResourceLoader resourceLoader;

    private static final String classPathFile = "classpath:assets/Iherb_categories.csv";

    @Test
    public void testLoadCSVFile() throws IOException {

        Resource resource = resourceLoader.getResource(classPathFile);
        List<Product> products = CSVUtils.loadCsvFile(resource.getInputStream());
        assertTrue(!products.isEmpty());
        assertTrue(products.size() == 2148);
    }

}