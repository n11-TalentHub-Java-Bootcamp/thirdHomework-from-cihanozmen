package com.cihanozmen.springboot.transactional.ts3;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts3Service1 {


    @Autowired
    private KategoriEntityService kategoriEntityService;

    @Autowired
    private Ts3Service2 ts3Service2;
    public void save(){

        Kategori kategori = new Kategori();
        kategori.setAdi("transactional3-1");
        kategori.setKirilim(1L);

        kategoriEntityService.save(kategori);

        ts3Service2.save();

        System.out.println("transacitonal service ends");
    }


}
