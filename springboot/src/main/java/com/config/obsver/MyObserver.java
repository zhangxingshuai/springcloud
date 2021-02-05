package com.config.obsver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Observable;
import java.util.Observer;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyObserver implements Observer { //观察者
    private String name;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者：发现 " + arg);
    }
}
