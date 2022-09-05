package com.lguplus.LTF2_BE.api.service;

// writer : 심영효
public interface FixKeyWordService {
    String fixKeyWord(String keyWord) throws Exception;
    void createDictionary(String language);
}
