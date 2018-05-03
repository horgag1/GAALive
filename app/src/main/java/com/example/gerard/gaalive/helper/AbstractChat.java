package com.example.gerard.gaalive.helper;

/**
 * Created by gerard on 30/04/2018.
 */

public abstract class AbstractChat {

    public abstract String getName();

    public abstract String getMessage();

    public abstract String getUid();

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

}
