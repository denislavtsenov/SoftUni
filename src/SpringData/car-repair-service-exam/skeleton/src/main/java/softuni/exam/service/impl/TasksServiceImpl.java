package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskImportDto;
import softuni.exam.models.dto.TaskViewDto;
import softuni.exam.models.dto.TaskWrapperDto;
import softuni.exam.models.entity.*;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.ThreadContext.isEmpty;
import static softuni.exam.models.Constants.*;

@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    private TasksRepository tasksRepository;
    private PartsRepository partsRepository;
    private CarsRepository carsRepository;
    private MechanicsRepository mechanicsRepository;
    private XmlParser xmlParser;
    private ModelMapper modelMapper;
    private ValidationUtil validationUtil;

    public TasksServiceImpl(TasksRepository tasksRepository, PartsRepository partsRepository,
                            CarsRepository carsRepository, MechanicsRepository mechanicsRepository,
                            XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.tasksRepository = tasksRepository;
        this.partsRepository = partsRepository;
        this.carsRepository = carsRepository;
        this.mechanicsRepository = mechanicsRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        List<TaskImportDto> tasks = this.xmlParser.fromFile(TASKS_FILE_PATH, TaskWrapperDto.class)
                .getTasks();

        for (TaskImportDto task : tasks) {
            stringBuilder.append(System.lineSeparator());

            Optional<Mechanic> mechanic = mechanicsRepository.findFirstByFirstName(task.getMechanic().getFirstName());
            Optional<Car> car = carsRepository.findById(task.getCar().getId());
            Optional<Part> part = partsRepository.findById(task.getPart().getId());


            if (mechanic.isEmpty()
                    || car.isEmpty()
                    || !this.validationUtil.isValid(task)) {

                stringBuilder.append(String.format(INVALID_FORMAT, TASK));
                continue;
            }

            Task taskToSave = this.modelMapper.map(task, Task.class);
            taskToSave.setMechanic(mechanic.get());
            taskToSave.setCar(car.get());
            taskToSave.setPart(part.get());

            this.tasksRepository.save(taskToSave);

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT, TASK,
                    task.getPrice().setScale(2),
                    "").trim());
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        return tasksRepository.findAllByCarCarTypeOrderByPriceDesc(CarType.coupe)
                .stream()
                .map(task -> this.modelMapper.map(task, TaskViewDto.class))
                .map(TaskViewDto::toString)
                .collect(Collectors.joining())
                .trim();
    }
}
