package com.example.mojorejoapps;

public class GetKegiatan {
    private String judulKegiatan;
    private String isiKegiatan;
    private String tanggalKegiatan;
    private String lokasiKegiatan;
    private String linkGambar;

    public GetKegiatan(String judulKegiatan, String isiKegiatan, String tanggalKegiatan, String lokasiKegiatan, String linkGambar) {
        this.judulKegiatan = judulKegiatan;
        this.isiKegiatan = isiKegiatan;
        this.tanggalKegiatan = tanggalKegiatan;
        this.lokasiKegiatan = lokasiKegiatan;
        this.linkGambar = linkGambar;
    }

    public String getLinkGambar() {
        return linkGambar;
    }

    public void setLinkGambar(String linkGambar) {
        this.linkGambar = linkGambar;
    }

    public String getJudulKegiatan() {
        return judulKegiatan;
    }

    public void setJudulKegiatan(String judulKegiatan) {
        this.judulKegiatan = judulKegiatan;
    }

    public String getIsiKegiatan() {
        return isiKegiatan;
    }

    public void setIsiKegiatan(String isiKegiatan) {
        this.isiKegiatan = isiKegiatan;
    }

    public String getTanggalKegiatan() {
        return tanggalKegiatan;
    }

    public void setTanggalKegiatan(String tanggalKegiatan) {
        this.tanggalKegiatan = tanggalKegiatan;
    }

    public String getLokasiKegiatan() {
        return lokasiKegiatan;
    }

    public void setLokasiKegiatan(String lokasiKegiatan) {
        this.lokasiKegiatan = lokasiKegiatan;
    }

    public GetKegiatan() {

    }
}
