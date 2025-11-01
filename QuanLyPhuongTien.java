package QuanLyDuLich;
import java.util.Scanner;
public class QuanLyPhuongTien {
    private void Menu() {
        Scanner sc = new Scanner(System.in);
        DanhSachPhuongTien dspt = new DanhSachPhuongTien();
        while(true) {
            System.out.println("\n----- QUAN LY PHUONG TIEN -----");
            System.out.println("1. Nhap danh sach phuong tien");
            System.out.println("2. In thong tin phuong tien");
            System.out.println("3. Them phuong tien");
            System.out.println("4. Sua phuong tien");
            System.out.println("5. Xoa phuong tien");
            System.out.println("6. Tim kiem phuong tien");
            System.out.println("7. Xuat file danh sach phuong tien");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");        

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Lua chon khong hop le. Vui long thu lai!");
                sc.nextLine();
                continue;
            }
            if(choice == 0) break;
            switch ((choice)) {
                case 1: dspt.nhapDanhSachPhuongTien(); break;
                case 2: dspt.inThongTinPhuongTien(); break;
                case 3: dspt.themPhuongTien(); break;
                case 4: dspt.suaPhuongTien(); break;
                case 5: dspt.xoaPhuongTien(); break;
                case 6: dspt.timkiemPhuongTien(); break;
                case 7: dspt.xuatFileDanhSachPhuongTien(); break;
                default: System.out.println("Lua chon khong hop le. Vui long thu lai!"); break;
            }
        } 
        sc.close();  
    }
}