import java.util.Scanner;

class Mahasiswa {
    String nama;
    String nim;
    String jurusan;
    int usia;
    String universitas = "Universitas ABC";

    public Mahasiswa(String nama, String nim, String jurusan, int usia) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.usia = usia;
    }

    public void tampilDataMahasiswa() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("Usia: " + usia);
    }

    public static void tampilUniversitas() {
        System.out.println("Universitas: Universitas Muhammadiyah Malang");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan nama mahasiswa:");
        String nama = scanner.nextLine();

        System.out.println("Masukkan NIM mahasiswa (15 karakter):");
        String nim = scanner.nextLine();
        while (nim.length() > 15) {
            System.out.println("NIM terlalu panjang! Masukkan kembali:");
            nim = scanner.nextLine();
        }

        System.out.println("Masukkan jurusan mahasiswa:");
        String jurusan = scanner.nextLine();

        System.out.println("Masukkan usia mahasiswa:");
        int usia = scanner.nextInt();

        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, jurusan, usia);

        System.out.println("\nDetail Mahasiswa:");
        mahasiswa.tampilDataMahasiswa();

        System.out.println("\nInfo Universitas:");
        Mahasiswa.tampilUniversitas();
    }
}