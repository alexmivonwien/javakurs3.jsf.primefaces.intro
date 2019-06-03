package jsf.intro.contact;

import javax.faces.bean.ManagedBean;

@ManagedBean
// No scope provided - defaults to @RequestScope 
public class ContactBean {
	
	private String strasse;
	private short hausNummer;
	private String ort;
	private int plz;
	
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public short getHausNummer() {
		return hausNummer;
	}
	public void setHausNummer(short hausNummer) {
		this.hausNummer = hausNummer;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public int getPlz() {
		return plz;
	}
	public void setPlz(int plz) {
		this.plz = plz;
	}
	
}
