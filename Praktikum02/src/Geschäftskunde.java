
public class Gesch�ftskunde extends Kunde {

	private String firmenname;
	private Adresse domizilAdresse;
	
	public Gesch�ftskunde (Konto konto, String firmenname, Adresse domizilAdresse) {
		super(konto);
		this.firmenname = firmenname;
		this.domizilAdresse = domizilAdresse;
	}
}
