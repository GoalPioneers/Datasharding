package com.io.jaegers.backend.notify.batches;

import com.io.jaegers.backend.notify.templates.Notify;

import java.util.ArrayList;
import java.util.List;

public class NotifyBatch
{
    public NotifyBatch()
    {

    }

    private List<Notify> notifications = new ArrayList<>();

    public List<Notify> getNotifications()
    {
        return this.notifications;
    }

    public void setNotifications( List<Notify> notifications )
    {
        this.notifications = notifications;
    }
}
