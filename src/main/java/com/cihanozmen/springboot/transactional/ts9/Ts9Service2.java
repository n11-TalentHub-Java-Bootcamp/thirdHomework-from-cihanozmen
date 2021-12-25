package com.cihanozmen.springboot.transactional.ts9;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts9Service2 {

    @Autowired
    private KategoriEntityService kategoriEntityService;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void save2(){
        Kategori kategori = new Kategori();
        kategori.setAdi("transactional9-2");
        kategori.setKirilim(1L);
        kategoriEntityService.save(kategori);

        System.out.println("9-2");
    }
}
