import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class codelab {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

// Memasukkan Data Nama

        System.out.print("Nama : ");
        String nama = input.nextLine();

// Memasukkan Jenis Kelamin

        System.out.print("Jenis Kelamin (P/L): ");
        String jenisKelamin = input.nextLine();

// Memasukkan Data Tanggal Lahir

        System.out.print("Tanggal Lahir (tahun-bulan-tanggal): ");
        String tanggalLahir = input.nextLine();

// Perhitungan Umur

        LocalDate tglLahir = LocalDate.parse(tanggalLahir);
        LocalDate sekarang = LocalDate.now();

// Output dan Hasil Perhitungan Umur

        System.out.println("\nNama : "+ nama);
        System.out.print("Jenis Kelamin: ");
        if(jenisKelamin.equalsIgnoreCase("P")){
            System.out.println("Perempuan");
        }else{
            System.out.println("Laki-Laki");
        }

        Period umur = Period.between(tglLahir,sekarang);
        System.out.println("Umur anda : "+ umur.getYears() +" Tahun "+ umur.getMonths()+ " Bulan");

    }
}