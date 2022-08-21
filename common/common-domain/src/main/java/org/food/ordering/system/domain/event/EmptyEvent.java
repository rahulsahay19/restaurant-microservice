package org.food.ordering.system.domain.event;

//This Empty Event is just a marker class
public final class EmptyEvent implements DomainEvent<Void> {
    //Create a singleton instance
    public static final EmptyEvent INSTANCE = new EmptyEvent();

    private EmptyEvent() {
    }

    @Override
    public void fire() {

    }
}
