package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TaskMapperTest {
    private TaskMapper taskMapper = new TaskMapper();

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto= new TaskDto(1L, "test title", "test content");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        Assert.assertEquals(java.util.Optional.of(1L), java.util.Optional.of(task.getId()));
        Assert.assertEquals("test title", task.getTitle());
        Assert.assertEquals("test content", task.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task= new Task(1L, "test title", "test content");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        Assert.assertEquals(java.util.Optional.of(1L), java.util.Optional.of(taskDto.getId()));
        Assert.assertEquals("test title", taskDto.getTitle());
        Assert.assertEquals("test content", taskDto.getContent());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        Task task1= new Task(1L, "test title1", "test content1");
        Task task2= new Task(2L, "test title2", "test content2");
        Task task3= new Task(3L, "test title3", "test content3");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(tasks);
        //Then
        Assert.assertEquals(3,taskDtoList.size());
        Assert.assertEquals(java.util.Optional.of(1L),java.util.Optional.of(taskDtoList.get(0).getId()));
        Assert.assertEquals("test title2",taskDtoList.get(1).getTitle());
        Assert.assertEquals("test content3",taskDtoList.get(2).getContent());
    }

    @Test
    public void testMapToTaskDtoListZeroSize() {
        //Given
        List<Task> tasks = new ArrayList<>();
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(tasks);
        //Then
        Assert.assertEquals(0,taskDtoList.size());
    }
}