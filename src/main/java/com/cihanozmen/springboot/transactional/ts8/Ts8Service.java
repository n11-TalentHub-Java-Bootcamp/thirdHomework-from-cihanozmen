package com.cihanozmen.springboot.transactional.ts8;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts8Service {

    @Autowired
    private KategoriEntityService kategoriEntityService;

    public void save(){
        Kategori kategori = new Kategori();
        kategori.setAdi("transactional8-1");
        kategori.setKirilim(1L);
        kategoriEntityService.save(kategori);


        save2();
        System.out.println("8-1");
    }


    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void save2(){
        Kategori kategori = new Kategori();
        kategori.setAdi("transactional8-2");
        kategori.setKirilim(1L);
        kategoriEntityService.save(kategori);


        System.out.println("8-2");

    }
}
