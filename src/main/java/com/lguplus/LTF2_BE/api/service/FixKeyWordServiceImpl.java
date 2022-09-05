package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.util.ChangeKeyWordUtil;
import com.lguplus.LTF2_BE.core.repository.ChangeKeywordRepository;
import com.lguplus.LTF2_BE.core.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.lguplus.LTF2_BE.api.util.SymSpell.Correct;
import static com.lguplus.LTF2_BE.api.util.SymSpell.CreateDictionary;

// writer : 심영효
@RequiredArgsConstructor
@Service
public class FixKeyWordServiceImpl implements FixKeyWordService{

    private final KeywordRepository keywordRepository;

    private final ChangeKeywordRepository changeKeywordRepository;

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
        // ex. 갤넉시 -> 갤럭시
        String fixed = Correct(keyWord, "");

        // 사용자가 자주 검색할만한 키워드들을
        // DB 에 저장되어있는 같은 뜻의 값으로 변환한 후
        // 변한된 값을 반환 
        // ex. 상품의 제조사가 삼성 일 경우 samsung 으로 검색하면 결과가 나오지 않는다
        // ex. 따라서 samsung 을 삼성으로 변환하여 반환
        return ChangeKeyWordUtil.changeKeyWord(fixed, changeKeywordRepository.findAll());
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
