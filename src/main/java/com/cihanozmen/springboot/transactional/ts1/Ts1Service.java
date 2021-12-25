package com.cihanozmen.springboot.transactional.ts1;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ts1Service {

    @Autowired
    private KategoriEntityService kategoriEntityService;
    public void save(){


        Kategori kategori = new Kategori();
        kategori.setAdi("transactiona1");
        kategori.setKirilim(1L);

        kategoriEntityService.save(kategori);

        System.out.println("end");
    }
}
