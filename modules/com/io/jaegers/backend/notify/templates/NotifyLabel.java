package com.io.jaegers.backend.notify.templates;

public class NotifyLabel
        implements Comparable<NotifyLabel>
{
    public NotifyLabel( String label, String description )
    {
        this.setLabel( label );
        this.setDescription( description );
    }

    // Variables
    private String label = null;

    private String description = null;

    // Accessors
    public String getLabel()
    {
        return this.label;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setLabel( String label )
    {
        this.label = label;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }


    @Override
    public int compareTo( NotifyLabel o )
    {
        return this.getLabel().compareTo( o.getLabel() );
    }
}
