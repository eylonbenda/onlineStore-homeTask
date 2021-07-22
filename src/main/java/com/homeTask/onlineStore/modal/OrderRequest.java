package com.homeTask.onlineStore.modal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {

    private List<Groceris> groceries;

    public OrderRequest(List<Groceris> grocerises) {
        this.groceries = grocerises;
    }
}
