package com.cihanozmen.springboot.transactional.ts4;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts4Service2 {

    @Autowired
    KategoriEntityService kategoriEntityService;


    public void save(){
        Kategori kategori = new Kategori();

        kategori.setAdi("transactional4-2");
        kategori.setKirilim(1L);
        kategoriEntityService.save(kategori);

        System.out.println("4-2");
    }
}
