package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTest {
    @InjectMocks
    TrelloValidator trelloValidator;

    @Test
    public void testValidateCardTesting() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test name", "test description", "test pos", "test listId");
        //When
        trelloValidator.validateCard(trelloCard);
        //Then do nothing
    }

    @Test
    public void testValidateCard() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name", "description", "pos", "listId");
        //When
        trelloValidator.validateCard(trelloCard);
        //Then do nothing
    }

    @Test
    public void testValidateTrelloBoard() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("test id", "test name", false));
        List<TrelloList> trelloLists1 = new ArrayList<>();
        trelloLists.add(new TrelloList("id", "name", false));
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("id", "name", trelloLists1));
        trelloBoards.add(new TrelloBoard("test id", "test", trelloLists));
        //When
        List<TrelloBoard> validatedTrelloBoards = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        Assert.assertEquals(1, validatedTrelloBoards.size());
    }

}