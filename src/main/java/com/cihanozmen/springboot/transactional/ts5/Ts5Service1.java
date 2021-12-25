package com.cihanozmen.springboot.transactional.ts5;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts5Service1 {

    @Autowired
    private KategoriEntityService kategoriEntityService;

    @Autowired
    private Ts5Service2 ts5Service2;

    public void save(){
        Kategori kategori = new Kategori();
        kategori.setAdi("transactional5-1");
        kategori.setKirilim(1L);

        kategoriEntityService.save(kategori);

        ts5Service2.save();

        System.out.println("5-1");
    }

}
