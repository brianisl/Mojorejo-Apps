package com.example.mojorejoapps;

public class GetBerita {
    private String judulBerita;
    private String linkGambar;

    public String getIsiBerita() {
        return isiBerita;
    }

    public void setIsiBerita(String isiBerita) {
        this.isiBerita = isiBerita;
    }

    private String isiBerita;

    public GetBerita() {

    }

    public String getLinkGambar() {
        return linkGambar;
    }

    public void setLinkGambar(String linkGambar) {
        this.linkGambar = linkGambar;
    }

    public GetBerita(String judulBerita,  String linkGambar, String isiBerita) {
        this.judulBerita = judulBerita;
        this.linkGambar = linkGambar;
        this.isiBerita = isiBerita;
    }

    public String getJudulBerita() {
        return judulBerita;
    }

    public void setJudulBerita(String judulBerita) {
        this.judulBerita = judulBerita;
    }

}

