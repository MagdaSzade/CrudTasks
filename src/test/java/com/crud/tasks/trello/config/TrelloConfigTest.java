package com.crud.tasks.trello.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTest {

    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void testTrelloConfigGetApiEndPoint() {
        //Then
        Assert.assertEquals("https://api.trello.com/1", trelloConfig.getTrelloApiEndpoint());
    }

    @Test
    public void testTrelloConfigGetAppToken() {
        //Then
        Assert.assertEquals("076e1e01c7f24adc8cf2649516dee7e9f41b0061962d3bea29b5090e4717846d", trelloConfig.getTrelloToken());
    }

    @Test
    public void testTrelloConfigGetUserName() {
        //Then
        Assert.assertEquals("magdalenaszade", trelloConfig.getTrelloUsername());
    }

    @Test
    public void testTrelloConfigGetAppKey() {
        //Then
        Assert.assertEquals("a6297825a2224bb810f2ba8832f3f3c9", trelloConfig.getTrelloAppKey());
    }
}