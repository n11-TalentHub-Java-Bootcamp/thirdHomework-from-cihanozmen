package com.cihanozmen.springboot.transactional.ts10;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class Ts10Service1 {
    @Autowired
    private KategoriEntityService kategoriEntityService;

    @Autowired
    private Ts10Service2 ts10Service2;


    public  void save(){
        Kategori kategori = new Kategori();
        kategori.setAdi("transactional10-1");
        kategori.setKirilim(1l);
        kategoriEntityService.save(kategori);

        ts10Service2.topluKaydet();

        System.out.println("10-1");

    }
}
