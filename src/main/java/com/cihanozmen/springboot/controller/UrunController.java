package com.cihanozmen.springboot.controller;

import com.cihanozmen.springboot.converter.UrunConverter;
import com.cihanozmen.springboot.dto.UrunDetayDto;
import com.cihanozmen.springboot.dto.UrunDto;
import com.cihanozmen.springboot.entity.Kategori;
import com.cihanozmen.springboot.entity.Urun;
import com.cihanozmen.springboot.entityService.KategoriEntityService;
import com.cihanozmen.springboot.entityService.UrunEntityService;
import com.cihanozmen.springboot.exceptions.UrunNotFoundException;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/urunler/")
public class UrunController {

    @Autowired
    private UrunEntityService urunEntityService;

    @Autowired
    private KategoriEntityService kategoriEntityService;

    @GetMapping("")
    public MappingJacksonValue findAllUrunList(){
        List<Urun> urunList = urunEntityService.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","adi","fiyat","kayitTarihi");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UrunFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(urunList);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/{id}")
    public MappingJacksonValue findUrunById(@PathVariable Long id){
        Urun urun = urunEntityService.findById(id);

        if(urun == null){
            throw new UrunNotFoundException("Urun not found id : " + id);
        }
        WebMvcLinkBuilder linkToUrun =
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder
                                .methodOn(this.getClass()).findAllUrunList());

        UrunDto urunDto = UrunConverter.INSTANCE.convertUrunToUrunDto(urun);

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id","adi","fiyat","kayitTarihi");
        SimpleFilterProvider filters =
                new SimpleFilterProvider().addFilter("UrunDtoFilter",filter);

        EntityModel entityModel = EntityModel.of(urunDto);

        entityModel.add(linkToUrun.withRel("tum urunler"));
        MappingJacksonValue mapping = new MappingJacksonValue(urunDto);
        mapping.setFilters(filters);

        //return urunEntityService.findById(id);
        return mapping;
    }

    @GetMapping("/dto/{id}")
    public UrunDetayDto findUrunDtoById(@PathVariable Long id){
        Urun urun = urunEntityService.findById(id);

        if(urun == null){
            throw new UrunNotFoundException("Urun not found id : " + id);
        }

        UrunDetayDto urunDetayDto = UrunConverter.INSTANCE.convertUrunToUrunDetayDto(urun);

        //UrunDetayDto urunDetayDto = convertUruntoUrunDetayDto(urun);
        return urunDetayDto;


    }

    @GetMapping("kategoriler/{kategoriId}")
    public List<UrunDetayDto> findAllUrunByKategoriId(@PathVariable Long kategoriId){
        List<Urun> urunList = urunEntityService.findAllByKategoriOrderByIdDesc(kategoriId);

        List<UrunDetayDto> urunDetayDtoList = UrunConverter.INSTANCE.convertAllUrunListToUrunDetayDtoList(urunList);

        return urunDetayDtoList;
    }

    @PostMapping("")
    public ResponseEntity<Object> saveUrun(@RequestBody UrunDto urunDto){
        Urun urun  = UrunConverter.INSTANCE.convertUrunDtoToUrun(urunDto);

        //Urun urun = convertUrunDtoToUrun(urunDto);

        urun = urunEntityService.save(urun);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id]").buildAndExpand(urun.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUrun(@PathVariable Long id){
        urunEntityService.deleteById(id);

    }

    private Urun convertUrunDtoToUrun(UrunDto urunDto){
        Kategori kategori = kategoriEntityService.findById(urunDto.getKategoriId());

        Urun urun = new Urun();
        urun.setAdi(urunDto.getAdi());
        urun.setFiyat(urunDto.getFiyat());
        urun.setKayitTarihi(urunDto.getKayitTarihi());
        urun.setKategori(kategori);

        return urun;
    }
    private UrunDetayDto convertUruntoUrunDetayDto(Urun urun) {
        Kategori kategori = kategoriEntityService.findById(urun.getKategori().getId());

        UrunDetayDto urunDetayDto = new UrunDetayDto();
        urunDetayDto.setUrunAdi(urun.getAdi());
        urunDetayDto.setUrunFiyati(urun.getFiyat());
        urunDetayDto.setKategoriAdi(kategori.getAdi());
        return urunDetayDto;
    }

    private SimpleFilterProvider getUrunFilterProvider(String filterName){
        SimpleBeanPropertyFilter filter = getUrunFilter();

        return  new SimpleFilterProvider().addFilter(filterName,filter);
    }

    private SimpleBeanPropertyFilter getUrunFilter(){
        return SimpleBeanPropertyFilter.filterOutAllExcept("id","adi","fiyat","kayitTarihi");
    }



}
