package com.cihanozmen.springboot.transactional.ts5;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class Ts5Service2 {

    @Autowired
    private KategoriEntityService kategoriEntityService;


    public void save(){
        Kategori kategori = new Kategori();

        kategori.setAdi("transactional5-2");
        kategori.setKirilim(1L);
        kategoriEntityService.save(kategori);

        System.out.println("5-2");

    }
}
