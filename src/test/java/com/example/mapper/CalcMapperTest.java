package com.example.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
    public void 全件検索して計算式ををDBから3件取得できること () throws Exception{
        List <DateFormula> actual = sut.selectFormulas();
        
        assertEquals(actual.size(),3);
    }

    @Test
    public void 一件検索して計算式をDBから1件取得できること () throws Exception{
        //テスト対象メソッドの呼び出し
        DateFormula actual = sut.selectFormula(1);

        //値の比較
        assertEquals(actual.getResultId(),1);
        assertEquals(actual.getCalcId(), "Y1M1");
        assertEquals(actual.getCalcNumYear(),1);
        assertEquals(actual.getCalcNumMonth(),1);
        assertEquals(actual.getCalcNumDay(),0);

    }
        
    @Test
    public void 計算式をDBに1件登録できること () throws Exception{
        //DateFormula型の変数の定義
        DateFormula formula = createFormula("Y1D1",1,0,1);
        //テスト対象メソッドの呼び出し
        sut.insertFormula(formula);

        //実測値の定義
        DateFormula actual = sut.selectFormula(4);

        //値の比較
        assertEquals(actual.getResultId(),4);
        assertEquals(actual.getCalcId(), "Y1D1");
        assertEquals(actual.getCalcNumYear(),1);
        assertEquals(actual.getCalcNumMonth(),0);
        assertEquals(actual.getCalcNumDay(),1);

    }

    @Test
    public void 計算式をDBから1件更新できること () throws Exception{
        //DateFormula型の変数の定義;
        DateFormula formula = sut.selectFormula(1);
        formula.setCalcId("Y2M2");
        formula.setCalcNumYear(2);
        formula.setCalcNumMonth(2);
        //テスト対象メソッドの実行
        sut.updateFormula(formula);

        //実測値の定義
        DateFormula actual = sut.selectFormula(1);

        //値の比較
        assertEquals(actual.getResultId(),1);
        assertEquals(actual.getCalcId(), "Y2M2");
        assertEquals(actual.getCalcNumYear(),2);
        assertEquals(actual.getCalcNumMonth(),2);
        assertEquals(actual.getCalcNumDay(),0);
    }


    @Test
    public void 計算式をDBから1件削除できること() throws Exception{
        //テスト対象メソッドの実行
        sut.deleteFormula(2);

        //実測値の定義;
        DateFormula actual = sut.selectFormula(2);

        //値の比較
        assertNull(actual);
    }

    //テストデータセット用メソッド
    private DateFormula createFormula(String calcId , int calcNumYear , int calcNumMonth , int calcNumDay ) {
        DateFormula formula = new DateFormula();
        formula.setCalcId(calcId);
        formula.setCalcNumYear(calcNumYear);
        formula.setCalcNumMonth(calcNumMonth);
        formula.setCalcNumDay(calcNumDay);
        return formula;
    }

}


