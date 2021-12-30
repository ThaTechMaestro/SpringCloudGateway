package com.project.cloudgatewayservice;


import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import org.springframework.test.web.reactive.server.WebTestClient;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.*;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,properties = {"httpbin=http://localhost:${wiremock.server.port}"})
@AutoConfigureWireMock(port = 0)
class CloudGatewayServiceApplicationTests {

    /**

    @Autowired
    private WebTestClient webClient;

    @Test
    public void contextLoads() throws Exception {

        stubFor(get(urlEqualTo("/delay/3"))
                .willReturn(aResponse()
                        .withBody("fallback")
                        .withFixedDelay(3000)));


        webClient
                .get().uri("/delay/3")
                .header("Host", "www.circuitbreaker.com")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(
                        response -> assertThat(response.getResponseBody()).isEqualTo("fallback".getBytes()));
    }

        **/




}
