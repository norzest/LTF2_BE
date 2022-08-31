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

    @Override
    public String fixKeyWord(String keyWord) throws Exception {

        createDictionary("");
        String fixed = Correct(keyWord, "");

        switch (fixed) {
            case "Galaxy":
                fixed = "갤럭시";
                break;
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

        return fixed;
    }

    @Override
    public void createDictionary(String language) {
        CreateDictionary(keywordRepository.findAll(),language);
    }
}
