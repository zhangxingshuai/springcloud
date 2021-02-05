package com.config.obsver;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Observable;
@Data
@NoArgsConstructor
public class MyObservable extends Observable { //被观察者

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        super.notifyObservers("被观察者的name发生了变化：" + this.name + " -> " + name);
        super.notifyObservers();
        this.name = name;
    }
}
