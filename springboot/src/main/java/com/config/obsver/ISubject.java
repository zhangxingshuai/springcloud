package com.config.obsver;

import java.util.Vector;

public interface ISubject {

    final Vector container = new Vector(); //存放观察者容器

    void addObserver(IObserver observer); //添加观察者

    void removeObserver(IObserver observer); //移除观察者

    void notifyObservers(Object object); //通知所有观察者
}
