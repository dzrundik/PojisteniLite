package PojisteniLite;

public class Klient {
    // Privátní atributy pro ukládání informací o klientovi
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefon;

    // Konstruktor třídy Klient - inicializuje atributy klienta
    public Klient(String jmeno, String prijmeni, int vek, String telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }

    // Getter pro získání jména klienta
    public String getJmeno() {
        return jmeno;
    }

    // Getter pro získání příjmení klienta
    public String getPrijmeni() {
        return prijmeni;
    }

    // Getter pro získání věku klienta
    public int getVek() {
        return vek;
    }

    // Getter pro získání telefonního čísla klienta
    public String getTelefon() {
        return telefon;
    }

    // Přepsaná metoda pro výpis informací o klientovi
    @Override
    public String toString() {
        return "Jméno: " + jmeno + "\n" +
                "Příjmení: " + prijmeni + "\n" +
                "Věk: " + vek + "\n" +
                "Telefon: " + telefon + "\n";
    }
}