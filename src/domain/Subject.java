package domain;

public interface Subject {

    void registerObserver(EventTypeEnum e,Observer observer);
    void removeObserver(EventTypeEnum e,Observer observer);
    void notifyObservers(EventTypeEnum e);
}
