/**
 * Kelas Katak adalah subkelas dari MakhlukBergerak yang merepresentasikan
 * seekor katak.
 * Katak dapat melompat dekat dan jauh serta memiliki skor.
 */
public class Katak extends MakhlukBergerak {
    private int skor;

    /**
     * Konstruktor untuk objek Katak. Posisi awal diatur ke 0 dan skor diatur ke
     * 100.
     */
    public Katak() {
        this.posisi = 0;
        this.skor = 100;
    }

    /**
     * Metode untuk mendapatkan skor saat ini dari Katak.
     * 
     * @return Nilai skor saat ini.
     */
    public int getSkor() {
        return skor;
    }

    /**
     * Metode untuk mengatur skor Katak.
     * 
     * @param skor Skor baru yang akan diatur.
     */
    public void setSkor(int skor) {
        this.skor = skor;
    }

    /**
     * Implementasi dari metode loncatDekat dari kelas MakhlukBergerak.
     * Katak dapat melompat dekat sejauh 1 posisi jika posisi saat ini kurang dari
     * 299.
     */
    @Override
    public void loncatDekat() {
        if (posisi < 299) {
            posisi += 1;
        }
    }

    /**
     * Implementasi dari metode loncatJauh dari kelas MakhlukBergerak.
     * Katak dapat melompat jauh sejauh 2 posisi jika posisi saat ini kurang dari
     * 298.
     */
    @Override
    public void loncatJauh() {
        if (posisi < 298) {
            posisi += 2;
        }
    }
}
