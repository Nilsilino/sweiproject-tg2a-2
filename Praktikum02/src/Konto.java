
public class Konto {
	
	private String bezeichnung;
	private Kunde zeichnungsberechtigter;
	
	public Konto(Kunde zeichnungsberechtigter, String bezeichnung) {
		this.zeichnungsberechtigter = zeichnungsberechtigter;
		this.bezeichnung = bezeichnung;
	}
	
	public GeldBetrag saldo() {
		
	}

}
