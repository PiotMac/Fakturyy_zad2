package org.example;

/* ---GRASP---
Klasa, która posiada nazwę i cenę pojedynczego produktu
 */
public class Towar
{
    String nazwa;
    public double cena;
    public Towar( final String nazwa, final double cena ) throws BadDataException
    {
        this.nazwa = nazwa;
        this.cena = cena;
        //Sprawdzanie miejsc po przecinku
        String check = Double.toString( cena );
        final int decimalPoint = 3;
        int integerPlaces = check.indexOf( '.' );
        int decimalPlaces = check.length() - integerPlaces - 1;
        if ( decimalPlaces >= decimalPoint )
        {
            throw new BadDataException();
        }
    }
}
