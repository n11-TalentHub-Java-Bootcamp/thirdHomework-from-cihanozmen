package com.cihanozmen.springboot.dto;

import com.cihanozmen.springboot.entity.Kullanici;
import com.cihanozmen.springboot.entity.Urun;

import java.util.Date;

public class YorumDto {

    private Long id;
    private String yorum;
    private Date yorumTarihi;
    private Long urunId;
    private Long kullaniciId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public Date getYorumTarihi() {
        return yorumTarihi;
    }

    public void setYorumTarihi(Date yorumTarihi) {
        this.yorumTarihi = yorumTarihi;
    }

    public Long getUrunId() {
        return urunId;
    }

    public void setUrunId(Long urunId) {
        this.urunId = urunId;
    }

    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }
}
