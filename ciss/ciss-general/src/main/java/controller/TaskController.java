package controller;

import domain.task.Task;
import dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TaskService;
import service.mappers.TaskMapper;

@RestController
@RequestMapping("home/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskMapper taskMapper;

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody TaskDto taskDto, @RequestBody String userId) {
        Task task = taskMapper.toEntity(taskDto);
        taskService.createTask(task, userId);
        return ResponseEntity.ok().body("Task create successfully.");
    }

    @PostMapping("/executors/add")
    public ResponseEntity<?> addExecutor(@RequestBody String executorId) {
        return ResponseEntity.ok().body("Executor added successfully.");
    }

    @PostMapping("/status/change")
    public ResponseEntity<?> changeStatus(@RequestBody String taskStatusName) {
        return ResponseEntity.ok().body("Status changed successfully");
    }
}
