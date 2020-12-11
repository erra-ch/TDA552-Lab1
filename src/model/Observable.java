package model;

public interface Observable {

    void notifyObservers();

    void update();

    void addObserver(Observer obs);

    void removeObserver(Observer obs);
}