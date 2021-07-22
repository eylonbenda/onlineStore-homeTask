package com.homeTask.onlineStore.controllers;


import com.homeTask.onlineStore.modal.OrderRequest;
import com.homeTask.onlineStore.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/api/v1/order")
    public ResponseEntity<?> setOrder(@RequestBody OrderRequest orderRequest){

        String res = storeService.calculatePrice(orderRequest);
        return new ResponseEntity<>(res , HttpStatus.CREATED);

    }
}
