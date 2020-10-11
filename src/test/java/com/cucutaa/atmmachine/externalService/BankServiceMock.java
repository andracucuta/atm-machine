package com.cucutaa.atmmachine.externalService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.mockserver.client.MockServerClient;
import org.springframework.core.io.ClassPathResource;

import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@RequiredArgsConstructor
public class BankServiceMock {

    private final MockServerClient mockServerClient;

    @SneakyThrows
    public void mockCheckBalance(String accountNo, String resourceFileName){
        var accountDetails = new ClassPathResource("/accounts/" + resourceFileName).getInputStream().readAllBytes();
        mockServerClient
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/rest/external/accounts/" + accountNo + "/checkBalance"),
                        exactly(1))
                .respond(
                        response()
                        .withStatusCode(200)
                        .withBody(accountDetails)
                );
    }
}
