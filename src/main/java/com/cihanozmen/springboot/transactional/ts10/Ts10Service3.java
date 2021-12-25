package com.cihanozmen.springboot.transactional.ts10;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts10Service3 {

    @Autowired
    private KategoriEntityService kategoriEntityService;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void kategoriKaydet(int i) {
        Kategori kategori = new Kategori();
        kategori.setAdi("transactional10-"+ i);
        kategori.setKirilim(1L);
        kategoriEntityService.save(kategori);

        if(i ==9){
            throw new RuntimeException("hata");

        }
    }
}
