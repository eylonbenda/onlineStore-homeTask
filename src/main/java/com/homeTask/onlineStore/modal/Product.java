package com.homeTask.onlineStore.modal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    private Long product_id;
    private String product_name;
    private String product_company;
    private String category;
    private String product_size;
    private String product_price;


}
