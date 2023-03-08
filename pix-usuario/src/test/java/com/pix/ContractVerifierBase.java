package com.pix;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@Ignore
@RunWith(SpringRunner.class)
@ContextConfiguration
@WebMvcTest
public class ContractVerifierBase {

    @Autowired
    private WebApplicationContext context;

//    @MockBean private UsuarioService usuarioService;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.webAppContextSetup(context);
        // criar usuario
        //when(usuarioService.getByXXX("12345")).thenReturn( usuario);
    }

}