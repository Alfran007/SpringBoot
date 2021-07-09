package com.crud.springboot.springBootRestH2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.crud.springboot.springBootRestH2.model.User;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class SpringBootRestH2ApplicationTests {

	@Test
	void contextLoads() {
	}
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testUser()
    {
        assertTrue(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/user/1", User.class)
                        .getId().equals(1));
    }

    @Test
    public void testAllUser() {
        assertTrue(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/user", List.class).size() == 2);
    }

}



