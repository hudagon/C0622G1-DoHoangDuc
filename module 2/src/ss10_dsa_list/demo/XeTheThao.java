package ss10_dsa_list.demo;

public class XeTheThao extends XeChung implements cacChucNangCuaXe {
    private boolean coDuocDungDeDuaKhong;
    private String name;

    public XeTheThao(String color, boolean chayDuocHayKhong, String coMayBanh) {
        super(color, chayDuocHayKhong, coMayBanh);
    }

    public XeTheThao(String color, boolean chayDuocHayKhong, String coMayBanh, boolean coDuocDungDeDuaKhong) {
        super(color, chayDuocHayKhong, coMayBanh);
        this.coDuocDungDeDuaKhong = coDuocDungDeDuaKhong;
    }

    public XeTheThao(String color, boolean chayDuocHayKhong, String coMayBanh, boolean coDuocDungDeDuaKhong, String name) {
        super(color, chayDuocHayKhong, coMayBanh);
        this.coDuocDungDeDuaKhong = coDuocDungDeDuaKhong;
        this.name = name;
    }

    @Override
    public String phucVuNhanLoai(String phucVuNhanLoai) {
        return super.phucVuNhanLoai("Cho mọi người chạy nhanh hơn");
    }

    @Override
    public boolean banSungDcKhong() {
        return true;
    }

    public String toString() {
        return "XeTheThao{name: " + name + ", màu: " + super.getColor() +
                ", Có được dùng để đua không: " + this.coDuocDungDeDuaKhong +
                ", Có bắn súng đc không: " + banSungDcKhong() + "}";
    }


}
