import java.util.ArrayList;
import java.util.Scanner;

public class codelab5 {
    public static void main(String[] args) {
        ArrayList<String> namaMahasiswa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int i = 1;

        while(true){
            System.out.printf("Masukkan nama ke-%d: ", i);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("selesai")){
                break;
            }

            try{
                if(input.isEmpty()){
                    throw new IllegalArgumentException("Nama Tidak Boleh Kosong!");
                }else{
                    namaMahasiswa.add(input);
                    i++;
                }
            }catch (IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Daftar Mahasiswa Yang Diinputkan: ");
        for (String nama : namaMahasiswa){
            System.out.println("- " + nama);
        }
    }
}