/**
 * Kelas abstrak Makhluk adalah kelas dasar untuk merepresentasikan entitas
 * makhluk dalam permainan.
 */
public abstract class Makhluk {
    protected int nilai;

    /**
     * Konstruktor untuk objek Makhluk. Nilai awalnya diatur ke 0.
     */
    public Makhluk() {
        this.nilai = 0;
    }

    /**
     * Metode untuk mendapatkan nilai makhluk.
     *
     * @return Nilai dari makhluk.
     */
    public int getNilai() {
        return nilai;
    }
}
