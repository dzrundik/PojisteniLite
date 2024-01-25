package PojisteniLite;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static Evidence evidence;

    // Konstanty pro volby menu
    private static final int VOLBA_PRIDAT_POJISTENEHO = 1;
    private static final int VOLBA_ZOBRAZIT_EVIDENCI = 2;
    private static final int VOLBA_VYHLEDAT_POJISTENEHO = 3;
    private static final int VOLBA_KONEC = 4;

    public static void main(String[] args) {
        scanner = new Scanner(System.in, "UTF-8"); // Scaner pro čtení vstupu od uživatele
        evidence = new Evidence();  // Inicializace instance evidence pro ukládání dat

        boolean konec = false;  // Proměná pro ukončení konstrukce switch

        while (!konec) {
            System.out.println("-----------------------------");  //Základní menu aplikace
            System.out.println("Evidence pojištěných");
            System.out.println("-----------------------------");
            System.out.println("1 - Přidat nového pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");

            int volba = -1; // Proměnná pro uchování volby uživatele

            try {
                volba = scanner.nextInt(); // Přečtení volby od uživatele
            } catch (Exception e) {
                System.out.println("Neplatná volba, zadejte číslo.");
                scanner.nextLine(); // Vyčištění vstupu
                continue; // Pokračování cyklu
            }

            // Konstrukce switch pro volbu uživatele
            switch (volba) {
                case VOLBA_PRIDAT_POJISTENEHO:
                    pridatPojisteneho();  // Volání metody pro přidání klienta
                    break;
                case VOLBA_ZOBRAZIT_EVIDENCI:
                    zobrazitSeznam();  // Volání metody pro zobrazení seznamu klientů
                    break;
                case VOLBA_VYHLEDAT_POJISTENEHO:
                    vyhledatPojisteneho();  // Volání metody pro vyhledání klienta
                    break;
                case VOLBA_KONEC:
                    konec = true;  // ukončení konstrukce switch
                    break;
                default:
                    System.out.println("Neplatná volba");
                    break;
            }
        }

        scanner.close();
    }

    private static void pridatPojisteneho() {
        scanner.nextLine(); // Vyčištění bufferu
        System.out.println("Zadejte jméno:");
        String jmeno = scanner.nextLine().trim(); // Načtení jména s vyčištěním od mezer
        System.out.println("Zadejte přijímení:");
        String prijmeni = scanner.nextLine().trim(); // Načtení příjmení s vyčištěním od mezer

        int vek = -1; // Inicializace proměné pro věk
        boolean spravnyVek = false; // Inicializace proměné pro kontrolu platnosti věku

        // Cyklus probíhá, pokud věk není platný
        while (!spravnyVek) {
            try {
                System.out.println("Zadejte věk:");
                vek = scanner.nextInt();
                if (vek <= 0) {
                    System.out.println("Věk musí být kladné číslo.");
                } else {
                    spravnyVek = true; // Věk je platný a ukončí se cyklus
                }
            } catch (Exception e) {
                System.out.println("Neplatný věk, zadejte platné číslo.");
                scanner.nextLine(); // Vyčištění bufferu
            }
        }

        scanner.nextLine();  // Vyčištění bufferu pro načtení čísla
        System.out.println("Zadejte telefoní číslo:");
        String telefon = scanner.nextLine(); // Načtení telefonního čísla od klienta

        Klient pojisteny = new Klient(jmeno, prijmeni, vek, telefon);
        evidence.pridatPojisteneho(pojisteny); // Přidání nového klienta do evidence
        System.out.println("Nový pojištěný klient byl přidán.");
    }

    private static void zobrazitSeznam() {
        for (Klient p : evidence.getSeznamPojistenych()) {
            System.out.println(p.toString()); // Výpis informací o každém pojištěném
        }
    }

    private static void vyhledatPojisteneho() {
        scanner.nextLine(); // Vyčištění bufferu
        System.out.println("Zadejte jméno pojištěného:");
        String jmeno = scanner.nextLine().trim();
        System.out.println("Zadejte příjmení pojištěného:");
        String prijmeni = scanner.nextLine().trim();

        List<Klient> nalezeniKlienti = evidence.najdiPojisteneho( jmeno, prijmeni);

// Kontrola, zda seznam nalezených klientů není prázdný
        if (nalezeniKlienti != null && !nalezeniKlienti.isEmpty()) {
            // Výpis nalezených klientů
            for (Klient klient : nalezeniKlienti) {
                System.out.println(klient.toString());
            }
        } else {
            System.out.println("Pojištěný s daným jménem a příjmením nebyl nalezen.");
        }
    }
}