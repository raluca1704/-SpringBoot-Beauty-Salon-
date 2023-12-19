package org.salon_frumusete.observer;


public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
}