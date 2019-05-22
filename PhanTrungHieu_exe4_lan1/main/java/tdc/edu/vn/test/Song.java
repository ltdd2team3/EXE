package tdc.edu.vn.test;

public class Song {
    private String tenBaiHat;
    private int hinhAnh, File;

    public Song(String tenBaiHat, int hinhAnh, int file) {
        this.tenBaiHat = tenBaiHat;
        this.hinhAnh = hinhAnh;
        File = file;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getFile() {
        return File;
    }

    public void setFile(int file) {
        File = file;
    }
}
