package com.io.jaegers.application;

public class Entry
{
    public static void main( String[] arguments )
    {
        ApplicationFrontend frontend = new ApplicationFrontend();

        frontend.initialise();
        frontend.execute();
        frontend.garbage_collection();
    }
}
