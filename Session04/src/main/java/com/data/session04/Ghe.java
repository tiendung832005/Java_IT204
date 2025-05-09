package com.data.session04;

public class Ghe {
    private String maGhe;
    private String tenGhe;
    private int gia;
    private boolean daDat;

    public Ghe(String maGhe, String tenGhe, int gia, boolean daDat) {
        this.maGhe = maGhe;
        this.tenGhe = tenGhe;
        this.gia = gia;
        this.daDat = daDat;
    }

    // Getter
    public String getMaGhe() { return maGhe; }
    public String getTenGhe() { return tenGhe; }
    public int getGia() { return gia; }
    public boolean isDaDat() { return daDat; }

    // Setter (nếu cần)
}

