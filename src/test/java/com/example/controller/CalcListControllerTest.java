package com.example.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.form.BaseDateForm;

@SpringBootTest
class CalcListControllerTest extends CalcListController {

	//MockMVCオブジェクトの生成 
	private MockMvc sut;
	
	//test対象オブジェクトの生成
	@Autowired
	private CalcListController target;	 
	
	//前処理
	@BeforeEach
	public void setup() throws Exception {
		//MockMVCにテスト対象クラスを設定
		sut = MockMvcBuilders.standaloneSetup(target).build();
	}
	

	@Test
	public void GETリクエストでHTTPステータス200が返りviewとしてlistが返ることのテスト() throws Exception {
		sut.perform(get("/calc"))
		   //HTTPステータスが200：OKとなること
		   .andExpect(status().isOk())
		   //viewとしてlistが返ってくること
		   .andExpect(view().name("list"));
	}

	//GETリクエスト時にModelに「本日日付」が与えられていることのテスト
	@Test
	public void GETリクエストでBaseDateFormに本日日付が初期値でセットされていることのテスト() throws Exception {
		MvcResult result = sut.perform(get("/calc"))
				              .andReturn();	
		
		//modelに詰められたbaseDateFormの値を取得
		BaseDateForm form = (BaseDateForm) result.getModelAndView().getModel().get("baseDateForm");
		//本日日付と一致することを検証
		assertEquals( form.getBaseDate(), LocalDate.now() );
	}
	
	
//	@Test
//	void testPostCalcResult() {
//		fail("まだ実装されていません");
//	}
//
//	@Test
//	void testPostDelete() {
//		fail("まだ実装されていません");
//	}

}
