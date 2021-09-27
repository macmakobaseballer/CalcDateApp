package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.entity.DateFormula;
import com.example.mapper.CalcMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


public class CalcServiceTest {
    

    @Mock
    private CalcMapper calcMapper;

    @InjectMocks
    private CalcService sut;

    @BeforeEach
    public void initMocks() {
        //Mockオブジェクトの初期化（=MockObjectを生成すること）（initMocks(this)はMockito3.xでは非推奨。openMocksを使う）
        MockitoAnnotations.openMocks(this);
    }

    //計算実行メソッドのテスト
    //パラメータの用意（計算年・計算月・計算日・計算基準日：それに対する期待値）
    //calculateメソッドに値を渡す(計算年・計算月・計算日（calcList）計算基準日（baseDate)
    //計算基準日に対し年月日の加減算処理を実行し、期待値通りの結果が得られること
    //加減算メソッドを実行：List <DateFormula> calculate
    @ParameterizedTest
    @CsvSource({"1,0,0,2021-09-25,2022-09-25"   //翌年
                ,"0,1,0,2021-09-25,2021-10-25"  //翌月
                ,"0,0,1,2021-09-25,2021-09-26"})//翌日

    void 計算基準日に対し年月日の加減算処理を実行し期待値通りの結果を得られること(int calcNumYear, int calcNumMonth, int calcNumDay ,LocalDate baseDate , LocalDate expected ) {
        
        List <DateFormula> testList = new ArrayList<>();

        DateFormula formula = new DateFormula();
        formula.setCalcNumYear(calcNumYear);
        formula.setCalcNumMonth(calcNumMonth);
        formula.setCalcNumDay(calcNumDay);
        testList.add(formula);

        sut.calculate(testList, baseDate);
        
        //実測値の定義
        LocalDate actual = formula.getResultDate(); 

        //比較
        assertEquals( expected , actual );
    
    }

    //全件取得メソッドのテスト
    //定義したMockオブジェクトからの戻り値を定義
        //Entityのインスタンス化(List)
        //listに追加
        //setterで値を定義（なんか上と共通処理な気もする。。）
    //テストメソッド
    //getterで値が返ってくることを確認する？？（たぶん違う気がする。。）
        //Listが返ってくることを確認する？？
    
    @Test
    void 全件取得のメソッドを実行し戻り値として一覧取得できること () throws Exception {


    }


    //1件取得メソッドのテスト
    //定義したMockオブジェクトからの戻り値を定義
    //getterとsetterで値が返ってくることを確認する？？
    //Listが返ってくることを確認する？？（←たぶんこっち）



    // 削除メソッドのテスト
    // メソッドの戻り値はない
    // Mapperクラスのメソッドを呼び出せることを確認？


    // 削除メソッドのテスト
    // メソッドの戻り値はない
    // Mapperクラスのメソッドを呼び出せることを確認？

    // @Test
    // void testDeleteFormula() {
        
    // }

    // @Test
    // void testRegisterFormula() {

    // }

    // @Test
    // void testUpdateFormula() {

    // }

}

