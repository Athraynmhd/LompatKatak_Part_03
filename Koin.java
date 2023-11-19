/**
 * Kelas Koin merepresentasikan sebuah koin dengan nilai tertentu.
 */
public class Koin {
    private int nilai;

    /**
     * Konstruktor default untuk objek Koin. Koin awalnya memiliki nilai 0.
     */
    public Koin() {
        this.nilai = 0;
    }

    /**
     * Konstruktor untuk objek Koin dengan nilai awal tertentu.
     * 
     * @param nilai Nilai awal dari koin yang akan dibuat.
     */
    public Koin(int nilai) {
        this.nilai = nilai;
    }

    /**
     * Metode untuk mendapatkan nilai dari koin.
     * 
     * @return Nilai dari koin.
     */
    public int getNilai() {
        return nilai;
    }

    /**
     * Metode untuk mengatur nilai koin.
     * 
     * @param nilai Nilai baru yang akan diatur untuk koin.
     */
    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}
