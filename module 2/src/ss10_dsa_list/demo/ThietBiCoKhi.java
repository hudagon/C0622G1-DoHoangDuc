package ss10_dsa_list.demo;

public abstract class ThietBiCoKhi {
    private String color;
    private boolean chayDuocHayKhong;

    public ThietBiCoKhi(String color, boolean chayDuocHayKhong) {
        this.color = color;
        this.chayDuocHayKhong = chayDuocHayKhong;
    }

    public String phucVuNhanLoai(String phucVuNhanLoai) {
        return "Tôi sinh ra mục đích để phục vụ nhân loại: " + phucVuNhanLoai;
    }

    public abstract String duocAiPhatMinh(String duocAiPhatMinh);

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isChayDuocHayKhong() {
        return chayDuocHayKhong;
    }

    public void setChayDuocHayKhong(boolean chayDuocHayKhong) {
        this.chayDuocHayKhong = chayDuocHayKhong;
    }
}
