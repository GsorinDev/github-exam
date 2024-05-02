package com.siplify.exam;

import com.siplify.exam.controllers.DemoMVCController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest
public class TestDemoMVCController {
    @Test
    public void TestDisplayMessage() throws Exception
    {
        DemoMVCController controller = new DemoMVCController();

        assertEquals("Hello Ynov", controller.displayMessage());
    }
}
