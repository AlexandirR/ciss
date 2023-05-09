package service;

import domain.User;
import domain.participant.Participant;
import domain.task.Task;
import domain.task.TaskHistory;
import domain.task.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TaskHistoryRepository;
import repository.TaskRepository;
import repository.TaskStatusRepository;
import repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskStatusRepository taskStatusRepository;

    @Autowired
    private ParticipantService participantService;
    @Autowired
    private TaskHistoryRepository taskHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    public void createTask(Task task, String userApplicantId) {
        User userApplicant = userRepository.findById(userApplicantId).orElse(null);
        task.setCreateDateTime(LocalDateTime.now());
        task.setCreator(participantService.createApplicantByUser(Objects.requireNonNull(userApplicant)));
        TaskStatus statusRegistered = taskStatusRepository.findTaskStatusByName(TaskStatus.Names.REGISTERED);
        task.setTaskStatus(statusRegistered);
        addTaskHistory(task, statusRegistered, LocalDateTime.now(), task.getCreator());
        taskRepository.save(task);
    }

    private void addTaskHistory(Task task, TaskStatus status, LocalDateTime updateDateTime, Participant modifier) {
        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setTask(task);
        taskHistory.setModifier(modifier);
        taskHistory.setStatus(status);
        taskHistory.setUpdateDateTime(updateDateTime);
        task.getTaskHistories().add(taskHistory);
        taskHistoryRepository.save(taskHistory);
    }
}
