package com.lguplus.LTF2_BE;

import com.lguplus.LTF2_BE.api.dto.response.PhoneResDto;
import com.lguplus.LTF2_BE.api.service.SearchService;
import com.lguplus.LTF2_BE.core.repository.PhoneRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class SearchServiceTest {

    @Autowired
    private SearchService searchService;

    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    public void searchPhonesTest() {
        // given
        String keyWord1 = "갤럭시";
        String keyWord2 = "1";

        try {
            // when
            List<PhoneResDto> phones1 = searchService.searchPhones(keyWord1);
            List<PhoneResDto> phones2 = searchService.searchPhones(keyWord2);

            // then
            Assertions.assertThat(phones1.size()).isEqualTo(17);
            Assertions.assertThat(phones2).isNull();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
