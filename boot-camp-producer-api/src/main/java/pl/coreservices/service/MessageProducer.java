package pl.coreservices.service;

public interface MessageProducer<T> {

    void sendMessage(T message);

}
