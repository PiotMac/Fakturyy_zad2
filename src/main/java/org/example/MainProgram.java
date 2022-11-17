package org.example;

import java.util.Scanner;

/* ---GRASP---
Ekspert, który odpowiada za dane wprowadzane przez użytkownika i stworzenie obiektu faktury
*/
public final class MainProgram
{
    private MainProgram(){}
    public static void main( final String[] args ) throws BadDataException
    {
        Scanner scan = new Scanner( System.in );
        System.out.println( "Czy chciał*byś wystawić fakturę?[T/N]" );
        String wiadomosc = scan.nextLine();
        switch ( wiadomosc )
        {
            case "T" ->
            {
                Faktura faktura = new Faktura();
                System.out.println( "Imię klienta: " );
                String imie = scan.nextLine();
                System.out.println( "Nazwisko klienta: " );
                String nazwisko = scan.nextLine();
                faktura.setDane( imie, nazwisko );
                String elementyWiadomosc;
                elementyWiadomosc = "T";
                while( "T".equalsIgnoreCase( elementyWiadomosc ) )
                {
                    System.out.println( "Czy chcial*bys dodac element?[T/N]" );
                    elementyWiadomosc = scan.nextLine();
                    switch( elementyWiadomosc )
                    {
                        case "T" ->
                        {
                            System.out.println( "Podaj nazwę artykułu: " );
                            String artykul = scan.nextLine();
                            System.out.println( "Podaj ilość artykułu: " );
                            int ilosc;
                            double cena;
                            try
                            {
                                ilosc = Integer.parseInt( scan.nextLine() );
                                System.out.println( "Podaj cenę brutto za jeden artykuł: " );
                                cena = Double.parseDouble( scan.nextLine() );
                            }
                            catch ( NumberFormatException ex )
                            {
                                throw new BadDataException();
                            }
                            faktura.addElement( artykul, ilosc, cena );
                        }
                        case "N" ->
                        {
                            System.out.println( "Oto Twoja faktura: \n" );
                            faktura.getFaktura();
                            System.out.println( "Czy chciał*byś dodać tę fakturę do bazy danych?[T/N]" );
                            wiadomosc = scan.nextLine();
                            switch ( wiadomosc )
                            {
                                case "T" ->
                                {
                                    ObslugaBazyDanych obslugaBD = new ObslugaBazyDanych( new ImportDoBazyDanych() );
                                    obslugaBD.dodajDoBazyDanych( faktura );
                                }
                                case "N" -> System.out.println( "Nie zapisano w bazie danych." );
                                default ->
                                {
                                    while( !( "T".equals( wiadomosc ) ) && !( "N".equals( wiadomosc ) ) )
                                    {
                                        System.out.println( "Wprowadzono błędne dane, spróbuj jeszcze raz." );
                                        System.out.println( "Czy chciał*byś dodać tę fakturę do bazy danych?[T/N]" );
                                        wiadomosc = scan.nextLine();
                                    }
                                }
                            }
                        }
                        default ->
                        {
                            while( !( "T".equals( elementyWiadomosc ) ) && !( "N".equals( elementyWiadomosc ) ) )
                            {
                                System.out.println( "Wprowadzono błędne dane, spróbuj jeszcze raz." );
                                System.out.println( "Czy chcial*bys dodac element?[T/N]" );
                                elementyWiadomosc = scan.nextLine();
                            }
                        }
                    }
                }
            }
            case "N" -> System.out.println( "Nie chcę." );
            default -> throw new BadDataException();
        }
    }
}
