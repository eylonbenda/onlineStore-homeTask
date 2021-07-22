package com.homeTask.onlineStore.modal;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Groceris {

    private String name;
    private String quantity;

    public Groceris(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
