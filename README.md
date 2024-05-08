# 221401070_Hotbaen Eliezer Situmorang_UTS Lab 4 PBO
 UTS

Dalam Program, terdapat 4 kelas, yaitu Main, BankingSystem, User, dan Transaction.
Pada class User, di deklarasikan seluruh atribut, yaitu nama, alamat, nomor telepon, saldo dan tanggal deklarasi.
Pada class Transaction, digunakan untuk memproses transaksi pengiriman uang.
Pada class BankingSystem, terdapat berbagai method, yaitu :
 registerNewAccount() untuk mendaftarkan pengguna baru
 transferUang() untuk menu pengiriman uang dengan memasukkan nomor pengirim dan penerima
 depositUang() untuk menu menambahkan saldo dari user yang telah ada melalui nomor rekening
 checkAccountInfo() untuk mengecek informasi akun
 displayUserInfo() untuk menampilkan informasi akun setiap kali selesai melakukan transaksi
 getUserByAccountNumber() untuk mencari user melalui nomor rekening
 generateAccountNUmber() untuk mendaftarkan nomor rekening user secara acak (6 digit)

Lalu Pada class Main, terdapat pilihan menu menggunakan case, dan pada bagian registerNewAccount() akan di tampilkan nomor rekening yang didapatkan beserta dengan informasi akun
