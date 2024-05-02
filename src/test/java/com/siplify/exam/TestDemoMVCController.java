package com.siplify.exam;

import com.siplify.exam.controllers.DemoMVCController;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class TestDemoMVCController {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void TestDisplayMessage() throws Exception
    {
        DemoMVCController controller = new DemoMVCController();

        assertEquals("Hello Ynov", controller.displayMessage());
    }

    @Test
    public void Test_info() throws Exception
    {
        this.mockMvc.perform(get("/ynov")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Ynov")));
    }
}
