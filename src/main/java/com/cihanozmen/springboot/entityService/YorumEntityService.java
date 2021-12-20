package com.cihanozmen.springboot.entityService;

import com.cihanozmen.springboot.dao.YorumDao;
import com.cihanozmen.springboot.entity.UrunYorum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YorumEntityService {

    @Autowired
    private YorumDao yorumDao;

    public List<UrunYorum> findAllByKullaniciId(Long kullaniciId){
        return yorumDao.findAllByKullaniciId(kullaniciId);
    }

    public List<UrunYorum> findlAllByUrunId(Long urunId) {
        return yorumDao.findAllByUrunId(urunId);
    }

    public void deleteById(Long id) {
        yorumDao.deleteById(id);
    }

    public UrunYorum save(UrunYorum yorum) {
        yorum = yorumDao.save(yorum);
        return yorum;
    }
}
