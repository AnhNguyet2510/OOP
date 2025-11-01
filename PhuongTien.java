package QuanLyDuLich;
import java.util.Scanner;

public class PhuongTien {
    private String maPT;
    private String loaiPT;
    private String tenPT;
    private int socho;
    private int giaPT;
    
    Scanner sc = new Scanner(System.in);
    
    public PhuongTien(){}
    public PhuongTien(String maPT, String loaiPT, String tenPT, int socho, int giaPT) {
            this.maPT = maPT;
            this.tenPT = tenPT;
            this.loaiPT = loaiPT;
            this.socho = socho;
            this.giaPT = giaPT;
    }

    public String getMaPT() {return maPT;}
    public String getLoaiPT() {return loaiPT;}
    public String getTenPT() {return tenPT;}
    public int getSoCho() {return socho;}
    public int getGiaPT() {return giaPT;}

    public void setMaPT(String maPT) {this.maPT = maPT;}
    public void setLoaiPT(String loaiPT) {this.loaiPT = loaiPT;}
    public void setTenPT(String tenPT) {this.tenPT=tenPT;}
    public void setSoCho(int socho) {this.socho = socho;}
    public void setGiaPT(int giaPT) {this.giaPT = giaPT;}

    public void nhapPhuongTien() {
        int choice;
        System.out.println("\nChon loai phuong tien: ");
        do {          
            System.out.println("1. Xe khach");
            System.out.println("2. May bay");
            System.out.println("3. Tau thuyen");
            System.out.print("Nhap lua chon (1-3): ");
            choice = sc.nextInt();
            if(choice < 1 || choice > 3)
                System.out.println("Khong hop le. vui long chon lai.");
            } while (choice < 1 || choice > 3);
            sc.nextLine();
        switch (choice) {
            case 1: loaiPT = "Xe khach"; break;
            case 2: loaiPT = "May bay"; break;
            case 3: loaiPT = "Tau thuyen"; break;
        }
        System.out.print("Nhap ma phuong tien: ");       
        maPT = sc.nextLine();
        System.out.print("Nhap ten phuong tien: ");
        tenPT = sc.nextLine();
        System.out.print("Nhap so cho: ");
        socho = sc.nextInt();
        System.out.print("Nhap gia phuong tien: ");
        giaPT = sc.nextInt();
    }
    
    public void inPhuongTien() {
        System.out.printf("| %15s | %15s | %15s | %15d | %15d |\n", maPT, loaiPT, tenPT, socho, giaPT);
    }
    public static void inTieuDe() {
        String line ="+-----------------+-----------------+-----------------+-----------------+-----------------+";
        System.out.println(line);
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n","Ma phuong tien", "Loai phuong tien", "Ten phuong tien", "So cho", "Gia phuong tien");
        System.out.println(line);
    }
}