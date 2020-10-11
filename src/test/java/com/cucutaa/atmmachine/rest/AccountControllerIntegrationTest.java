package com.cucutaa.atmmachine.rest;

import com.cucutaa.atmmachine.ContainersInitializer;
import com.cucutaa.atmmachine.dto.AccountDetailsDTO;
import com.cucutaa.atmmachine.externalService.BankServiceMock;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.util.UriComponentsBuilder;
import org.testcontainers.junit.jupiter.Testcontainers;

//import static com.cucutaa.atmmachine.ContainersInitializer.mockServerClient;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@Testcontainers
//@ContextConfiguration(initializers = {ContainersInitializer.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountControllerIntegrationTest {

//    private static BankServiceMock bankServiceMock;
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//    @BeforeAll
//    void beforeAll() {
//        bankServiceMock = new BankServiceMock(mockServerClient);
//    }
//
//    @AfterEach
//    void tearDown() {
//        mockServerClient.reset();
//    }
//
//    @Test
//    void successful_check_balance() {
//        bankServiceMock.mockCheckBalance("123", "account-details.json");
//
//        var entity = new HttpEntity<AccountDetailsDTO>(null, new HttpHeaders());
//
//        AccountDetailsDTO accountDetails = testRestTemplate
//                .exchange(UriComponentsBuilder.fromUriString("/123/checkBalance").build().toUriString(), HttpMethod.GET, entity, AccountDetailsDTO.class).getBody();
//
//        assertEquals("123", accountDetails.getAccountNo());
//    }

}
