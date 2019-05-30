package tdc.edu.vn.test;

public class Song {
    private String tenBaiHat, tenCaSi;
    private int File, hinh;

    public Song(String tenBaiHat, String tenCaSi, int file, int hinh) {
        this.tenBaiHat = tenBaiHat;
        this.tenCaSi = tenCaSi;
        File = file;
        this.hinh = hinh;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getTenCaSi() {
        return tenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }

    public int getFile() {
        return File;
    }

    public void setFile(int file) {
        File = file;
    }
//private int hinhAnh, File;

//    public Song(String tenBaiHat, int hinhAnh, int file) {
//        this.tenBaiHat = tenBaiHat;
//        this.hinhAnh = hinhAnh;
//        File = file;
//    }
//
//    public String getTenBaiHat() {
//        return tenBaiHat;
//    }
//
//    public void setTenBaiHat(String tenBaiHat) {
//        this.tenBaiHat = tenBaiHat;
//    }
//
//    public int getHinhAnh() {
//        return hinhAnh;
//    }
//
//    public void setHinhAnh(int hinhAnh) {
//        this.hinhAnh = hinhAnh;
//    }
//
//    public int getFile() {
//        return File;
//    }
//
//    public void setFile(int file) {
//        File = file;
//    }
}
