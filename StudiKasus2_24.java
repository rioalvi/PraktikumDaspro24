import java.util.Scanner;

public class StudiKasus2_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nama mahasiswa : ");
        String nama = sc.nextLine().trim();
        System.out.print("Jenis kegiatan (BELMAWA/BAKORMA/MANDIRI/PKM/LAINNYA): ");
        String jenisKegiatan = sc.nextLine().trim();
        System.out.print("Jumlah dokumen: ");
        int jumlahDokumen = sc.nextInt();

        boolean kelayakanJuara = false;
        String alasanGagal = "";

        if (jenisKegiatan.equalsIgnoreCase("BELMAWA") ||
            jenisKegiatan.equalsIgnoreCase("BAKORMA") ||
            jenisKegiatan.equalsIgnoreCase("MANDIRI")) {

                System.out.print("Peringkat juara (1-3, isi 0 jika belum juara): ");
                int peringkat = sc.nextInt();
                
                if (peringkat >= 1 && peringkat <= 3) {
                    kelayakanJuara = true;
                } else {
                    alasanGagal = "Tidak memperoleh dana penghargaan (hanya untuk Juara 1/2/3).";
                }

            } else if (jenisKegiatan.equalsIgnoreCase("PKM")) {
                System.out.print("Status pendanaan PKM (1 = lolos, 0 = tidak lolos): ");
                int statusPKM = sc.nextInt();

                if (statusPKM == 1) {
                    kelayakanJuara = true;
                } else {
                    alasanGagal = "Tidak memperoleh dana penghargaaan (PKM tidak lolos pendanaan).";
                }
                
            } else {
                alasanGagal = "Tidak memperoleh dana penghargaan (jenis kegiatan tidak termasuk ketentuan).";
            }

            if (kelayakanJuara) {
                if (jumlahDokumen >= 4) {
                    System.out.println("Status: Berhak memperoleh dana penghrgaan ");
                } else {
                    int kurang = 4 - jumlahDokumen;
                    System.out.println("Status: Dokumen tidak lengkap (kurang " + kurang + " dokumen). Dana penghargaan tidak diberikan. ");
                }
            } else {
                System.out.println("Status: " + alasanGagal);
            }
    }
}
