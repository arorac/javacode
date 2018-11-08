package com.crossover.techtrial.controller;

import com.crossover.techtrial.model.HourlyElectricity;
import com.crossover.techtrial.model.Panel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;


/**
 * PanelControllerTest class will test all APIs in PanelController.java.
 * @author Crossover
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PanelControllerTest {
  
  MockMvc mockMvc;
  
  @Mock
  private PanelController panelController;
  
  @Autowired
  private TestRestTemplate template;

  @Before
  public void setup() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(panelController).build();
  }

  @Test
  public void testPanelShouldBeRegistered() throws Exception {
    HttpEntity<Object> panel = getHttpEntity(
        "{\"serial\": \"232323\", \"longitude\": \"54.123232\"," 
            + " \"latitude\": \"54.123232\",\"brand\":\"tesla\" }");
    ResponseEntity<Panel> response = template.postForEntity(
        "/api/register", panel, Panel.class);
    Assert.assertEquals(400,response.getStatusCode().value());
  }
  
  @Test
  public void testPanelShouldBeRegistered_length_ok() throws Exception {
	    HttpEntity<Object> panel = getHttpEntity(
	        "{\"serial\": \"2323231234567890\", \"longitude\": \"54.123232\"," 
	            + " \"latitude\": \"54.123232\",\"brand\":\"tesla\" }");
	    ResponseEntity<Panel> response = template.postForEntity(
	        "/api/register", panel, Panel.class);
	    Assert.assertEquals(202,response.getStatusCode().value());
	  }
  
  
  @Test
  public void testPanelSaveHourlyElectricity() throws Exception{
	  
	  HttpEntity<Object> hourly_elec = getHttpEntity(
		        "{ \"panel\": {\"id\": 8, \"serial\": \"2323231234567890\", \"longitude\": \"54.123232\", \"latitude\": \"54.123232\",\"brand\":\"tesla\"}, \"generatedElectricity\": \"200\", \"readingAt\": \"2018-10-31T23:13:00\" }");
		    ResponseEntity<HourlyElectricity> response = template.postForEntity(
		        "/api/panels/8/hourly", hourly_elec, HourlyElectricity.class);
		    Assert.assertEquals(200,response.getStatusCode().value());
	  /*
	   * 
	   * panel: {\"serial\": \"2323231234567890\", \"longitude\": \"54.123232\", \"latitude\": \"54.123232\",\"brand\":\"tesla\"},"
		        + ",
	   */
	  
  }


  private HttpEntity<Object> getHttpEntity(Object body) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return new HttpEntity<Object>(body, headers);
  }
}
