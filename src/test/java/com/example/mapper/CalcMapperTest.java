package com.example.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import com.example.entity.DateFormula;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class CalcMapperTest {

    //一覧を検索するテスト
    //
    @Autowired
    private CalcMapper sut;

    @Test
    public void 全件検索して結果をリストで2件取得できること () throws Exception{
        List <DateFormula> actual = sut.selectFormulas();

        assertEquals(actual.size(),3);

    }

    @Test
    void testInsertFormula() throws Exception{
        fail("未実装");
    }

    @Test
    void testSelectFormula() throws Exception{
        fail("未実装");
    }

    @Test
    void testSelectFormulas() throws Exception{
        fail("未実装");
    }

    @Test
    void testUpdateFormula() throws Exception{
        fail("未実装");
    }
}
