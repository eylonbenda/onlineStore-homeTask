package com.homeTask.onlineStore.modal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {

    private String message;
    private String statusCode;

    public OrderResponse(String message , String statusCode){
        this.message = message;
        this.statusCode = statusCode;
    }
}
