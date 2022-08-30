package com.lguplus.LTF2_BE.api.controller;

import io.github.mightguy.spellcheck.symspell.api.DataHolder;
import io.github.mightguy.spellcheck.symspell.api.StringDistance;
import io.github.mightguy.spellcheck.symspell.common.*;
import io.github.mightguy.spellcheck.symspell.impl.InMemoryDataHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/syh")
public class SyhController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> syh() {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.OK;

        SpellCheckSettings spellCheckSettings = SpellCheckSettings.builder()
                .countThreshold(1)
                .deletionWeight(1)
                .insertionWeight(1)
                .replaceWeight(1)
                .maxEditDistance(2)
                .transpositionWeight(1)
                .topK(5)
                .prefixLength(10)
                .verbosity(Verbosity.ALL).build();

        DataHolder dataHolder = new InMemoryDataHolder(spellCheckSettings, new Murmur3HashFunction());

        StringDistance weightedDamerauLevenshteinDistance =
                new WeightedDamerauLevenshteinDistance(
                        spellCheckSettings.getDeletionWeight(),
                        spellCheckSettings.getInsertionWeight(),
                        spellCheckSettings.getReplaceWeight(),
                        spellCheckSettings.getTranspositionWeight(),
                        new QwertyDistance());

        

        return new ResponseEntity<>(resultMap, status);
    }
}
