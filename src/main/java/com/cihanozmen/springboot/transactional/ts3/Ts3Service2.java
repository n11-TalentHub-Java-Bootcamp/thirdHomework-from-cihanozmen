package com.cihanozmen.springboot.transactional.ts3;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ts3Service2 {

    @Autowired
    private KategoriEntityService kategoriEntityService;

    public void save(){
        Kategori kategori = new Kategori();
        kategori.setAdi("transactional3-2");
        kategori.setKirilim(1L);

        kategoriEntityService.save(kategori);

        System.out.println("non transactional entity service");
    }
}
