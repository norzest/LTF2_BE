package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PublicSupportPhoneResDto;
import com.lguplus.LTF2_BE.api.dto.response.PublicSupportPlanResDto;
import com.lguplus.LTF2_BE.core.domain.PublicSupport;
import com.lguplus.LTF2_BE.core.repository.PublicSupportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PublicSupportServiceImpl implements PublicSupportService {

    private final PublicSupportRepository publicSupportRepository;

    // 핸드폰에 맞는 공시지원금을 조회하는 함수
    @Override
    public List<PublicSupportPlanResDto> findPublicSupportPlanResDto(Long phoneId) {
        // DB에서 핸드폰에 맞는 공시지원금을 조회하여 List<PublicSupport> 반환
        List<PublicSupport> publicSupports = publicSupportRepository.findAllOrderByPhoneId(phoneId);
        // List<PublicSupport>를 List<PublicSupportPlanResDto>로 변환하여 반환
        return publicSupports.stream().map(PublicSupportPlanResDto::new).collect(Collectors.toList());
    }

    // 요금제에 맞는 공시지원금을 조회하는 함수
    @Override
    public List<PublicSupportPhoneResDto> findPublicSupportPhoneResDto(Long planId) {
        // DB에서 요금제에 맞는 공시지원금을 조회하여 List<PublicSupport> 반환
        List<PublicSupport> publicSupports = publicSupportRepository.findAllOrderByPlanId(planId);
        // List<PublicSupport>를 List<PublicSupportPhoneResDto>로 변환하여 반환
        return publicSupports.stream().map(PublicSupportPhoneResDto::new).collect(Collectors.toList());
    }

    // 핸드폰과 요금제에 맞는 공시지원금을 조회하는 함수
    @Override
    public Integer findPublicSupportResDto(Long phoneId, Long planId) {
        // DB에서 핸드폰과 요금제에 맞는 공시지원금을 조회하여 PublicSupport 객체 반환
        PublicSupport publicSupport = publicSupportRepository.findByPhoneIdAndPlanId(phoneId,planId);
        // PublicSupport객체에서 SupportPrice 반환
        return publicSupport.getSupportPrice();
    }
}