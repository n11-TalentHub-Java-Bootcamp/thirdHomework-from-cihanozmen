package com.cihanozmen.springboot.transactional.ts9;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts9Service1 {

    @Autowired
    private KategoriEntityService kategoriEntityService;

    @Autowired
    private Ts9Service2 ts9Service2;

    public  void  save(){
        Kategori kategori = new Kategori();
        kategori.setAdi("transactional9-1");
        kategori.setKirilim(1L);

        kategoriEntityService.save(kategori);



        ts9Service2.save2();
        System.out.println("9-1");
    }
}
