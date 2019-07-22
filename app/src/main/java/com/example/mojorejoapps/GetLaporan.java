package com.example.mojorejoapps;

public class GetLaporan {
    private String isiLaporan;
    private String judulLaporan;
    private String pengirimLaporan;

    public GetLaporan(String isiLaporan, String judulLaporan, String pengirimLaporan) {
        this.isiLaporan = isiLaporan;
        this.judulLaporan = judulLaporan;
        this.pengirimLaporan = pengirimLaporan;
    }
    public GetLaporan(){

    }

    public String getIsiLaporan() {
        return isiLaporan;
    }

    public void setIsiLaporan(String isiLaporan) {
        this.isiLaporan = isiLaporan;
    }

    public String getJudulLaporan() {
        return judulLaporan;
    }

    public void setJudulLaporan(String judulLaporan) {
        this.judulLaporan = judulLaporan;
    }

    public String getPengirimLaporan() {
        return pengirimLaporan;
    }

    public void setPengirimLaporan(String pengirimLaporan) {
        this.pengirimLaporan = pengirimLaporan;
    }
}
