package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.ColorResDto;
import com.lguplus.LTF2_BE.api.dto.response.PhoneDetailResDto;
import com.lguplus.LTF2_BE.api.dto.response.PhoneResDto;
import com.lguplus.LTF2_BE.core.domain.*;
import com.lguplus.LTF2_BE.core.domain.enm.TelecomTech;
import com.lguplus.LTF2_BE.core.repository.ColorRepository;
import com.lguplus.LTF2_BE.core.repository.PhoneColorRepository;
import com.lguplus.LTF2_BE.core.repository.PhoneImgRepository;
import com.lguplus.LTF2_BE.core.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final ColorRepository colorRepository;
    private final PhoneImgRepository phoneImgRepository;
    private final PhoneColorRepository phoneColorRepository;

    /// 상품을 전체 조회하는 함수
    @Override
    public List<PhoneResDto> findPhones() {

        // DB에서 상품 전체를 조회하여 id 순으로 정렬한 후 Phone 배열 반환
        List<Phone> phones = phoneRepository.findAllByOrderById();

        // List<Phone>을 List<PhoneResDto>로 변환하기 위해 stream() 함수를 활용
        return phones.stream().map(PhoneResDto::new).collect(Collectors.toList());
    }

    // 통신 기술에 따른 상품 리스트를 조회하는 함수
    @Override
    public List<PhoneResDto> findPhonesByTelecomTech(String telecomTech) {

        // DB에서 통신 기술에 따른 상품 리스트를 조회하여 Phone 배열 반환
        List<Phone> phones = phoneRepository.findByTelecomTech(TelecomTech.convertValue(telecomTech));

        // DB 조회 결과가 빈 배열일 경우 NoSuchElementException 발생
        if (phones.size() == 0) {
            throw new NoSuchElementException();
        }

        // List<Phone>을 List<PhoneResDto>로 변환하기 위해 stream() 함수를 활용
        return phones.stream().map(PhoneResDto::new).collect(Collectors.toList());
    }

    // 상품을 상세 조회하는 함수
    @Override
    public PhoneDetailResDto findPhoneDetail(Long phoneId) {

        // DB에서 상품 상세 조회하여 Phone 객체 반환
        Phone phone = phoneRepository.findById(phoneId).get();
        /**
         * phone과 연관되어 있는 색상 id 배열을 얻는 과정
         * phone.getPhoneColors를 통해 PhoneColor 배열 얻음
         * List<PhoneColor>을 List<Color>로 변환하기 위해 stream() 함수를 활용
         * List<Color>을 List<Long>로 변환하기 위해 stream() 함수를 활용
         */
        List<Long> colorList = phone.getPhoneColors()
                .stream().map(PhoneColor::getColor).collect(Collectors.toList())
                .stream().map(Color::getId).collect(Collectors.toList());

        /**
         * colorResDtos를 초기화 후
         * for 문을 돌며 ColorResDto 객체를 생성 후 colorResDtos에 추가
         * colorId & phoneId에 해당하는 PhoneColor 객체를 찾고
         * PhoneColor 객체에 대응되는 phoneImgList 조회하여
         * List<PhoneImg>을 List<String>로 변환하기 위해 stream() 함수를 활용
         */
        List<ColorResDto> colorResDtos = new ArrayList<>();
        for (Long colorId : colorList) {
            Color color = colorRepository.findById(colorId).get();
            PhoneColor phoneColor = phoneColorRepository.findByPhoneIdAndColorId(phoneId, colorId);
            List<String> phoneImgList = phoneImgRepository.findByPhoneColor(phoneColor)
                    .stream().map(PhoneImg::getImg).collect(Collectors.toList());

            ColorResDto colorResDto = new ColorResDto(color, phoneImgList);

            colorResDtos.add(colorResDto);
        }

        // PhoneDetailResDto 객체를 생성하여 반환
        return new PhoneDetailResDto(phone, colorResDtos);
    }
}
