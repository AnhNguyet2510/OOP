package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachTour implements InterfaceDSTour {
    private List<Tour> danhSach = new ArrayList<>();

    public void docTuFile() {
        danhSach.clear();
        try (Scanner scanner = new Scanner(new File("C:\\hocc++\\Project\\QLTour.txt"));) {
            while (scanner.hasNextLine()) {
                String[] parts = new String[7];
                int count = 0;
                while (count < 7 && scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (!line.isEmpty()) {
                        parts[count++] = line;
                    }
                }
                if (count == 7) {
                    Tour tour = new Tour(
                        parts[0], parts[1], parts[2],
                        parts[3], parts[4], parts[5], parts[6]
                    );
                    danhSach.add(tour);
                }
            }
            System.out.println("Doc file thanh cong.");
        } catch (FileNotFoundException e) {
            System.err.println("Khong tim thay file: " + e.getMessage());
        }
    }

    public void hienThiTatCa() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach tour trong.");
            return;
        }
        System.out.println("=== DANH SACH TOUR ===");
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println((i + 1) + ". " + danhSach.get(i));
        }
    }

    public void themTour(Tour tour) {
        danhSach.add(tour);
        System.out.println("Da them tour thanh cong.");
    }

    public int timTheoMa(String maTour) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaTour().equalsIgnoreCase(maTour)) {
                return i;
            }
        }
        return -1;
    }

    public void suaTour(String maTour) {
        int index = timTheoMa(maTour);
        if (index == -1) {
            System.out.println("Khong tim thay tour.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma tour moi: ");
        String matour = sc.nextLine();
        System.out.print("Nhap ten tour moi: ");
        String tentour = sc.nextLine();
        System.out.print("Nhap dia diem khoi hanh moi: ");
        String diadiemkhoihanh = sc.nextLine();
        System.out.print("Nhap dia diem ket thuc moi: ");
        String diadiemketthuc = sc.nextLine();
        System.out.print("Nhap ngay bat dau moi: ");
        String ngaybatdau = sc.nextLine();
        System.out.print("Nhap ngay ket thuc moi: ");
        String ngayketthuc = sc.nextLine();
        System.out.print("Nhap gia tour moi: ");
        String giatour = sc.nextLine();
        Tour tourMoi = new Tour(matour, tentour, diadiemkhoihanh, diadiemketthuc, ngaybatdau, ngayketthuc, giatour);
        danhSach.set(index, tourMoi);
        System.out.println("Cap nhat tour thanh cong.");
        sc.close();
    }

    public void xoaTour(String maTour) {
        int index = timTheoMa(maTour);
        if (index == -1) {
            System.out.println("Khong tim thay tour.");
            return;
        }
        danhSach.remove(index);
        System.out.println("Da xoa tour co ma: " + maTour);
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("\n========= MENU QUAN LY TOUR =========");
            System.out.println("1. Hien thi cac tour dang co");
            System.out.println("2. Them tour moi");
            System.out.println("3. Sua tour");
            System.out.println("4. Xoa tour");
            System.out.println("5. Hien thi danh sach tour hien tai");
            System.out.println("6. Tim tour theo ma");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            while (!sc.hasNextInt()) {
                System.out.print("Vui long nhap so: ");
                sc.next();
            }
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1 -> {
                    docTuFile();
                    hienThiTatCa();
                }
                case 2 -> {
                    System.out.print("Nhap ma tour: "); String ma = sc.nextLine();
                    System.out.print("Nhap ten tour: "); String ten = sc.nextLine();
                    System.out.print("Nhap dia diem khoi hanh: "); String khoiHanh = sc.nextLine();
                    System.out.print("Nhap dia diem ket thuc: "); String ketThuc = sc.nextLine();
                    System.out.print("Nhap ngay bat dau: "); String ngayBD = sc.nextLine();
                    System.out.print("Nhap ngay ket thuc: "); String ngayKT = sc.nextLine();
                    System.out.print("Nhap gia tour: "); String gia = sc.nextLine();
                    Tour tour = new Tour(ma, ten, khoiHanh, ketThuc, ngayBD, ngayKT, gia);
                    themTour(tour);
                }
                case 3 -> {
                    System.out.print("Nhap ma tour can sua: ");
                    String ma = sc.nextLine();
                    suaTour(ma);
                }
                case 4 -> {
                    System.out.print("Nhap ma tour can xoa: ");
                    String ma = sc.nextLine();
                    xoaTour(ma);
                }
                case 5 -> hienThiTatCa();
                case 6 -> {
                    System.out.print("Nhap ma tour can tim: ");
                    String ma = sc.nextLine();
                    int index = timTheoMa(ma);
                    if (index != -1) {
                        System.out.println("Thong tin tour: " + danhSach.get(index));
                    } else {
                        System.out.println("Khong tim thay tour.");
                    }
                }
                case 0 -> System.out.println("Thoat chuong trinh.");
                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (chon != 0);
        sc.close();
    }
}