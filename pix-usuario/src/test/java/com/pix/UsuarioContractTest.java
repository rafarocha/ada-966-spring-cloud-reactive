package com.pix;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@AutoConfigureJson
@AutoConfigureStubRunner(ids = "com.pix.usuarios:usuarios:+:stubs:8085", stubsMode = StubRunnerProperties.StubsMode.LOCAL, deleteStubsAfterTest = true)
@TestPropertySource(locations = "classpath:application-test.properties")
@RunWith(SpringRunner.class) // usuarios-0.0.1-SNAPSHOT-stubs
@AutoConfigureMessageVerifier
public class UsuarioContractTest {



}
