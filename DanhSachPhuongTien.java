package QuanLyDuLich;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class DanhSachPhuongTien {
    private PhuongTien[] dspt;
    private int n;
    Scanner sc = new Scanner (System.in);
    public DanhSachPhuongTien() {
        n = 0;
        dspt = new PhuongTien[0];
    }

    public void nhapDanhSachPhuongTien() {
        System.out.print("Nhap so phuong tien: ");
        n = sc.nextInt();
        sc.nextLine();
        dspt = new PhuongTien[n];
        for(int i = 0; i<n; i++) {
            System.out.print("\nNhap thong tin phuong tien thu"+(i+1)+": ");
            dspt[i] = new PhuongTien();
            dspt[i].nhapPhuongTien();
        }
    }

    public void inThongTinPhuongTien() {
        if(n == 0) {
            System.out.println("Danh sach phuong tien rong!");
            return;
        }
        System.out.printf("| %-5s | %-15s | %-20s | %-20s | %-15s | %-20s |\n", "STT", "Ma phuong tien", "Loai phuong tien","Ten phuong tien", "So cho","Gia phuong tien");
        for(int i = 0; i<n; i++) {
            System.out.printf( "| %-5d | %-15s | %-20s | %-20s | %-15d | %-20d |\n", (i+1)
            , dspt[i].getMaPT(), dspt[i].getLoaiPT(), dspt[i].getTenPT(), dspt[i].getSoCho(), dspt[i].getGiaPT());
        }
    }
    
    public boolean kiemtramaPhuongTien(String maPT) {
        for(int i = 0; i<n; i++) {
            if(dspt[i].getMaPT().equals(maPT)) {
                return true;
            }
        }
        return false;
    }

    public void themPhuongTien() {
        String maPT;
        do {
            System.out.print("Vui long nhap ma phuong tien de kiem tra: ");
            maPT = sc.nextLine().toUpperCase();
            if(kiemtramaPhuongTien(maPT)) {
                System.out.println("Ma phuong tien da ton tai. Vui long nhap ma khac!");
            }
        } while(kiemtramaPhuongTien(maPT));
        System.out.println("\n--- THEM PHUONG TIEN MOI ---");
        n = dspt.length;
        dspt = Arrays.copyOf(dspt, n+1);
        dspt[n] =  new PhuongTien();  
        dspt[n].nhapPhuongTien();
        n++;
        System.out.println("Da them phuong tien moi thanh cong!");
    }

    public void themPhuongTien(PhuongTien pt) {
        n = dspt.length;
        dspt = Arrays.copyOf(dspt, n+1);
        dspt[n] = pt;
        n++;
    }

    public void xoaPhuongTien(String maPT) {
        for(int i = 0; i<n; i++) {
            if(dspt[i].getMaPT().equalsIgnoreCase(maPT)) {
                for(int j = i; j< dspt.length - 1; j++) {
                    dspt[j] = dspt[j + 1];
                }
                dspt = Arrays.copyOf(dspt,n-1);
                n--;
                System.out.println("Da xoa phuong tien ma "+maPT+" thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay phuong tien ma "+maPT+" de xoa!");
    }
    public void xoaPhuongTien() {
        System.out.print("Nhap ma phuong tien can xoa: ");
        String maPT = sc.nextLine().toUpperCase();
        xoaPhuongTien(maPT);
    }    

    public void suaPhuongTien(String maPT) {
        for(int i =0; i<n; i++) {
            if(dspt[i].getMaPT().equals(maPT)) {
                System.out.print("=== SUA THONG TIN PHUONG TIEN MA " + maPT + " ===");
                dspt[i].nhapPhuongTien();
                System.out.println("Da sua thong tin phuong tien ma "+maPT+" thanh cong");
                return;
            }
        }
        System.out.println("Khong tim thay phuong tien ma "+maPT+" de sua!");
    }
    public void suaPhuongTien() {
        System.out.print("Nhap ma phuong tien can sua: ");
        String maPT = sc.nextLine().toUpperCase();
        suaPhuongTien(maPT);
    }

    public PhuongTien timkiemPhuongTien(String maPT) {
        for(int i =0; i<n; i++) {
            if(dspt[i].getMaPT().equals(maPT)) {
                dspt[i].inPhuongTien();
                System.out.println("Da tim thay phuong tien ma "+maPT+" !");
                return dspt[i];
            }
        }
        return null;
    }
    public void timkiemPhuongTien() {
        System.out.print("Nhap ma phuong tien can tim: ");
        String maPT = sc.nextLine().toUpperCase();
        PhuongTien pt = timkiemPhuongTien(maPT);
        if(pt == null) {
            System.out.println("Khong tim thay phuong tien ma "+maPT+" !");
        }
    }

    public void xuatFileDanhSachPhuongTien() {
        try ( PrintWriter pw = new PrintWriter(new FileWriter("DanhSachPhuongTien.txt")) ) {
            pw.println("+---------------------------------------------------------------------------------------------------+");
            pw.printf("| %-15s | %-20s | %-20s | %-15s | %-15s |\n",
                 "Ma phuong tien", "Loai phuong tien","Ten phuong tien", "So cho","Gia phuong tien");
            pw.println("+---------------------------------------------------------------------------------------------------+");
            for(int i =0; i<n; i++) {
                pw.printf("| %-15s | %-20s | %-20s | %-15d | %-15d |\n",
                dspt[i].getMaPT(), dspt[i].getLoaiPT(), dspt[i].getTenPT(), dspt[i].getSoCho(), dspt[i].getGiaPT());
            }
            pw.println("+---------------------------------------------------------------------------------------------------+");
            System.out.println("Da xuat file danh sach phuong tien thanh cong!");
        }
        catch (IOException e) {
            System.out.println("Loi khi xuat file: " + e.getMessage());
        }
    }
}

