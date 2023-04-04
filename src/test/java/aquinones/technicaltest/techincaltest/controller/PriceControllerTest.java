package aquinones.technicaltest.techincaltest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import aquinones.technicaltest.techincaltest.model.PriceRequest;
import aquinones.technicaltest.techincaltest.model.PriceResponse;
import aquinones.technicaltest.techincaltest.service.PriceService;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PriceService priceService;

	private PriceResponse testPrice;

	private PriceRequest priceRequest;

	@BeforeEach
	public void setup() {
	}

	@Test
	public void test1() throws Exception {
		String applicationDate = "2020-06-14-10.00.00";
		priceRequest = new PriceRequest();
		priceRequest.setBrandId(1);
		priceRequest.setProductId(35455);
		priceRequest.setApplicationDate(LocalDateTime.of(2020, 6, 14, 10, 0,0));


		testPrice = new PriceResponse();
		testPrice.setProductId(35455);
		testPrice.setBrandId(1);
		testPrice.setPriceList(1);
		testPrice.setStartDate("2020-06-14-00.00.00");
		testPrice.setEndDate("2020-12-31-23.59.59");
		testPrice.setPrice(35.50f);

		when(priceService.getPriceByParams(priceRequest))
			.thenReturn(testPrice);

		mockMvc.perform(get("/api/prices")
				.param("application_date", applicationDate)
				.param("product_id", String.valueOf(testPrice.getProductId()))
				.param("brand_id", String.valueOf(testPrice.getBrandId()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.productId").value(testPrice.getProductId()))
		.andExpect(jsonPath("$.brandId").value(testPrice.getBrandId()))
		.andExpect(jsonPath("$.priceList").value(testPrice.getPriceList()))
		.andExpect(jsonPath("$.price").value(testPrice.getPrice()));
	}

	@Test
	public void test2() throws Exception {
		String applicationDate = "2020-06-14-16.00.00";
		priceRequest = new PriceRequest();
		priceRequest.setBrandId(1);
		priceRequest.setProductId(35455);
		priceRequest.setApplicationDate(LocalDateTime.of(2020, 6, 14, 16, 0,0));


		testPrice = new PriceResponse();
		testPrice.setProductId(35455);
		testPrice.setBrandId(1);
		testPrice.setPriceList(2);
		testPrice.setStartDate("2020-06-14-15.00.00");
		testPrice.setEndDate("2020-06-14-18.30.00");
		testPrice.setPrice(25.45f);

		when(priceService.getPriceByParams(priceRequest))
			.thenReturn(testPrice);

		mockMvc.perform(get("/api/prices")
				.param("application_date", applicationDate)
				.param("product_id", String.valueOf(testPrice.getProductId()))
				.param("brand_id", String.valueOf(testPrice.getBrandId()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.productId").value(testPrice.getProductId()))
		.andExpect(jsonPath("$.brandId").value(testPrice.getBrandId()))
		.andExpect(jsonPath("$.priceList").value(testPrice.getPriceList()))
		.andExpect(jsonPath("$.price").value(testPrice.getPrice()));
	}

	@Test
	public void test3() throws Exception {
		String applicationDate = "2020-06-14-21.00.00";
		priceRequest = new PriceRequest();
		priceRequest.setBrandId(1);
		priceRequest.setProductId(35455);
		priceRequest.setApplicationDate(LocalDateTime.of(2020, 6, 14, 21, 0,0));


		testPrice = new PriceResponse();
		testPrice.setProductId(35455);
		testPrice.setBrandId(1);
		testPrice.setPriceList(1);
		testPrice.setPriority(0);
		testPrice.setStartDate("2020-06-14-00.00.00");
		testPrice.setEndDate("2020-12-31-23.59.59");
		testPrice.setPrice(35.50f);

		when(priceService.getPriceByParams(priceRequest))
			.thenReturn(testPrice);

		mockMvc.perform(get("/api/prices")
				.param("application_date", applicationDate)
				.param("product_id", String.valueOf(testPrice.getProductId()))
				.param("brand_id", String.valueOf(testPrice.getBrandId()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.productId").value(testPrice.getProductId()))
		.andExpect(jsonPath("$.brandId").value(testPrice.getBrandId()))
		.andExpect(jsonPath("$.priceList").value(testPrice.getPriceList()))
		.andExpect(jsonPath("$.price").value(testPrice.getPrice()));
	}

	@Test
	public void test4() throws Exception {
		String applicationDate = "2020-06-15-10.00.00";
		priceRequest = new PriceRequest();
		priceRequest.setBrandId(1);
		priceRequest.setProductId(35455);
		priceRequest.setApplicationDate(LocalDateTime.of(2020, 6, 15, 10, 0,0));

		testPrice = new PriceResponse();
		testPrice.setProductId(35455);
		testPrice.setBrandId(1);
		testPrice.setPriceList(4);
		testPrice.setPriority(1);
		testPrice.setStartDate("2020-06-15-00.00.00");
		testPrice.setEndDate("2020-12-31-11.00.00");
		testPrice.setPrice(30.50f);

		when(priceService.getPriceByParams(priceRequest))
			.thenReturn(testPrice);

		mockMvc.perform(get("/api/prices")
				.param("application_date", applicationDate)
				.param("product_id", String.valueOf(testPrice.getProductId()))
				.param("brand_id", String.valueOf(testPrice.getBrandId()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.productId").value(testPrice.getProductId()))
		.andExpect(jsonPath("$.brandId").value(testPrice.getBrandId()))
		.andExpect(jsonPath("$.priceList").value(testPrice.getPriceList()))
		.andExpect(jsonPath("$.price").value(testPrice.getPrice()));
	}

	@Test
	public void test5() throws Exception {
		String applicationDate = "2020-06-16-21.00.00";
		priceRequest = new PriceRequest();
		priceRequest.setBrandId(1);
		priceRequest.setProductId(35455);
		priceRequest.setApplicationDate(LocalDateTime.of(2020, 6, 16, 21, 0,0));

		testPrice = new PriceResponse();
		testPrice.setProductId(35455);
		testPrice.setBrandId(1);
		testPrice.setPriceList(4);
		testPrice.setPriority(1);
		testPrice.setStartDate("2020-06-15-16.00.00");
		testPrice.setEndDate("2020-12-31-23.59.59");
		testPrice.setPrice(38.95f);

		when(priceService.getPriceByParams(priceRequest))
			.thenReturn(testPrice);

		mockMvc.perform(get("/api/prices")
				.param("application_date", applicationDate)
				.param("product_id", String.valueOf(testPrice.getProductId()))
				.param("brand_id", String.valueOf(testPrice.getBrandId()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.productId").value(testPrice.getProductId()))
		.andExpect(jsonPath("$.brandId").value(testPrice.getBrandId()))
		.andExpect(jsonPath("$.priceList").value(testPrice.getPriceList()))
		.andExpect(jsonPath("$.price").value(testPrice.getPrice()));
	}

}