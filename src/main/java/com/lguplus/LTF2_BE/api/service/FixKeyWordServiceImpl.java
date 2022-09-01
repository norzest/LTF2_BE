package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.core.domain.Keyword;
import com.lguplus.LTF2_BE.core.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.lguplus.LTF2_BE.api.util.SymSpell.Correct;
import static com.lguplus.LTF2_BE.api.util.SymSpell.CreateDictionary;

@RequiredArgsConstructor
@Service
public class FixKeyWordServiceImpl implements FixKeyWordService{

    private final KeywordRepository keywordRepository;

    /**
     * 검색어의 편집거리를 계산하여 DB 에 있는 문자열 리스트 중
     * 가장 일치하는 문자열로 변환하여 반환해주는 함수
     */
    @Override
    public String fixKeyWord(String keyWord) throws Exception {

        // DB 에서 문자열들을 불러와 편집거리를 계산한 사전을 생성한다
        // 이미 생성되어 있을 경우 재 생성하지 않는다
        createDictionary("");

        // 생성된 사전에서 keyWord 의 편집 거리를 계산하여
        // 편집거리가 낮은 가장 적절한 문자열로 반환한다.
        String fixed = Correct(keyWord, "");

        // 사용자가 자주 검색할만한 키워드들을
        // DB 에 저장되어있는 같은 뜻의 값들로 변환
        switch (fixed) {
            case "아이폰":
                fixed = "iPhone";
                break;
            case "samsung":
                fixed = "삼성";
                break;
            case "apple":
                fixed = "애플";
                break;
            case "플립":
                fixed = "Flip";
                break;
            case "폴더":
            case "폴더블":
                fixed = "Fold";
                break;
            default:
                break;
        }

        // 수정된 값을 반환
        return fixed;
    }

    // DB 에 저장되어있는 문자열들을 가져와 사전을 생성한다
    @Override
    public void createDictionary(String language) {
        // DB 에 저장되어있는 문자열들을 가져와 사전을 생성한다
        // 해당 keyword 별 언어들을 설정할 수 있다
        // default 는 ""
        CreateDictionary(keywordRepository.findAll(),language);
    }
}
