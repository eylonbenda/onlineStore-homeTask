package com.homeTask.onlineStore.modal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {

    private String name;
    private String quantity;

    public OrderRequest(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
