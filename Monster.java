/**
 * Kelas Monster adalah kelas untuk merepresentasikan monster dalam permainan.
 * Monster adalah jenis Makhluk yang memiliki nilai dan nama.
 */
public class Monster extends Makhluk {
    private String nama;

    /**
     * Konstruktor default untuk objek Monster. Nilai dan nama diatur ke nilai
     * default.
     */
    public Monster() {
        super();
        this.nama = "";
    }

    /**
     * Konstruktor untuk objek Monster dengan nilai dan nama tertentu.
     *
     * @param nilai Nilai untuk monster.
     * @param nama  Nama untuk monster.
     */
    public Monster(int nilai, String nama) {
        this.nilai = nilai;
        this.nama = nama;
    }

    /**
     * Metode untuk mendapatkan nama monster.
     *
     * @return Nama dari monster.
     */
    public String getNama() {
        return nama;
    }
}
