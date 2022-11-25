package com.io.jaegers.backend.io.files.algorithms.interfaces;

/**
 *
 */
public interface FoundInterface
{
    /**
     *
     * @param path
     */
    void CurrentDirectory( String path );

    /**
     *
     * @param path
     */
    void FoundDirectory( String path );

    /**
     *
     * @param path
     */
    void FoundFile( String path );

    /**
     *
     * @return
     */
    FoundSettingsInterface getSettings();
}
