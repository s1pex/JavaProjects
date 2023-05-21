/**
 *
 *  @author Raksha Vladyslav S24676
 *
 */

package zad1;


public class Purchase{

    String imie;
    String nazwisko;
    String id;

    String produkt;
    float cenaZaJednostke;
    float iloscProduktu;

    String calaLinijka;

    public Purchase(String calaLinijka) {
        this.calaLinijka = calaLinijka;
    }


    public void setName(String imie) {
        this.imie = imie;
    }


    public String getName() {
        return imie;
    }


    public void setSurname(String nazwisko) {
        this.nazwisko = nazwisko;
    }


    public String getSurname() {
        return nazwisko;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }


    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }


    public void setPrice(float cenaZaJednostke) {
        this.cenaZaJednostke = cenaZaJednostke;
    }


    public float getPrice() {
        return cenaZaJednostke;
    }


    public void setQuantity(float iloscProduktu) {
        this.iloscProduktu = iloscProduktu;
    }


    public float getQuantity() {
        return iloscProduktu;
    }


    public String getLine() {
        return calaLinijka;
    }


    public void setLine(String calaLinijka) {
        this.calaLinijka = calaLinijka;
    }
}