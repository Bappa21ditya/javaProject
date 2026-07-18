package com.security.java_project.system_design.pattern.MustMaster;

public class DoubleLocking {

    // private instance

    private static volatile DoubleLocking doubleLockingInstance;

    // private constructor
    private DoubleLocking(){
        System.out.println("Singleton instance created");
    };

    // public static method to get instances

    public static DoubleLocking getDoubleLockingInstance()
    {
        if(doubleLockingInstance==null)
        {
            // t1, t2 came same time here, t1 wil go and check if null create object, now t2 will enter and came back cause already created
            synchronized (DoubleLocking.class)
            {


                if(doubleLockingInstance==null) {
                    doubleLockingInstance = new DoubleLocking();
                }
            }
        }
        return doubleLockingInstance;
    }



}
