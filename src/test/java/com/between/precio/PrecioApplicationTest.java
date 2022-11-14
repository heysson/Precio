package com.between.precio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
@RunWith( SpringJUnit4ClassRunner.class )
public class PrecioApplicationTest {


@Autowired
  private MockMvc mvc;

  @Test
  public void testprices_14_1000() throws Exception {
    Object response = mvc
        .perform(get("/api/prices/2020-06-14_1000/35455/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)));
  }

  @Test
  public void testprices_14_1600() throws Exception {
    Object response = mvc
        .perform(get("/api/prices/2020-06-14_1600/35455/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
  }

  @Test
  public void testprices_14_2100() throws Exception {
    Object response = mvc
        .perform(get("/api/prices/2020-06-14_2100/35455/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)));
  }

  @Test
  public void testprices_15_1000() throws Exception {
    Object response = mvc
        .perform(get("/api/prices/2020-06-15_1000/35455/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
  }

  @Test
  public void testprices_16_2100() throws Exception {
    Object response = mvc
        .perform(get("/api/prices/2020-06-16_2100/35455/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
  }
}
