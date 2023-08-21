package PojisteniLite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEvidence {
    private Evidence evidence;

    @BeforeEach
    public void setUp() {
        evidence = new Evidence();
    }

    @Test
    public void testPridaniPojisteneho() {
        Klient klient = new Klient("Jan", "Novák", 30, "123456789");
        evidence.pridatPojisteneho(klient);

        assertEquals(1, evidence.getSeznamPojistenych().size());
        assertEquals(klient, evidence.getSeznamPojistenych().get(0));
    }

    @Test
    public void testVyhledaniPojisteneho() {
        Klient klient1 = new Klient("Jan", "Novák", 30, "123456789");
        Klient klient2 = new Klient("Petr", "Svoboda", 25, "987654321");

        evidence.pridatPojisteneho(klient1);
        evidence.pridatPojisteneho(klient2);

        assertEquals(1, evidence.najdiPojisteneho("Jan", "Novák") != null ? 1 : 0);
        assertEquals(null, evidence.najdiPojisteneho("František", "Hájek"));
    }
}
}
