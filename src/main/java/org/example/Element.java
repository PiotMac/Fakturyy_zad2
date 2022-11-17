package org.example;

/* ---GRASP---
Klasa, która zna ilość towaru oraz oblicza jego łączną cenę
 */
public class Element
{
    private final Towar towar;
    public final int iloscElementu;
    public Element( final int ilosc, final Towar towar )
    {
        iloscElementu = ilosc;
        this.towar = towar;
    }

    public final void getInfo()
    {
        System.out.println( "Nazwa artykułu: " + towar.nazwa );
        System.out.println( "Ilość artykułu: " + iloscElementu );
        System.out.println( "Cena brutto za sztukę: " + towar.cena + "zł" );
        System.out.println( "Łączna cena brutto: " + ( iloscElementu * towar.cena ) + "zł" );
    }
}
