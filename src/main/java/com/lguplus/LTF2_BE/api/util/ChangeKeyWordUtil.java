package com.lguplus.LTF2_BE.api.util;

import com.lguplus.LTF2_BE.core.domain.ChangeKeyword;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// writer : 심영효
public class ChangeKeyWordUtil {
    private static Map<String, String> dict = null;

    public static String changeKeyWord(String keyWord, List<ChangeKeyword> lst) {
        if(dict == null) {
            dict = new HashMap<>();

            for(ChangeKeyword ck : lst)
                dict.put(ck.getBeforeWord(), ck.getAfterWord());
        }

        return dict.getOrDefault(keyWord, keyWord);
    }
}
