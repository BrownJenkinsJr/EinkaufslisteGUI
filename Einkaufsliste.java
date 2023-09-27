/**
 * Die Klasse Einkaufsliste verfügt über die elementaren Funktionen einer Liste.
 * Man kann Artikel einfügen, suchen und löschen. Die Einkaufsliste kann auch
 * ausgegeben werden.
 * 
 */
public class Einkaufsliste
{
    List<Artikel> einkaufsliste;
    
    public Einkaufsliste()
    {
        einkaufsliste = new List<Artikel>();
        einkaufsliste.append(new Artikel("Eier"));
        einkaufsliste.append(new Artikel("Butter"));
        einkaufsliste.append(new Artikel("Zucker"));
        einkaufsliste.append(new Artikel("Gurken"));
    }

    /** Die Liste wird um einen neuen Artikel ergänzt.
     * @param pArtikel Objekt vom Typ Artikel wird angehängt
     */
    public void neuerArtikel(Artikel pArtikel) {
        einkaufsliste.append(pArtikel);
    }

    /** Die Einkaufsliste wird nach einem Artikel durchsucht.
     * @param pName Der Name des Artikels vom Typ String ist der Suchparameter
     * @return true oder false
     */
    public boolean sucheArtikel(String pName) {
        boolean gefunden = false;
        einkaufsliste.toFirst();
        while (gefunden == false && einkaufsliste.hasAccess()) {
            if (pName.equals(einkaufsliste.getContent().getArtikelname())){
                gefunden = true;
            }
            else {
                einkaufsliste.next();
            }
        }
        return gefunden;
    }

    /** Ein Artikel wird von der Einkaufsliste gelöscht.
     * @param pName Der Name gibt an, welcher Artikel gelöscht werden soll
     * Wird der zu löschende Artikel nicht gefunden, passiert nichts
     */
    public void loeschen(String pName) {
        if (sucheArtikel(pName))
        {
            einkaufsliste.remove();
        }
        else {
            System.out.println("Zu löschendes Element nicht auf dem Zettel gefunden");
        }
    }

    /** Die Einkaufsliste wird ausgegeben
     * 
     */
    public void listeAusgeben() {
        einkaufsliste.toFirst();
        System.out.println("Einkaufsliste:");
        while (einkaufsliste.hasAccess()) {
            System.out.println(einkaufsliste.getContent().getArtikelname());
            einkaufsliste.next();
        }
    } // Ende listeAusgeben()
}