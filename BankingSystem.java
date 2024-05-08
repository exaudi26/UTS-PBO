import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BankingSystem {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public User registerNewAccount() {
        System.out.println("\n=== Registrasi Akun Baru ===");
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan nomor telepon: ");
        String nomortelepon = scanner.nextLine();
        System.out.print("Masukkan saldo awal: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String tanggalregistrasi = now.format(formatter);

        String nomorakun = generateAccountNumber();

        User newUser = new User(nama, alamat, nomortelepon, saldo, tanggalregistrasi, nomorakun);
        users.add(newUser);

        System.out.println("\nRegistrasi berhasil!");
        System.out.println("Nomor Akun: " + nomorakun);
        displayUserInfo(newUser);
        return(newUser);
    
    }

    public void transferUang() {
        System.out.println("\n=== Mengirim Uang ===");
        System.out.print("Masukkan nomor akun pengirim: ");
        String senderAccountNumber = scanner.nextLine();
        System.out.print("Masukkan nomor akun penerima: ");
        String receiverAccountNumber = scanner.nextLine();
        System.out.print("Masukkan jumlah nominal: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
    
        User sender = getUserByAccountNumber(senderAccountNumber);
        User receiver = getUserByAccountNumber(receiverAccountNumber);
    
        if (sender != null && receiver != null) {
            if (sender.saldo >= amount) {
                sender.saldo -= amount;
                receiver.saldo += amount;
    
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String transactionDate = now.format(formatter);
    
                Transaction transaction = new Transaction(senderAccountNumber, receiverAccountNumber, amount, transactionDate);
                transactions.add(transaction);
    
                System.out.println("\nTransaksi berhasil!");
                System.out.println("Pengirim: ");
                displayUserInfo(sender);
                System.out.println("Penerima: ");
                displayUserInfo(receiver);
                System.out.println("Nominal: " + amount);
                System.out.println("Waktu Transaksi: " + transactionDate);
            } else {
                System.out.println("Saldo tidak mencukupi untuk melakukan transaksi.");
            }
        } else {
            System.out.println("Nomor akun pengirim atau penerima tidak valid.");
        }
    }
    

    public void depositUang() {
        System.out.println("\n=== Menyimpan Uang ===");
        System.out.print("Masukkan nomor rekening: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Masukkan jumlah nominal: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        User user = getUserByAccountNumber(accountNumber);
        if (user != null) {
            user.saldo += amount;
            System.out.println("\nPenyimpanan uang berhasil!");
            displayUserInfo(user);
        } else {
            System.out.println("Nomor rekening tidak ditemukan!");
        }
    }

    public void checkAccountInfo() {
        System.out.println("\n=== Mengecek Informasi Rekening Pribadi ===");
        System.out.print("Masukkan nomor rekening: ");
        String accountNumber = scanner.nextLine();

        User user = getUserByAccountNumber(accountNumber);
        if (user != null) {
            displayUserInfo(user);
        } else {
            System.out.println("Nomor rekening tidak ditemukan!");
        }
    }

    private void displayUserInfo(User user) {
        System.out.println("Nama: " + user.nama);
        System.out.println("Alamat: " + user.alamat);
        System.out.println("Nomor Telepon: " + user.nomortelepon);
        System.out.println("Saldo: " + user.saldo);
        System.out.println("Tanggal Registrasi: " + user.tanggalregistrasi);
        System.out.println("Nomor Akun: " + user.nomorakun);
    }

    private User getUserByAccountNumber(String accountNumber) {
        for (User user : users) {
            if (user.nomorakun.equals(accountNumber)) {
                return user;
            }
        }
        return null; // Not found
    }

    private String generateAccountNumber() {
        return String.format("%06d", random.nextInt(1000000));
    }
}
