
public class Geschäftskunde extends Kunde {

	private String firmenname;
	private Adresse domizilAdresse;
	
	public Geschäftskunde (Konto konto, String firmenname, Adresse domizilAdresse) {
		super(konto);
		this.firmenname = firmenname;
		this.domizilAdresse = domizilAdresse;
	}
}
