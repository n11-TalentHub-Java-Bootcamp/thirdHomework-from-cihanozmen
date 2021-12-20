package com.cihanozmen.springboot.entityService;

import com.cihanozmen.springboot.dao.KullaniciDao;
import com.cihanozmen.springboot.entity.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KullaniciEntityService {

    @Autowired
    private KullaniciDao kullaniciDao;

    public Kullanici findById(Long id){
        Optional<Kullanici> optionalKullanici = kullaniciDao.findById(id);

        Kullanici kullanici = null;

        if(optionalKullanici.isPresent()){
            kullanici = optionalKullanici.get();
        }

        return kullanici;

    }

    public Kullanici findByUserName(String username){
        Optional<Kullanici> optionalKullanici = Optional.ofNullable(kullaniciDao.findByUserName(username));

        Kullanici kullanici = null;

        if(optionalKullanici.isPresent()){
            kullanici = optionalKullanici.get();
        }

        return kullanici;
    }

    public List<Kullanici> findAll(){
        return (List<Kullanici>) kullaniciDao.findAll();


    }

    public Kullanici save(Kullanici kullanici){
        kullanici = kullaniciDao.save(kullanici);

        return kullanici;
    }


    public Kullanici findByPhoneNumber(String telefon) {
        Optional<Kullanici> optionalKullanici = Optional.ofNullable(kullaniciDao.findByPhoneNumber(telefon));

        Kullanici kullanici = null;

        if(optionalKullanici.isPresent()){
            kullanici = optionalKullanici.get();
        }

        return kullanici;

    }

    public void deleteById(Long id) {
        kullaniciDao.deleteById(id);
    }
}
