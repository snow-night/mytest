package dailytest.springjunit;

import com.example.controller.TestQualifierController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestQualifier {

    @Autowired
    private TestQualifierController testQualifierController;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void testQualifier() throws Exception {

//        ResultActions perform = this.mockMvc.perform(MockMvcRequestBuilders.post("/getName").contentType(MediaType.APPLICATION_JSON).content("")).andExpect(status().isOk()).andDo(print());
//        MvcResult mvcResult = perform.andReturn();
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        System.out.println(contentAsString);

        String testqua = testQualifierController.testqua();
        System.out.println(testqua);


    }
}
