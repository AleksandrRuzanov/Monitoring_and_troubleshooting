package com.epam.mentoring.deadlock;

import org.apache.log4j.Logger;

public class ThreadProcessDeadlockSafe implements Runnable {

    private static final Logger LOG = Logger.getLogger(ThreadProcessDeadlockSafe.class);
    private Entity entity1;
    private Entity entity2;

    public ThreadProcessDeadlockSafe(Entity entity1, Entity entity2) {
        this.entity1 = entity1.getId() < entity2.getId() ? entity1 : entity2;
        this.entity2 = entity1.getId() > entity2.getId() ? entity1 : entity2;
    }

    public void run() {
        try {
            LOG.info("wait lock " + entity1.toString());
            entity1.getLock().writeLock().lock();
            entity2.getLock().writeLock().lock();
            Thread.sleep(1000);
            LOG.info("set lock " + entity1.toString());
            LOG.info("wait lock " + entity2.toString());
            Thread.sleep(1000);
            LOG.info("set lock " + entity2.toString());
        } catch (InterruptedException e) {
        } finally {
            entity2.getLock().writeLock().unlock();
            entity1.getLock().writeLock().unlock();
            LOG.info("unlock");
        }
    }
}
