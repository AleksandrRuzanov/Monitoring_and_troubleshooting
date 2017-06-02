package com.epam.mentoring;

import com.epam.mentoring.deadlock.DeadlockThread;

public class App
{
    public static void main( String[] args )
    {
        DeadlockThread deadlockThread = new DeadlockThread();
        deadlockThread.setDeadlockSafe();
    }
}
