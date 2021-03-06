package com.networknt.tram.event.subscriber;

import com.networknt.tram.event.common.DomainEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DomainEventHandlersBuilder {
  private String aggregateType;
  private List<DomainEventHandler> handlers = new ArrayList<>();

  public DomainEventHandlersBuilder(String aggregateType) {
    this.aggregateType = aggregateType;
  }

  public static DomainEventHandlersBuilder forAggregateType(String aggregateType) {
    return new DomainEventHandlersBuilder(aggregateType);
  }

  @SuppressWarnings("unchecked")
  public <E extends DomainEvent> DomainEventHandlersBuilder onEvent(Class<E> eventClass, Consumer<DomainEventEnvelope<E>> handler) {
    handlers.add(new DomainEventHandler(aggregateType, ((Class<DomainEvent>) eventClass), (e) -> handler.accept((DomainEventEnvelope<E>) e)));
    return this;
  }

  public DomainEventHandlers build() {
    return new DomainEventHandlers(handlers);
  }
}
