package org.example;

public class BadDataException extends Exception
{
    public BadDataException()
    {
        super( "Wprowadzono błędne dane!" );
    }
}
