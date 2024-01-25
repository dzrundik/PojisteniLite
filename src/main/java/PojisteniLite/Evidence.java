package PojisteniLite;

import java.util.ArrayList;
import java.util.List;

public class Evidence {
    private List<Klient> seznamPojistenych;
    //vytvoření evidence

    public Evidence(){
        seznamPojistenych = new ArrayList<>();
    }
    // přidání klienta do evidence
    public void pridatPojisteneho(Klient pojisteny){
        seznamPojistenych.add(pojisteny);
    }
    // zobrazení celé evidence
    public List<Klient> getSeznamPojistenych(){
        return seznamPojistenych;
    }
    // hledání klienta podle jména
    public List<Klient> najdiPojisteneho(String jmeno, String prijmeni){
        List<Klient> nalezeniKlienti = new ArrayList<>();

        // průchod celou evidencí
        for(Klient p : seznamPojistenych){
            //pokud najde klienta, který má stejné jméno a přijímení, přidá ho do seznamu
            if(p.getJmeno().equalsIgnoreCase(jmeno) && p.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                nalezeniKlienti.add(p);
            }
        }

        return nalezeniKlienti; //vrátí seznam nalezených klientů
    }
}