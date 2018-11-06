package pl.coreservices.service;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class MessageListener<T> {

    private List<ServiceListener<T>> listeners;

    public MessageListener() {
        this.listeners = Lists.newArrayList();
    }

    public void addListener(ServiceListener<T> serviceListener) {
        listeners.add(serviceListener);
    }

    protected void callListeners(T message) {
        for(ServiceListener listener:listeners) {
            listener.service(message);
        }
    }

    public abstract void onMessage(T object);

}
