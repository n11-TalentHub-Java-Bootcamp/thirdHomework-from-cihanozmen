package com.cihanozmen.springboot.controller;


import com.cihanozmen.springboot.converter.KategoriConverter;
import com.cihanozmen.springboot.converter.KullaniciConventer;
import com.cihanozmen.springboot.converter.UrunConverter;
import com.cihanozmen.springboot.dao.KullaniciDao;
import com.cihanozmen.springboot.dto.KullaniciDto;
import com.cihanozmen.springboot.entity.Kullanici;
import com.cihanozmen.springboot.entityService.KullaniciEntityService;
import com.cihanozmen.springboot.exceptions.KullaniciNotFoundException;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class KullaniciController {
    @Autowired
    private KullaniciEntityService kullaniciEntityService;

    @GetMapping("")
    public MappingJacksonValue findAllKullaniciList(){
        List<Kullanici> kullaniciList = kullaniciEntityService.findAll();

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id","kullaniciAdi","email","telefon");

        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("KullaniciFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(kullaniciList);
        mapping.setFilters(filters);

        return mapping;
    }

    @PostMapping("")
    public Kullanici saveKullanici(@RequestBody KullaniciDto kullaniciDto){
        Kullanici kullanici = KullaniciConventer.INSTANCE.convertKullaniciDtoToKullanici(kullaniciDto);

        kullanici = kullaniciEntityService.save(kullanici);

        return kullanici;
    }

    @GetMapping("/{kullaniciAdi}")
    public KullaniciDto findByUserName(@PathVariable String kullaniciAdi){

        Kullanici kullanici = kullaniciEntityService.findByUserName(kullaniciAdi);

        if(kullanici == null){
            throw new KullaniciNotFoundException("Kullanici not found username: "+ kullaniciAdi);
        }
        KullaniciDto kullaniciDto = KullaniciConventer.INSTANCE.convertKullaniciToKullaniciDto(kullanici);

        return kullaniciDto;
    }

    @GetMapping("/phone")
    public KullaniciDto findByPhoneNumber(@RequestParam String phone){

        Kullanici kullanici = kullaniciEntityService.findByPhoneNumber(phone);
        if(kullanici == null){
            throw new KullaniciNotFoundException("Kullanici not found phone number: "+ phone);
        }
        KullaniciDto kullaniciDto  = KullaniciConventer.INSTANCE.convertKullaniciToKullaniciDto(kullanici);
        return kullaniciDto;
    }
    @DeleteMapping
    public void deleteKullanici(@PathVariable Long id){
        kullaniciEntityService.deleteById(id);

    }
    @PutMapping("")
    public KullaniciDto update(@RequestBody KullaniciDto kullaniciDto){

        Kullanici kullanici = KullaniciConventer
                .INSTANCE.convertKullaniciDtoToKullanici(kullaniciDto);

        kullanici = kullaniciEntityService.save(kullanici);
        KullaniciDto result = KullaniciConventer.INSTANCE.convertKullaniciToKullaniciDto(kullanici);
        return  result;
    }
}
