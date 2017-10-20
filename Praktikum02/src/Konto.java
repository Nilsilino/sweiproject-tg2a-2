
public class Konto {
	
	private String bezeichnung;
	private Kunde zeichnungsberechtigter;
	private GeldBetrag betrag;
	
	public Konto(Kunde zeichnungsberechtigter, String bezeichnung, GeldBetrag betrag) {
		this.zeichnungsberechtigter = zeichnungsberechtigter;
		this.bezeichnung = bezeichnung;
		this.betrag = betrag;
	}
	
	public GeldBetrag saldo() {
		return betrag;
	}
	
	public void einzahlen(GeldBetrag eingezahlterBetrag) {
	}

}
