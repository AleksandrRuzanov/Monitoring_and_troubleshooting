package com.epam.mentoring.deadlock;

import org.apache.log4j.Logger;

public class ThreadProcessDeadlock implements Runnable {
    private static final Logger LOG = Logger.getLogger(ThreadProcessDeadlock.class);
    private Entity entity1;
    private Entity entity2;

    public ThreadProcessDeadlock(Entity entity1, Entity entity2) {
        this.entity1 = entity1;
        this.entity2 = entity2;
    }

    public void run() {
        LOG.info("wait lock " + entity1.toString());
        synchronized (entity1) {
            try {
                Thread.sleep(100);
                LOG.info("set lock " + entity1.toString());
                LOG.info("wait lock " + entity2.toString());
                synchronized (entity2) {
                    Thread.sleep(100);
                    LOG.info("set lock " + entity2.toString());
                }
            } catch (InterruptedException e) {
            }
        }
        LOG.info("unlock");
    }
}
