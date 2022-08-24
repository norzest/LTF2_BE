package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PhoneResDto;
import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Override
    public List<PhoneResDto> findPhones() {

        List<Phone> phones = phoneRepository.findAllByOrderById();

        return phones.stream().map(PhoneResDto::new).collect(Collectors.toList());
    }
}
