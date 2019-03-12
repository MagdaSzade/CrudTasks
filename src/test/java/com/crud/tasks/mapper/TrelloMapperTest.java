package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloMapperTest {
    private TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void testMapToList() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("test id1", "test name1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("test id2", "test name2", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("test id3", "test name3", false);
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(trelloListDto1);
        trelloListsDto.add(trelloListDto2);
        trelloListsDto.add(trelloListDto3);
        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListsDto);
        //Then
        Assert.assertEquals(3, trelloList.size());
        Assert.assertEquals("test id1", trelloList.get(0).getId());
        Assert.assertEquals("test name2", trelloList.get(1).getName());
        Assert.assertEquals(false, trelloList.get(2).isClosed());
    }

    @Test
    public void testMapToListZeroSize() {
        //Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListsDto);
        //Then
        Assert.assertEquals(0, trelloList.size());
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("test id1", "test name1", false);
        TrelloList trelloList2 = new TrelloList("test id2", "test name2", false);
        TrelloList trelloList3 = new TrelloList("test id3", "test name3", false);
        List<TrelloList> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(trelloList1);
        trelloListsDto.add(trelloList2);
        trelloListsDto.add(trelloList3);
        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloListsDto);
        //Then
        Assert.assertEquals(3, trelloListDtos.size());
        Assert.assertEquals("test id1", trelloListDtos.get(0).getId());
        Assert.assertEquals("test name2", trelloListDtos.get(1).getName());
        Assert.assertEquals(false, trelloListDtos.get(2).isClosed());
    }

    @Test
    public void testMapToListDtoZeroSize() {
        //Given
        List<TrelloList> trelloListsDto = new ArrayList<>();
        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloListsDto);
        //Then
        Assert.assertEquals(0, trelloListDtos.size());
    }

    @Test
    public void testMapToBoards() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("test id1", "test name1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("test id2", "test name2", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("test id3", "test name3", false);
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(trelloListDto1);
        trelloListsDto.add(trelloListDto2);
        trelloListsDto.add(trelloListDto3);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("test id1","test name1",  trelloListsDto);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("test id2","test name2",  trelloListsDto);
        TrelloBoardDto trelloBoardDto3 = new TrelloBoardDto("test id3", "test name3",  trelloListsDto);
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(trelloBoardDto1);
        trelloBoardsDto.add(trelloBoardDto2);
        trelloBoardsDto.add(trelloBoardDto3);
        //When
        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoards(trelloBoardsDto);
        //Then
        Assert.assertEquals(3, trelloBoard.size());
        Assert.assertEquals("test name1", trelloBoard.get(0).getName());
        Assert.assertEquals("test id3", trelloBoard.get(2).getId());
        Assert.assertEquals(3, trelloBoard.get(1).getLists().size());
    }

    @Test
    public void testMapToBoardsZeroSize() {
        //Given
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        //When
        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoards(trelloBoardsDto);
        //Then
        Assert.assertEquals(0, trelloBoard.size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("test id1", "test name1", false);
        TrelloList trelloList2 = new TrelloList("test id2", "test name2", false);
        TrelloList trelloList3 = new TrelloList("test id3", "test name3", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);
        trelloLists.add(trelloList3);
        TrelloBoard trelloBoard1 = new TrelloBoard("test id1","test name1",  trelloLists);
        TrelloBoard trelloBoard2 = new TrelloBoard("test id2","test name2",  trelloLists);
        TrelloBoard trelloBoard3 = new TrelloBoard("test id3","test name3",  trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);
        trelloBoards.add(trelloBoard3);
        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);
        //Then
        Assert.assertEquals(3, trelloBoardsDto.size());
        Assert.assertEquals("test name1", trelloBoardsDto.get(0).getName());
        Assert.assertEquals("test id3", trelloBoardsDto.get(2).getId());
        Assert.assertEquals(3, trelloBoardsDto.get(1).getLists().size());
    }

    @Test
    public void testMapToBoardsDtoZeroSize() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);
        //Then
        Assert.assertEquals(0, trelloBoardsDto.size());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test name", "test description", "test pos", "test listId");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        Assert.assertEquals("test name", trelloCardDto.getName());
        Assert.assertEquals("test description", trelloCardDto.getDescription());
        Assert.assertEquals("test pos", trelloCardDto.getPos());
        Assert.assertEquals("test listId", trelloCardDto.getListId());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test name", "test description", "test pos", "test listId");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertEquals("test name", trelloCard.getName());
        Assert.assertEquals("test description", trelloCard.getDescription());
        Assert.assertEquals("test pos", trelloCard.getPos());
        Assert.assertEquals("test listId", trelloCard.getListId());
    }

}
