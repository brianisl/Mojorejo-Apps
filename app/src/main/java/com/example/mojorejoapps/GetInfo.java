package com.example.mojorejoapps;

public class GetInfo {

    private String profil;
    private String misi;
    private String visi;

    public GetInfo(String profil, String misi, String visi) {
        this.profil = profil;
        this.misi = misi;
        this.visi = visi;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getMisi() {
        return misi;
    }

    public void setMisi(String misi) {
        this.misi = misi.replace("__", "\n");
    }

    public String getVisi() {
        return visi;
    }

    public void setVisi(String visi) {
        this.visi = visi;
    }

    public GetInfo() {

    }
}
