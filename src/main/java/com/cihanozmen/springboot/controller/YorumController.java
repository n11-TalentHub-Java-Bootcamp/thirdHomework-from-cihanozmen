package com.cihanozmen.springboot.controller;

import com.cihanozmen.springboot.converter.YorumConventer;
import com.cihanozmen.springboot.dto.YorumDto;
import com.cihanozmen.springboot.entity.UrunYorum;
import com.cihanozmen.springboot.entityService.KullaniciEntityService;
import com.cihanozmen.springboot.entityService.UrunEntityService;
import com.cihanozmen.springboot.entityService.YorumEntityService;
import com.cihanozmen.springboot.exceptions.YorumNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class YorumController {

    @Autowired
    private YorumEntityService yorumEntityService;

    @Autowired
    private KullaniciEntityService kullaniciEntityService;

    @Autowired
    private UrunEntityService urunEntityService;


    @GetMapping("user/{kullaniciId}")
    public List<YorumDto> findAllCommentByKullaniciId(@PathVariable Long kullaniciId){


        List<UrunYorum> yorumList =yorumEntityService.findAllByKullaniciId(kullaniciId);

        if(yorumList.isEmpty()){
            throw new YorumNotFoundException(kullaniciId+" kullanıcı henüz yorum yapmamıştır");

        }

        List<YorumDto> yorumDtoList = YorumConventer.INSTANCE.convertAllYorumListToYorumDtoList(yorumList);


        return yorumDtoList;


    }


    @GetMapping("product/{urunId}")
    public List<YorumDto> findAllCommentsByUrunId(@PathVariable Long urunId){
        List<UrunYorum> yorumList = yorumEntityService.findlAllByUrunId(urunId);

        if(yorumList.isEmpty()){
            throw new YorumNotFoundException(urunId+" 'sine ait ürün için yorum bulunamadı");
        }

        List<YorumDto> yorumDtoList = YorumConventer.INSTANCE.convertAllYorumListToYorumDtoList(yorumList);

        return yorumDtoList;
    }

    @PostMapping("")
    public ResponseEntity<Object> saveYorum(@RequestBody YorumDto yorumDto){
        UrunYorum yorum = YorumConventer.INSTANCE.convertYorumDtoToUrunYorum(yorumDto);

        yorum = yorumEntityService.save(yorum);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id]").buildAndExpand(yorum.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


    @DeleteMapping("{id}")
    public void deleteYorum(@PathVariable Long id){
        yorumEntityService.deleteById(id);
    }




}
