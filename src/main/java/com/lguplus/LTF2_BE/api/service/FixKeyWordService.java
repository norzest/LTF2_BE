package com.lguplus.LTF2_BE.api.service;

public interface FixKeyWordService {
    String fixKeyWord(String keyWord) throws Exception;
    void createDictionary(String language);
}
