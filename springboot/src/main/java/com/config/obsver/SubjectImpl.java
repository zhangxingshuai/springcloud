package com.config.obsver;

public class SubjectImpl implements ISubject{

    @Override
    public void addObserver(IObserver observer) {
        container.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        container.remove(observer);
    }

    @Override
    public void notifyObservers(Object object) {
        container.forEach(item -> {
            ((IObserver)item).update(object);
        });
    }
}
