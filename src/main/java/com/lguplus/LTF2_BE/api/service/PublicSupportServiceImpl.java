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

    @Override
    public List<PublicSupportPlanResDto> findPublicSupportPlanResDto(Long phoneId) {
        List<PublicSupport> publicSupports = publicSupportRepository.findAllOrderByPhoneId(phoneId);
        return publicSupports.stream().map(PublicSupportPlanResDto::new).collect(Collectors.toList());
    }

    @Override
    public List<PublicSupportPhoneResDto> findPublicSupportPhoneResDto(Long planId) {
        List<PublicSupport> publicSupports = publicSupportRepository.findAllOrderByPlanId(planId);
        return publicSupports.stream().map(PublicSupportPhoneResDto::new).collect(Collectors.toList());
    }

    @Override
    public Integer findPublicSupportResDto(Long phoneId, Long planId) {
        PublicSupport publicSupport = publicSupportRepository.findByPhoneIdAndPlanId(phoneId,planId);
        return publicSupport.getSupportPrice();
    }
}
