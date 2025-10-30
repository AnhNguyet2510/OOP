package Project;

public class Tour {
    private String matour;
    private String tentour;
    private String diadiemkhoihanh;
    private String diadiemketthuc;
    private String ngaybatdau;
    private String ngayketthuc;
    private String giatour;

    public Tour(String matour, String tentour, String diadiemkhoihanh, String diadiemketthuc,
                String ngaybatdau, String ngayketthuc, String giatour) {
        this.matour = matour;
        this.tentour = tentour;
        this.diadiemkhoihanh = diadiemkhoihanh;
        this.diadiemketthuc = diadiemketthuc;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.giatour = giatour;
    }

    public String getMaTour() {
        return matour;
    }

    @Override
public String toString() {
    return "Ma tour: " + matour + "\n"
         + "Ten tour: " + tentour + "\n"
         + "Dia diem khoi hanh: " + diadiemkhoihanh + "\n"
         + "Dia diem ket thuc: " + diadiemketthuc + "\n"
         + "Ngay bat dau: " + ngaybatdau + "\n"
         + "Ngay ket thuc: " + ngayketthuc + "\n"
         + "Gia tour: " + giatour + "\n";
}
}