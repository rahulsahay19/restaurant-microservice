package org.food.ordering.system.domain.event;

//Act as marker interface, It will have to mark the event object
//It will have to mark an event object with the type of entity that will fire that event
public interface DomainEvent<T> {
    void fire();
}
