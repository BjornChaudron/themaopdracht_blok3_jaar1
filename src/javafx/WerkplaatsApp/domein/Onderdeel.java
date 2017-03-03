package javafx.WerkplaatsApp.domein;

public class Onderdeel {
	private final MyIArtikel artikel;
	private int aantal;
/*
* Replace inheritance with delegation
Ob2
* */
	public Onderdeel(String om, double pr, String loc, int art, int d) {
		artikel = new MyIArtikel(om, pr, loc, art, d);
		Onderdeel.this.aantal = d;
	}

	public IArtikel getArtikel() {
		return artikel;
	}

	public boolean equals(Object obj) {
		return artikel.equals(obj);
	}


	private class MyIArtikel extends IArtikel {
		public MyIArtikel(String om, double pr, String loc, int art, int aant) {
			super(om, pr, loc, art, aant);
		}

		public int getAantal() {
            return Onderdeel.this.aantal;
        }
	}
}
