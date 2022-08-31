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

    @Override
    public List<PhoneResDto> findPhones() {

        List<Phone> phones = phoneRepository.findAllByOrderById();

        return phones.stream().map(PhoneResDto::new).collect(Collectors.toList());
    }

    @Override
    public List<PhoneResDto> findPhonesByTelecomTech(String telecomTech) {
        List<Phone> phones = phoneRepository.findByTelecomTech(TelecomTech.convertValue(telecomTech));

        if (phones.size() == 0) {
            throw new NoSuchElementException();
        }

        return phones.stream().map(PhoneResDto::new).collect(Collectors.toList());
    }

    @Override
    public PhoneDetailResDto findPhoneDetail(Long phoneId) {

        Phone phone = phoneRepository.findById(phoneId).get();
        List<Long> colorList = phone.getPhoneColors()
                .stream().map(PhoneColor::getColor).collect(Collectors.toList())
                .stream().map(Color::getId).collect(Collectors.toList());
        List<ColorResDto> colorResDtos = new ArrayList<>();

        for (Long colorId : colorList) {
            Color color = colorRepository.findById(colorId).get();
            PhoneColor phoneColor = phoneColorRepository.findByPhoneIdAndColorId(phoneId, colorId);
            List<String> phoneImgList = phoneImgRepository.findByPhoneColor(phoneColor)
                    .stream().map(PhoneImg::getImg).collect(Collectors.toList());

            ColorResDto colorResDto = new ColorResDto(color, phoneImgList);

            colorResDtos.add(colorResDto);
        }

        return new PhoneDetailResDto(phone, colorResDtos);
    }
}
