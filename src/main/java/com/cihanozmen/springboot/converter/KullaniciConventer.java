package com.cihanozmen.springboot.converter;

import com.cihanozmen.springboot.dto.KullaniciDto;
import com.cihanozmen.springboot.entity.Kullanici;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KullaniciConventer {

    KullaniciConventer INSTANCE  = Mappers.getMapper(KullaniciConventer.class);


    Kullanici convertKullaniciDtoToKullanici(KullaniciDto kullaniciDto);

    KullaniciDto convertKullaniciToKullaniciDto(Kullanici kullanici);

    List<KullaniciDto> convertAllKullaniciListToKullaniciDtoList(List<Kullanici> kullaniciList);
}
