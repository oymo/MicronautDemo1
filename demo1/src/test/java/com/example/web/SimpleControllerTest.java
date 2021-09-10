package com.example.web;

import graphql.Assert;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.StreamingHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class SimpleControllerTest {

    @Client("/")
    @Inject
    StreamingHttpClient client;

    @Test
    public void testGreeting(){
        String response = client.toBlocking().retrieve("hello");
        assertEquals("Hi", response);
//        assertEquals(client.toBlocking().retrieve(HttpRequest.GET("/hello")),"Hi");
//        client.toBlocking()
//                .retrieve(HttpRequest.GET("/hello/Thomas"));
//        assertEquals("Hello Thomas!", response);
    }

}