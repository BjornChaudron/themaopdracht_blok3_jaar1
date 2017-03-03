package javafx.WerkplaatsApp.domein;

import java.io.Serializable;

public class Klant implements Serializable {
    private int klantnr;
    private int telefoonNummer;
    private String voornaam, achternaam, email;
    private Adres adres;
    /*
    * klant heeft adres gekregen
    * O2b
    * Extract method object
    * Remove Middleman

    * */


    private Klant(int knr, String vn, String an, String straat, String plaats, int tel, String em) {
        klantnr = knr;
        voornaam = vn;
        achternaam = an;
        email = em;
        telefoonNummer = tel;
        /*
        * O2b
        *
        * - Extract method object
        * */
        adres = new Adres(straat, plaats);
    }

    public Klant(String voornaam, String achternaam, String straat, String plaats) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = new Adres(straat, plaats);
    }
/*
*
*  Extract method object
*  Ob2
*
* */
    public static Klant createKlant(int knr, String vn, String an, String straat, String plaats, int tel, String em) {
        return new Klant(knr, vn, an, straat, plaats, tel, em);
    }

    public int getKlantnummer() {
        return klantnr;
    }

    public void setKlantnummer(int knr) {
        klantnr = knr;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(int telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public boolean equals(Object andere) {
        boolean b;
        if (andere instanceof Klant) {
            b = true;
        } else {
            b = false;
        }

        b = b && (this.voornaam.equals(((Klant) andere).voornaam));
        b = b && (this.achternaam.equals(((Klant) andere).achternaam));
        b = b && (this.adres.equals(((Klant) andere).adres));

        return b;
    }

    public String toString() {
        String tel = " het telefoonnummer is: " + telefoonNummer + " ";
        if (telefoonNummer == 0) {
            tel = " er is geen telefoonnummer bekend ";
        }
        String em = " en het emailadres is: " + email;
        if (email.isEmpty()) {                            //isEmpty is niet zeker
            em = " en er is geen emailadres bekend ";
        }
        return voornaam + " " + achternaam + "(klantnummer " + klantnr + ") woont op " + adres.getStraat() + " in " + tel + em;
    }

    private class Adres {
        private String straat, plaats;


        public Adres(String straat, String plaats) {
            this.straat = straat;
            this.plaats = plaats;
        }

        public String getStraat() {
            return straat;
        }

        public void setStraat(String straat) {
            this.straat = straat;
        }


        public String getPlaats() {
            return plaats;
        }

        public void setPlaats(String plaats) {
            this.plaats = plaats;
        }
    }
}
