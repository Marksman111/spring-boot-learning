package com.marksman;

import com.marksman.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author weilb
 * @date 2018/8/28
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTests {

    @Autowired
    private MockMvc mvc;

   @Before
   public void setUp(){
       mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
   }

   @Test
   public void getHello(){

   }
}
