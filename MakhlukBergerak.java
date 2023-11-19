/**
 * Kelas abstrak MakhlukBergerak adalah kelas dasar untuk merepresentasikan
 * makhluk yang dapat bergerak
 * dan mengimplementasikan antarmuka DapatDilompati.
 */
public abstract class MakhlukBergerak implements DapatDilompati {
    protected int posisi;

    /**
     * Metode untuk mendapatkan posisi makhluk.
     *
     * @return Posisi dari makhluk.
     */
    public int getPosisi() {
        return posisi;
    }

    /**
     * Metode untuk mengatur posisi makhluk.
     *
     * @param posisi Posisi baru yang akan diatur untuk makhluk.
     */
    public void setPosisi(int posisi) {
        this.posisi = posisi;
    }
}
