package pl.coreservices.service;

public interface ServiceListener<T> {
    void service(T object);
}
