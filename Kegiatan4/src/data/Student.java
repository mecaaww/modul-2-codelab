package data;

import java.util.*;
import util.iMenu;

public class Student extends User implements iMenu{

    public String name, faculty, nim, programStudi;
    public static Object[] borrowedBooks = new Object[100];
    public static int borrowedBooksCount = 0;

    public static boolean isStudent;

    public Student (String name, String faculty, String nim, String programStudi) {
        this.name = name;
        this.faculty = faculty;
        this.nim = nim;
        this.programStudi = programStudi;
    }

    public Student () {

    }

    User user = new User();

    public static void displayInfo(String name) {
        System.out.println("Successfully login as " + name);
    }

    public static void showBorrowedBooks() {
        System.out.println("=============================================================================================================");
        System.out.printf("|| %-3s ||   %-17s||            %-20s ||  %-10s ||  %-10s || %-8s  ||%n", "No", "Book ID", "Title", "Author", "Category", "Duration");
        System.out.println("=============================================================================================================");
        int no = 1;
        for (int i = 0; i < Admin.bookCount; i++) {
            for (int j = 0; j < borrowedBooksCount; j++) {
                if(borrowedBooks[j] != null && User.bookList[i].getBookId().equals(borrowedBooks[j])) {
                    System.out.printf("|| %-3d ||  %-17s ||  %-30s ||  %-10s ||  %-10s ||  %-8d ||%n", no, User.bookList[i].getBookId(), User.bookList[i].getTitle(), User.bookList[i].getAuthor(), User.bookList[i].getCategory(), User.bookList[i].getDuration());
                    no++;
                }
            }
        }
        System.out.println("=============================================================================================================");
    }

    static Student student = new Student();

    public static void logout() {
        Scanner input = new Scanner(System.in);
        if(borrowedBooksCount == 0) {
            isStudent = false;
            return;
        }else {
            showBorrowedBooks();
            System.out.println("Apakah kamu yakin untuk meminjam semua buku tersebut?");
            System.out.println("Input Y (iya) atau T (tidak): ");
            String option = input.next();
            input.nextLine();
            if(option.equals("T") || option.equals("t")) {
                return;
            }else if(option.equals("Y") || option.equals("y")) {
                System.out.println("Peminjaman buku berhasil dilakukan.");
                System.out.println("Terima kasih...");
                isStudent = false;
                return;
            }
        }
    }

    public static void returnBooks() {
        Scanner input = new Scanner(System.in);
        showBorrowedBooks();
        System.out.print("Input ID Buku yang ingin dihapus (Input 99 untuk back): ");
        String inputID = input.next();
        input.nextLine();
        if (inputID.equals("99")) {
            return;
        } else {
            boolean bookFound = false;
            for (int i = 0; i < borrowedBooksCount; i++) {
                if (borrowedBooks[i].equals(inputID)) {
                    for (int j = 0; j < Admin.bookCount; j++) {
                        if (User.bookList[j].getBookId().equals(inputID)) {
                            int stockNow = User.bookList[j].getStock();
                            User.bookList[j].setStock(stockNow + 1);
                            System.out.println("Successfully to return the book with title '" + User.bookList[j].getTitle() + "'");
                            for (int k = i; k < borrowedBooksCount - 1; k++) {
                                borrowedBooks[k] = borrowedBooks[k + 1];
                            }
                            borrowedBooksCount--;
                            bookFound = true;
                            break;
                        }
                    }
                    if (!bookFound) {
                        System.out.println("Book with ID '" + inputID + "' is not found in the available books.");
                    }
                    break;
                }
            }
            if (!bookFound) {
                System.out.println("Borrowed book with ID '" + inputID + "' is not found.");
            }
        }
    }

    public void choiceBook() {
        Scanner input = new Scanner(System.in);
        int loop = 1;
        while(loop == 1) {
            user.displayBook();
            System.out.println("Input Id buku yang ingin dipinjam (input 99 untuk back)");
            System.out.print("Input: ");
            String inputID = input.nextLine();
            if(inputID.equals("99")) {
                loop = 0;
                System.out.println("Kembali ke menu awal...");
            }
            for (int i = 0; i < Admin.bookCount; i++) {
                if (User.bookList[i].getBookId().equals(inputID)) {
                    if (User.bookList[i].getStock() == 0) {
                        System.out.println("Stock buku kosong!");
                        System.out.println("Silahkan pilih yang lain.");
                    } else {
                        System.out.println("Berapa lama buku akan dipinjam? (maksimal 14 hari)");
                        System.out.print("Input lama (hari): ");
                        int duration = input.nextInt();
                        input.nextLine();
                        User.bookList[i].setDuration(duration);
                        Student.borrowedBooks[Student.borrowedBooksCount] = User.bookList[i].getBookId();
                        Student.borrowedBooksCount++;
                        int stockNow = User.bookList[i].getStock();
                        User.bookList[i].setStock(stockNow-1);
                    }
                }
            }
        }
    }

    @Override
    public void menu() {
        Scanner input = new Scanner(System.in);

        while (Student.isStudent) {
            System.out.println("=== Student Menu ===");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Kembalikan buku");
            System.out.println("4. Pinjam buku atau Logout");
            System.out.print("Choose option (1-4): ");
            int option;
            try {
                option = input.nextInt();

                input.nextLine();
                switch (option) {
                    case 1:
                        if(Student.borrowedBooksCount == 0) {
                            System.out.println("Belum ada buku yang dipilih");
                            System.out.println("Silahkan pilih buku terlebih dahulu");
                        }else {
                            Student.showBorrowedBooks();
                        }
                        break;
                    case 2:
                        choiceBook();
                        break;
                    case 3:
                        if(Student.borrowedBooksCount == 0) {
                            System.out.println("Belum ada buku yang dipilih");
                            System.out.println("Silahkan pilih buku terlebih dahulu");
                        }else {
                            Student.returnBooks();
                        }
                        break;
                    case 4:
                        Student.logout();
                        break;
                    default:
                        System.out.println("Invalid options.");
                        break;
                }
            }catch (java.util.InputMismatchException e) {
                System.out.println("Invalid options.");
            }

        }
    }
}
