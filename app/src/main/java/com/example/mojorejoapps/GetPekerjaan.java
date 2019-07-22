package com.example.mojorejoapps;

public class GetPekerjaan {
    private String cpPekerjaan;
    private String judulPekerjaan;


    public GetPekerjaan(String cpPekerjaan, String judulPekerjaan) {
        this.cpPekerjaan = cpPekerjaan;
        this.judulPekerjaan = judulPekerjaan;
    }

    public String getCpPekerjaan() {
        return cpPekerjaan;
    }

    public void setCpPekerjaan(String cpPekerjaan) {
        this.cpPekerjaan = cpPekerjaan;
    }

    public String getJudulPekerjaan() {
        return judulPekerjaan;
    }

    public void setJudulPekerjaan(String judulPekerjaan) {
        this.judulPekerjaan = judulPekerjaan;
    }

    public GetPekerjaan() {
    }
}
