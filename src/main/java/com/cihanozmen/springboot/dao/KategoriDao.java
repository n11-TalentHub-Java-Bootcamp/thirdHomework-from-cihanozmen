package com.cihanozmen.springboot.dao;


import com.cihanozmen.springboot.entity.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KategoriDao extends JpaRepository<Kategori,Long> {

    List<Kategori> findAllByUstKategoriIsNull();


}
