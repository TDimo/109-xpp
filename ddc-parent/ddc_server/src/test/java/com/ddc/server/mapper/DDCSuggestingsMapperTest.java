package com.ddc.server.mapper;

import com.ddc.server.entity.DdcSuggestings;
import org.junit.Test;

import javax.annotation.Resource;

public class DDCSuggestingsMapperTest extends BaseTest {
    @Resource
    private DDCSuggestingsMapper suggestingsMapper;

    @Test
    public void testInsert() {

        for (int i = 0; i < 100; i++) {
            DdcSuggestings suggestings = new DdcSuggestings("user"+i, 2, "13412341234", "hello@qq.cm",
                    "", 1, "hello ddc", 0L, 0L);
            suggestingsMapper.insert(suggestings);
        }
    }
}