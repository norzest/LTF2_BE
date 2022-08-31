package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PhoneResDto;
import com.lguplus.LTF2_BE.core.domain.enm.ManufacturingCompany;
import com.lguplus.LTF2_BE.core.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService{

    private final PhoneRepository phoneRepository;

    @Override
    public List<PhoneResDto> searchPhones(String keyWord) throws Exception {
        if (keyWord.length() <= 1)
            return null;

        return phoneRepository
                .findByTitleNameContainsOrManufacturingCompany(keyWord, ManufacturingCompany.convertValue(keyWord))
                .stream().map(PhoneResDto::new).collect(Collectors.toList());
    }

}
