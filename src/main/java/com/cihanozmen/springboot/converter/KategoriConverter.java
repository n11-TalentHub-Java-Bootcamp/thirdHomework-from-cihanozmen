package com.cihanozmen.springboot.converter;

import com.cihanozmen.springboot.dto.KategoriDto;
import com.cihanozmen.springboot.entity.Kategori;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KategoriConverter {

    KategoriConverter INSTANCE = Mappers.getMapper(KategoriConverter.class);
    @Mapping(target = "ustKategoriId",source = "ustKategori.id")
    KategoriDto convertKategoriToKategoriDto(Kategori kategori);

    @Mapping(target = "ustKategoriId",source = "ustKategori.id")
    List<KategoriDto> convertAllKategoriListToKategoriDtoList(List<Kategori> kategoriList);

    //@Mapping(target = "ustKategori.id", source = "ustKategoriId")
    Kategori convertKategoriDtoToKategori(KategoriDto kategoriDto);

//    @Mapping(target = "ustKategori.id",source="ustKategoriId")
   //Kategori convertKategoriDtoToKategori(KategoriDto kategoriDto);
}
