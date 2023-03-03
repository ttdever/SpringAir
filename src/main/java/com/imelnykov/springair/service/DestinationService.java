package com.imelnykov.springair.service;

import com.imelnykov.springair.dao.DestinationDao;
import com.imelnykov.springair.dto.out.DestinationOutDto;
import com.imelnykov.springair.entities.Destination;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService {
    @Autowired
    private DestinationDao destinationDao;

    @Autowired
    private ModelMapper mapper;

    public List<DestinationOutDto> getAllDestinations() {
        return destinationDao.findAll().stream().map(this::mapDestinationToDestinationOutDto).toList();
    }

    private DestinationOutDto mapDestinationToDestinationOutDto(Destination destination) {
        return mapper.map(destination, DestinationOutDto.class);
    }
}
