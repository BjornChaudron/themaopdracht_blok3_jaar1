package javafx.WerkplaatsApp.domein;

public abstract class IArtikel implements Artikel {
	protected String omschrijving;
	protected String locatie;
	protected double prijs;
	protected int artNummer;
	protected int aantal;
	public IArtikel(String om, double pr, String loc, int art, int aant){
		omschrijving = om;
		locatie = loc;
		prijs = pr;
		artNummer = art;
		aantal=aant;
	}

	@Override
    public String getOmschrijving() {
		return omschrijving;
	}

	@Override
    public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	@Override
    public String getLocatie() {
		return locatie;
	}

	@Override
    public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	@Override
    public double getPrijs() {
		return prijs;
	}

	@Override
    public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	@Override
    public int getArtNummer() {
		return artNummer;
	}
	@Override
    public void setAantal(int aantal) {
		this.aantal += aantal;
	}
	@Override
    public int getAantal() {
		return aantal;
	}

	@Override
    public void setArtNummer(int artNummer) {
		this.artNummer = artNummer;
	}
	@Override
    public boolean equals(Object obj){ //overridden versie van methode equals in klasse artikel, om zo een heel artikel object te kunnen vergelijken
		boolean b;
		if(obj instanceof IArtikel){
			b = true;
		}
		else{
			b = false;
		}
		b = b && (this.artNummer == ((IArtikel)obj).artNummer);
		b = b && (this.omschrijving == ((IArtikel)obj).omschrijving);
		b = b && (this.locatie == ((IArtikel)obj).locatie);
		b = b && (this.prijs == ((IArtikel)obj).prijs);
		return b;
	}
	public String toString()
	{
		return "Artikelnummer: "+artNummer+" aantal: "+aantal;
	}
}
