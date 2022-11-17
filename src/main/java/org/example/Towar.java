package org.example;

/* ---GRASP---
Klasa, która posiada nazwę i cenę pojedynczego produktu
 */
public class Towar
{
    String nazwa;
    public double cena;
    public Towar( final String nazwa, final double cena )
    {
        this.nazwa = nazwa;
        this.cena = cena;
    }
}
