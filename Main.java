import java.util.Scanner;

public class Main {
    private static BankingSystem bankingSystem = new BankingSystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Registrasi Akun Baru");
            System.out.println("2. Mengirim Uang");
            System.out.println("3. Menyimpan Uang");
            System.out.println("4. Mengecek Informasi Rekening Pribadi");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bankingSystem.registerNewAccount();
                    break;
                case 2:
                    bankingSystem.transferUang();
                    break;
                case 3:
                    bankingSystem.depositUang();
                    break;
                case 4:
                    bankingSystem.checkAccountInfo();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 5);
    }

    static void registerNewAccount() {
        BankingSystem bankingSystem = new BankingSystem();
        User user = bankingSystem.registerNewAccount();
        if (user != null) {
            System.out.println("\nRegistrasi berhasil!");
            System.out.println("Nomor Akun: " + user.nomorakun);
            displayUserInfo(user);
        } else {
            System.out.println("Gagal melakukan registrasi.");
        }
    }
    

    static void displayUserInfo(User user) {
        System.out.println("Nama: " + user.nama);
        System.out.println("Alamat: " + user.alamat);
        System.out.println("Nomor Telepon: " + user.nomortelepon);
        System.out.println("Saldo: " + user.saldo);
        System.out.println("Tanggal Registrasi: " + user.tanggalregistrasi);
        System.out.println("Nomor Akun: " + user.nomorakun);
    }
}
