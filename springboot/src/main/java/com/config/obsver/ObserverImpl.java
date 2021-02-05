package com.config.obsver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObserverImpl implements IObserver{
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void update(Object obj) {
        System.out.println(this.name + "收到消息：" + obj.toString());
    }
}
