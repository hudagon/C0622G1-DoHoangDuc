package ss10_dsa_list.demo;

public class XeChung extends ThietBiCoKhi {
    private String coMayBanh;

    public XeChung(String color, boolean chayDuocHayKhong, String coMayBanh) {
        super(color, chayDuocHayKhong);
        this.coMayBanh = coMayBanh;
    }

    @Override
    public String duocAiPhatMinh(String duocAiPhatMinh) {
        return "Karl Benz";
    }

    @Override
    public String phucVuNhanLoai(String phucVuNhanLoai) {
        return super.phucVuNhanLoai("Cho mọi người đi lại");
    }

    public String coMayDieuHoaLoaiGi (String loaiMayDieuHoa) {
        return loaiMayDieuHoa;
    }


}
