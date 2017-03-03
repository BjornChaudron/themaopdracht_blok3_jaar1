package javafx.WerkplaatsApp.domein;

import java.io.Serializable;

/**
 * Created by admin on 3-3-2017.
 * Ob2
 * Extract interface
 */
public interface Artikel extends Serializable {
    String getOmschrijving();

    void setOmschrijving(String omschrijving);

    String getLocatie();

    void setLocatie(String locatie);

    double getPrijs();

    void setPrijs(double prijs);

    int getArtNummer();

    void setAantal(int aantal);

    int getAantal();

    void setArtNummer(int artNummer);

    boolean equals(Object obj);
}
