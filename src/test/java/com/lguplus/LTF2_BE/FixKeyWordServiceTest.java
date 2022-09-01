package com.lguplus.LTF2_BE;

import com.lguplus.LTF2_BE.api.service.FixKeyWordService;
import com.lguplus.LTF2_BE.core.repository.KeywordRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class FixKeyWordServiceTest {

    @Autowired
    private FixKeyWordService fixKeyWordService;

    @Autowired
    private KeywordRepository keywordRepository;

    @Test
    public void fixKeyWordTest() {
        // given
        String keyWord = "갤넉시";

        try {
            // when
            String fixed = fixKeyWordService.fixKeyWord(keyWord);

            // then
            Assertions.assertThat(fixed).isEqualTo("갤럭시");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
