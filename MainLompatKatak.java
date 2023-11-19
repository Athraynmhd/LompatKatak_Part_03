import java.util.Scanner;

/**
 * Kelas MainLompatKatak adalah kelas utama untuk permainan Lompat Katak.
 * Permainan ini memungkinkan pemain untuk menggerakkan katak melalui
 * kotak-kotak
 * dan mengumpulkan poin dengan menemukan koin dan menghindari monster.
 */
public class MainLompatKatak {
    private boolean play;
    private Scanner s;
    private Katak katak;
    private Pemain pemain;
    private KotakPermainan kotakPermainan;
    private int tingkatKesulitan;

    /**
     * Konstruktor untuk objek MainLompatKatak.
     * Melakukan inisialisasi permainan, seperti nama pemain, tingkat kesulitan, dan
     * papan permainan.
     */
    public MainLompatKatak() {
        play = true;
        s = new Scanner(System.in);
        katak = new Katak();
        System.out.println("      *********************************************");
        System.out.println("      *  Selamat datang di permainan Lompat Katak!*");
        System.out.println("      *********************************************");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣲⣒⠒⠍⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡭⠍⣒⣒⣢⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡿⠛⢻⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠟⠛⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣷⣴⣡⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣦⣎⣼⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢺⠙⢿⣿⣿⣻⠞⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠻⣿⣿⣿⣷⠟⡷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡼⠓⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠳⠀⠘⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠘⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡦⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠜⢳⡺⠵⣶⣒⠢⠤⠤⠤⠤⠤⠤⣤⣤⡤⠤⡒⡦⠤⠤⣤⣶⣶⣾⣿   ⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⢀⠔⠁⢰⠃⢧⠀⠀⠈⠉⠛⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⣉⡭⠛⠉⠁⠀⠀⡇⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⢠⠏⠀⢠⠇⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⢸⠀⠈⢧⠀⠀⢸⡀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⣠⡴⠒⠉⠉⠉⢉⡶⠚⠀⢀⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠑⢦⡈⡧⢤⣀⡀⠀⠀⠀⠀");
        System.out.println("⢀⡾⠁⠀⠀⢀⡴⠊⠁⠀⠀⢠⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡇⠀⠀⠀⠀⠙⢧⠀⠀⠉⠑⠦⡀⠀");
        System.out.println("⢸⠀⠀⠀⢰⠋⠀⠀⠀⠰⣄⢻⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⢀⡠⠊⠀⠀⡜⠀⠀⠀⠀⠀⠙⡄");
        System.out.println("⠘⡆⠀⠀⢸⡀⠀⠀⠀⠀⠈⠻⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡷⠋⠀⠀⠀⢰⠁⠀⠀⠀⠀⠀⠀⢸");
        System.out.println("⠀⠘⢦⡀⠈⢣⠀⠀⠀⠀⠀⠀⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠏⠀⠀⠀⠀⢠⠇⠀⠀⠀⠀⠀⠀⠀⣼");
        System.out.println("⠀⠀⠀⠉⠒⠤⢳⡀⠀⠀⠀⠀⢽⡈⠣⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡶⠁⠀⠀⠀⠀⢠⠟⠦⣄⣀⣀⣀⣀⣠⠔⠁");
        System.out.println("⠀⠀⠀⣀⡤⠤⠴⣷⠀⠀⠀⠀⠀⣇⠀⠈⠑⠢⠤⣄⣀⣀⡀⠀⠀⢀⣀⣀⠤⠔⠚⢉⡜⠁⠀⠀⠀⠀⢠⡯⠞⡗⠡⠤⢼⢄⣩⠼⠀⠀⠀");
        System.out.println("⠀⠀⠀⢷⣷⣀⣴⣋⣧⠀⠀⠀⠀⠸⣲⡤⠤⣄⠀⠀⠀⠀⠀⠈⠀⣀⣀⠀⢀⣀⣠⠮⠄⠀⠀⠀⠀⢠⡯⠞⡗⠡⠤⢼⢄⣩⠼⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠉⠁⠘⠲⠼⢦⡀⠀⠀⠀⠀⠀⣄⠀⢉⠍⠱⠖⢲⠖⠙⢄⣀⡽⠟⠒⠒⠀⠀⠀⠀⠀⢰⠏⠀⠀⠛⠒⠒⠋⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⠃⠤⢴⡆⢀⠀⠙⡧⠴⠊⠀⠀⠳⠤⠼⣇⠐⠲⡤⠤⠤⠤⠤⢤⡤⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⠒⠚⠈⠓⠒⠛⠁⠀⠀⠀⠀⠀⠀⠀⠉⠓⠊⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");

        System.out.println("      *********************************************");
        System.out.println("      *            Masukkan Nama Pemain!          *");
        System.out.println("      *********************************************");
        String playerName = s.nextLine();
        pemain = new Pemain(playerName);
        pilihTingkatKesulitan();
        kotakPermainan = new KotakPermainan(300, 60, 30, tingkatKesulitan);
    }

    private void pilihTingkatKesulitan() {
        System.out.println("Pilih tingkat kesulitan:");
        System.out.println("1. Mudah");
        System.out.println("2. Sedang");
        System.out.println("3. Sulit");
        System.out.print("Masukkan pilihan tingkat kesulitan: ");
        tingkatKesulitan = s.nextInt();
    }

    public void mainkan() {
        while (play) {
            System.out.println("Posisi [ 🐸 ] di kotak : [" + katak.getPosisi() + "]");
            System.out.println("Poin [ 🌟 ] " + pemain.getNama() + " saat ini: " + pemain.getNilai());

            if (katak.getPosisi() == 298) {
                System.out.println("1 lompatan maju terakhir");
            }

            System.out.println("+-------------------------+");
            System.out.println("|  Tentukan langkah anda  |");
            System.out.println("+-------------------------+");
            System.out.println("== MAJU ==");
            ;

            if (katak.getPosisi() <= 297) {
                System.out.println("1. Maju 1 langkah");
                System.out.println("2. Maju 2 langkah");
            } else {
                System.out.println("Anda Hanya Memiliki satu opsi\n");
                System.out.println("1. Maju 1 langkah");
            }

            System.out.println("\n== MUNDUR ==");
            System.out.println("3. Mundur 1 langkah");
            System.out.println("4. Mundur 2 langkah");

            System.out.print("Masukkan pilihan : ");
            int pilihan = s.nextInt();

            if (pilihan == 1) {
                if (katak.getPosisi() < 299) {
                    katak.loncatDekat();
                } else {
                    System.out.println("Anda Hanya Memiliki satu opsi\n");
                    System.out.println("1. Maju 1 langkah");
                }
            } else if (pilihan == 2) {
                if (katak.getPosisi() < 298) {
                    katak.loncatJauh();
                }
            } else if (pilihan == 3) {
                if (katak.getPosisi() > 0) {
                    katak.setPosisi(katak.getPosisi() - 1);
                }
            } else if (pilihan == 4) {
                if (katak.getPosisi() > 1) {
                    katak.setPosisi(katak.getPosisi() - 2);
                }
            }

            if (katak.getPosisi() < 0) {
                katak.setPosisi(0);
            }

            int skorChange = kotakPermainan.contain(katak.getPosisi());

            if (skorChange > 0) {
                System.out.println("Anda menemukan koin [ 🌟 ] , poin bertambah 20");
            } else if (skorChange < 0) {
                System.out.println("Anda bertemu monster [ 🐲 ], poin berkurang 10");
            }

            pemain.setNilai(pemain.getNilai() + skorChange);

            if (pemain.getNilai() <= 0) {
                System.out.println("Game Over. Skor " + pemain.getNama() + " habis.");
                play = false;
            } else if (katak.getPosisi() >= 299) {
                System.out.println("Selamat, " + pemain.getNama() + " menang!");
                play = false;
                evaluasiPoin(pemain.getNilai());
            }
        }
    }

    /**
     * Metode untuk mengevaluasi poin pemain setelah permainan selesai.
     *
     * @param totalPoin Total poin yang telah dikumpulkan oleh pemain.
     */
    public void evaluasiPoin(int totalPoin) {
        if (totalPoin > 1000) {
            System.out.println("Poin " + pemain.getNama() + " sangat bagus!");
        } else if (totalPoin >= 500 && totalPoin <= 1000) {
            System.out.println("Poin " + pemain.getNama() + " bagus!");
        } else {
            System.out.println("Poin " + pemain.getNama() + " buruk!");
        }
    }

    /**
     * Metode utama untuk memulai permainan Lompat Katak.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam permainan ini).
     */
    public static void main(String[] args) {
        MainLompatKatak game = new MainLompatKatak();
        game.mainkan();
    }
}
