package br.ce.wcaquino.taskbackend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;
    
    @InjectMocks
    private TaskController controller;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvarSemDescricao() {
        Task task = new Task();
        task.setDueDate(LocalDate.now());
        try {
            controller.save(task);
            Assertions.fail("Não pode chegar aqui");
        } catch (ValidationException e) {
            assertEquals("Fill the task description", e.getMessage());
        }
    }
    
    @Test
    public void testSalvar() throws ValidationException{
        Task task = new Task();
        task.setTask("Descrição");
        task.setDueDate(LocalDate.now());
        controller.save(task);
        Mockito.verify(taskRepo).save(task);
    }
}
