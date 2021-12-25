package com.cihanozmen.springboot.transactional.ts6;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class Ts6Service {

    @Autowired
    KategoriEntityService kategoriEntityService;

    public  void save(){
        Kategori kategori = new Kategori();
        kategori.setAdi("transational6-1");
        kategori.setKirilim(1L);
        kategoriEntityService.save(kategori);

        System.out.println("kayıt başarılı");

        throw  new RuntimeException("hata");
    }

}
