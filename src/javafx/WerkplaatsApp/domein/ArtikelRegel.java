package javafx.WerkplaatsApp.domein;


public class ArtikelRegel  {
	private IArtikel artikel;
	private int aantal;
	
	public ArtikelRegel(IArtikel artikel, int aantal)
	{
		this.artikel = artikel;
		this.aantal = aantal;
	}
	
	public void setArtikel(IArtikel artikel) {
		this.artikel = artikel;
	}

	public IArtikel getArtikel(){
		return artikel;
	}
}
