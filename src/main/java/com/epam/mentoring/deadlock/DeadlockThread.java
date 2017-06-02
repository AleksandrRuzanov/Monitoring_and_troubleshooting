package com.epam.mentoring.deadlock;

public class DeadlockThread {
    private Entity entity1;
    private Entity entity2;
    private Entity entity3;

    public DeadlockThread() {
        this.entity1 = new Entity(1,"entity1");
        this.entity2 = new Entity(2,"entity2");
        this.entity3 = new Entity(3,"entity3");
    }

    public void setDeadlock() {
        new Thread(new ThreadProcessDeadlock(entity1, entity2)).start();
        new Thread(new ThreadProcessDeadlock(entity2, entity3)).start();
        new Thread(new ThreadProcessDeadlock(entity3, entity1)).start();

    }

    public void setDeadlockSafe() {
        new Thread(new ThreadProcessDeadlockSafe(entity1, entity2)).start();
        new Thread(new ThreadProcessDeadlockSafe(entity2, entity3)).start();
        new Thread(new ThreadProcessDeadlockSafe(entity3, entity1)).start();

    }
}
