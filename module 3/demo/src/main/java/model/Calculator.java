package model;

public class Calculator {
    private float soThuNhat;
    private float soThuHai;
    private int toanTu;

    public Calculator() {
    }

    public Calculator(float soThuNhat, float soThuHai, int toanTu) {
        this.soThuNhat = soThuNhat;
        this.soThuHai = soThuHai;
        this.toanTu = toanTu;
    }

    public float tinhToan(float soThuNhat, float soThuHai, int toanTu) {
        float ketQua = 0;
        switch (toanTu) {
            case 1:
                ketQua = soThuNhat + soThuHai;
                break;
            case 2:
                ketQua = soThuNhat - soThuHai;
                break;
            case 3:
                ketQua = soThuNhat * soThuHai;
                break;
            case 4:
                ketQua = soThuNhat / soThuHai;
        }
        return ketQua;
    }


    public float getSoThuNhat() {
        return soThuNhat;
    }

    public void setSoThuNhat(float soThuNhat) {
        this.soThuNhat = soThuNhat;
    }

    public float getSoThuHai() {
        return soThuHai;
    }

    public void setSoThuHai(float soThuHai) {
        this.soThuHai = soThuHai;
    }

    public int getToanTu() {
        return toanTu;
    }

    public void setToanTu(int toanTu) {
        this.toanTu = toanTu;
    }
}
