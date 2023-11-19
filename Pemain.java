/**
 * Kelas Pemain adalah kelas untuk merepresentasikan pemain dalam permainan.
 * Pemain adalah jenis Makhluk yang memiliki nilai, nama, dan dapat mengubah
 * nama serta nilai.
 */
public class Pemain extends Makhluk {
    private String nama;

    /**
     * Konstruktor untuk objek Pemain dengan nama tertentu.
     *
     * @param nama Nama pemain.
     */
    public Pemain(String nama) {
        super();
        this.nama = nama;
        this.nilai = 100;
    }

    /**
     * Metode untuk mendapatkan nama pemain.
     *
     * @return Nama dari pemain.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Metode untuk mengubah nama pemain.
     *
     * @param nama Nama baru untuk pemain.
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * Metode untuk mengatur nilai pemain.
     *
     * @param nilai Nilai baru untuk pemain.
     */
    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}
