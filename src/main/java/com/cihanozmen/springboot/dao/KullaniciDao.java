package com.cihanozmen.springboot.dao;

import com.cihanozmen.springboot.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface KullaniciDao extends JpaRepository<Kullanici,Long> {

    @Query("select kullanici from Kullanici kullanici where kullanici.kullaniciAdi = :kullaniciAdi")
    Kullanici findByUserName(String kullaniciAdi);

    @Query("select kullanici from Kullanici kullanici where kullanici.telefon = :telefon")
    Kullanici findByPhoneNumber(String telefon);
}
