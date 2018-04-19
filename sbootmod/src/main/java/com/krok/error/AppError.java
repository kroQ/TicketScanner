package com.krok.error;

/**
 * Created by Mateusz Krok on 2018-04-19.
 */
public interface AppError {

    String name();

    int ordinal();

    String getMessage();

}
