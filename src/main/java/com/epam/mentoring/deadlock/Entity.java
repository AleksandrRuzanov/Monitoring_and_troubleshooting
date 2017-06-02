package com.epam.mentoring.deadlock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Entity {
    private long id;
    private String name;
    private ReadWriteLock lock;

    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ReadWriteLock getLock() {
        if (lock == null) {
            lock = new ReentrantReadWriteLock();
        }
        return lock;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
