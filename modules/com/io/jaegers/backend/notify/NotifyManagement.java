package com.io.jaegers.backend.notify;

import com.io.jaegers.backend.notify.batches.NotifyBatch;

public class NotifyManagement
{
    public NotifyManagement()
    {
        this.setBatch(
                new NotifyBatch()
        );
    }



    // Variables
    private static NotifyManagement notifySingleton = null;

    private NotifyBatch batch = null;

    private boolean isDebugging = false;


    // Accessors
    public static NotifyManagement getNotifySingleton()
    {
        if( NotifyManagement.notifySingleton == null )
        {
            NotifyManagement newManager = new NotifyManagement();
            setNotifySingleton( newManager );
        }

        return NotifyManagement.notifySingleton;
    }

    public static void setNotifySingleton( NotifyManagement notifySingleton )
    {
        NotifyManagement.notifySingleton = notifySingleton;
    }

    public NotifyBatch getBatch()
    {
        return batch;
    }

    public void setBatch(NotifyBatch batch)
    {
        this.batch = batch;
    }

    public boolean isDebugging()
    {
        return this.isDebugging;
    }

    public void setDebugging( boolean debugging )
    {
        this.isDebugging = debugging;
    }

    public static void main(String[] args )
    {
        NotifyManagement management = NotifyManagement.getNotifySingleton();


    }
}
