package com.cihanozmen.springboot.transactional.ts10;

import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;

@Transactional
@Service
public class Ts10Service2 {

    @Autowired
    private KategoriEntityService kategoriEntityService;

    @Autowired
    private Ts10Service3 ts10Service3;
    public void topluKaydet(){
        for(int i=2;i<12;i++){
            ts10Service3.kategoriKaydet(i);
        }
    }


}
