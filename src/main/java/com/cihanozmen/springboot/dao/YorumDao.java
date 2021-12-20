package com.cihanozmen.springboot.dao;

import com.cihanozmen.springboot.entity.UrunYorum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YorumDao extends JpaRepository<UrunYorum,Long> {

    @Query("select yorum from UrunYorum urunyorum where urunyorum.kullanici.id = :kullaniciId ")
    List<UrunYorum> findAllByKullaniciId(Long kullaniciId);

    @Query("select yorum from UrunYorum urunyorum where urunyorum.urun.id = :urunId")
    List<UrunYorum> findAllByUrunId(Long urunId);
}
