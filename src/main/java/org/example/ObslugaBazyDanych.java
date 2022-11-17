package org.example;

public class ObslugaBazyDanych
{
    private final InterfejsBazyDanych interfejsBD;

    public ObslugaBazyDanych( final InterfejsBazyDanych interfejsBD )
    {
        this.interfejsBD = interfejsBD;
    }

    public void dodajDoBazyDanych( final Faktura faktura )
    {
        interfejsBD.dodajDoBazyDanych( faktura );
    }
}
