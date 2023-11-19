import java.util.ArrayList;
import java.util.Collections;

/**
 * Kelas KotakPermainan adalah representasi dari sebuah permainan dengan papan
 * permainan dan papan monster.
 * Papan permainan memiliki kotak-kotak yang dapat berisi koin, sementara papan
 * monster memiliki kotak-kotak
 * yang dapat berisi monster.
 */
class KotakPermainan {
    private Kotak<Koin>[] boardGame;
    private Kotak<Monster>[] monsterBoard;
    private int jumKotak;
    private int jumlahKoin;
    private int jumlahMonster;
    private int tingkatKesulitan;
    private ArrayList<Integer> acakKoin;
    private ArrayList<Integer> acakMonster;

    /**
     * Konstruktor untuk objek KotakPermainan.
     *
     * @param j                Jumlah kotak dalam permainan.
     * @param jk               Jumlah koin yang akan ditempatkan dalam kotak
     *                         permainan.
     * @param jm               Jumlah monster yang akan ditempatkan dalam kotak
     *                         permainan.
     * @param tingkatKesulitan Tingkat kesulitan permainan (1, 2, atau 3).
     */
    public KotakPermainan(int j, int jk, int jm, int tingkatKesulitan) {
        this.jumKotak = j;
        this.jumlahKoin = jk;
        this.jumlahMonster = jm;
        this.boardGame = new Kotak[jumKotak];
        this.monsterBoard = new Kotak[jumKotak];
        this.acakKoin = new ArrayList<>();
        this.acakMonster = new ArrayList<>();
        this.tingkatKesulitan = tingkatKesulitan;
        generateAcak();
        inisialisasiKotak();
    }

    /**
     * Metode untuk menghasilkan urutan acak indeks kotak.
     */
    private void generateAcak() {
        for (int i = 0; i < jumKotak; i++) {
            acakKoin.add(i);
            acakMonster.add(i);
        }

        Collections.shuffle(acakKoin);
        Collections.shuffle(acakMonster);
    }

    /**
     * Metode untuk menginisialisasi kotak-kotak dalam permainan dengan koin dan
     * monster.
     */
    private void inisialisasiKotak() {
        for (int i = 0; i < jumKotak; i++) {
            boardGame[i] = new Kotak<>();
            monsterBoard[i] = new Kotak<>();
        }

        for (int i = 0; i < jumlahKoin; i++) {
            boardGame[acakKoin.get(i)].addIsi(new Koin());
        }

        for (int i = 0; i < jumlahMonster; i++) {
            monsterBoard[acakMonster.get(i)].addIsi(new Monster());
        }
    }

    /**
     * Metode untuk memeriksa konten kotak pada posisi tertentu dalam permainan.
     *
     * @param posisi Posisi kotak yang akan diperiksa.
     * @return Skor yang diberikan berdasarkan konten kotak (20 poin untuk koin,
     *         pengurangan poin untuk monster).
     */
    public int contain(int posisi) {
        if (posisi < jumKotak) {
            int skor = 0;
            Kotak<Koin> kotakKoin = boardGame[posisi];
            Kotak<Monster> kotakMonster = monsterBoard[posisi];

            if (kotakKoin.isThereIsi()) {
                skor += 20; // Menambah 20 poin jika bertemu koin
            }

            if (kotakMonster.isThereIsi()) {
                int poinKurang = tingkatKesulitan == 1 ? 10 : (tingkatKesulitan == 2 ? 20 : 30);
                skor -= poinKurang; // Mengurangkan poin sesuai tingkat kesulitan
            }

            return skor;
        }
        return 0;
    }
}
