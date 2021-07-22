package com.homeTask.onlineStore.services;


import com.homeTask.onlineStore.modal.OrderRequest;
import com.homeTask.onlineStore.modal.Product;
import com.homeTask.onlineStore.utils.CSVUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private ResourceLoader resourceLoader;

    private List<Product> products;

    private final Logger logger = LoggerFactory.getLogger(StoreService.class);
    private static final String CART_EMPTY = "cart shop is empty!";

    public StoreService(){ };

    @PostConstruct
    public void init(){
        try {
            Resource resource = resourceLoader.getResource("classpath:" + "assets/Iherb_categories.csv");
            products = CSVUtils.loadCsvFile(resource.getInputStream());
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public String calculatePrice(List<OrderRequest> orderProducts){

            Double[] totalPrice = {0.0};
            StringBuilder res = new StringBuilder();

            if(orderProducts.isEmpty()){
                return res.append(CART_EMPTY).toString();
            }
            orderProducts.stream().forEach((orderReq) -> {

                try {
                    Optional<Product> product = products.stream()
                            .filter(p -> p.getProduct_name().equals(orderReq.getName()))
                            .findAny();

                    if (product.isPresent()) {
                        Product pr = product.get();
                        totalPrice[0] += Double.parseDouble(product.get().getProduct_price()) *
                                Integer.parseInt(orderReq.getQuantity());

                        res.append(pr.getProduct_id())
                                .append(',').append(pr.getProduct_name())
                                .append(',').append(pr.getProduct_size())
                                .append(',').append(orderReq.getQuantity())
                                .append(',').append(pr.getProduct_price()).append("\n");
                    }
                }catch (Exception e){
                    logger.error(e.getMessage());
                }
            });

            if(totalPrice[0] == 0.0){
                return res.append("not found products!").toString();
            }

            res.append("total price - ").append(String.format("%.2f", totalPrice[0]));

            return res.toString();
    }
}
