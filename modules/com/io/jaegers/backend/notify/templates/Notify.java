package com.io.jaegers.backend.notify.templates;

import java.util.ArrayList;
import java.util.List;


public class Notify
        implements Comparable<Notify>
{
    public Notify()
    {
        this.setLabels( new ArrayList<>() );
    }

    public Notify( NotifyType type )
    {
        this();
        this.setType( type );
    }

    // Variables
    private NotifyType type = NotifyType.Misc;

    private String message = null;

    private String additionalMessage = null;

    private String summary = null;

    private List<NotifyLabel> labels = null;


    // Accessors
    public NotifyType getType()
    {
        return this.type;
    }

    public void setType( NotifyType type )
    {
        this.type = type;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }

    public String getAdditionalMessage()
    {
        return this.additionalMessage;
    }

    public void setAdditionalMessage( String additionalMessage )
    {
        this.additionalMessage = additionalMessage;
    }

    public String getSummary()
    {
        return this.summary;
    }

    public void setSummary( String summary )
    {
        this.summary = summary;
    }

    public List<NotifyLabel> getLabels()
    {
        return labels;
    }

    public void setLabels( List<NotifyLabel> labels )
    {
        this.labels = labels;
    }

    @Override
    public int compareTo( Notify o )
    {
        return this.getType().compareTo( o.getType() );
    }
}
