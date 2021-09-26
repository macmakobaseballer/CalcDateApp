package com.example.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.form.BaseDateForm;
import com.example.service.CalcService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CalcListControllerTest extends CalcListController {

	//MockMVCオブジェクトの生成 
	private MockMvc sut;
	

	//ServiceクラスをMockオブジェクト化
	@Mock
	private CalcService service;

	//test対象オブジェクトの生成
	@InjectMocks
	private CalcListController target;	 
	
	//前処理
	@BeforeEach
	public void setup() throws Exception {
		//MockMVCにテスト対象クラスを設定
		sut = MockMvcBuilders.standaloneSetup(target).build();
		MockitoAnnotations.openMocks(this);
	}
	

	@Test
	public void GETリクエストでHTTPステータス200が返りviewとしてlistが返ること() throws Exception {
		sut.perform(get("/calc"))
		    //HTTPステータスが200：OKとなること
			.andExpect(status().isOk())
		    //viewとしてlistが返ってくること
			.andExpect(view().name("list"));
	}


	@Test
	public void GETリクエストで計算基準日に本日日付が初期値でセットされていること() throws Exception {
		MvcResult result = sut.perform(get("/calc"))
							.andReturn();	
		
		//modelに詰められたbaseDateFormの値を取得
		BaseDateForm form = (BaseDateForm) result.getModelAndView().getModel().get("baseDateForm");
		//本日日付と一致することを検証
		assertEquals( form.getBaseDate(), LocalDate.now() );
	}
	
	
	@Test
	public void calcページで計算基準日を入力して計算実行をクリックすると計算サービスが呼ばれること() throws Exception {
		sut.perform(post("/calc").param( "baseDate", "2021/09/26"))
				.andExpect(status().isOk())
				.andExpect(view().name("list"))
				.andExpect(model().hasNoErrors());

				
		verify(service, times(1)).calculate(any(), any());
	}

	@Test
	public void calcページで計算基準日をnullにして計算実行をクリックするとmodelがエラーとなり画面が返ること() throws Exception {
		sut.perform(post("/calc").param( "baseDate", ""))
				.andExpect(status().isOk())
				.andExpect(model().hasErrors())
				.andExpect(view().name("list"));

	}

	@Test
	public void calcページで計算基準日を不正な形式にして計算実行をクリックするとmodelがエラーとなり画面が返ること() throws Exception {
		sut.perform(post("/calc").param( "baseDate", "2021-09-20"))
				.andExpect(status().isOk())
				.andExpect(model().hasErrors())
				.andExpect(view().name("list"));

	}


	@Test
	public void 削除ボタンをクリックすると1件削除サービスが実行されリダイレクト処理がされること()throws Exception {
		sut.perform(post("/calc/delete/1").param("resultId", "1"))
			.andExpect(status().is(302))
			.andExpect(redirectedUrl("/calc"));
	}

}
