package com.cihanozmen.springboot.converter;

import com.cihanozmen.springboot.dto.YorumDto;
import com.cihanozmen.springboot.entity.UrunYorum;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface YorumConventer {

    YorumConventer INSTANCE = Mappers.getMapper(YorumConventer.class);

    List<YorumDto> convertAllYorumListToYorumDtoList(List<UrunYorum> yorumList);

    UrunYorum convertYorumDtoToUrunYorum(YorumDto yorumDto);
}
