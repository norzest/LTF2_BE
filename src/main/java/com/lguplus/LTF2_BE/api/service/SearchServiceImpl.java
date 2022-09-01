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

    // 검색어에 따른 검색 결과를 반환하는 함수
    @Override
    public List<PhoneResDto> searchPhones(String keyWord) throws Exception {
        // 검색어의 길이가 1자 이하라면 null 을 반환
        if (keyWord.length() <= 1)
            return null;

        // 상품의 이름, 제조사 중에서 해당 검색어를 포함하는 상품들을
        // PhoneResDto 로 변환하여 반환한다.
        return phoneRepository
                .findByTitleNameContainsOrManufacturingCompany(keyWord, ManufacturingCompany.convertValue(keyWord))
                .stream().map(PhoneResDto::new).collect(Collectors.toList());
    }

}
