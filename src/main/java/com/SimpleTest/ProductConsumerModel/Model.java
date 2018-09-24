package com.SimpleTest.ProductConsumerModel;

public interface Model {
    Runnable newRunnableConsumer();
    Runnable newRunnableProducer();
}
