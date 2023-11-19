/**
 * Kelas generik Kotak digunakan untuk menyimpan suatu objek dengan tipe
 * tertentu.
 *
 * @param <T> Tipe data dari objek yang akan disimpan dalam kotak.
 */
public class Kotak<T> {
    private T isi;

    /**
     * Konstruktor default untuk objek Kotak. Kotak awalnya tidak memiliki isi.
     */
    public Kotak() {
        this.isi = null;
    }

    /**
     * Metode untuk menambahkan isi ke dalam kotak.
     *
     * @param isi Objek yang akan dimasukkan ke dalam kotak.
     */
    public void addIsi(T isi) {
        this.isi = isi;
    }

    /**
     * Metode untuk mendapatkan isi dari kotak.
     *
     * @return Isi dari kotak.
     */
    public T getIsi() {
        return isi;
    }

    /**
     * Metode untuk memeriksa apakah kotak memiliki isi atau tidak.
     *
     * @return True jika kotak memiliki isi, false jika tidak.
     */
    public boolean isThereIsi() {
        return isi != null;
    }
}
