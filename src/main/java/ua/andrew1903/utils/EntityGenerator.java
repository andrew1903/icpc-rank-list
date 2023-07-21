package ua.andrew1903.utils;

import ua.andrew1903.entity.Task;
import ua.andrew1903.entity.TeamResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EntityGenerator {
    public static List<TeamResult> generateTeams(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(index -> new TeamResult("TEAM #" + index))
                .collect(Collectors.toList());
    }

    public static List<Task> generateTask(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(index -> new Task(index, String.valueOf(index)))
                .collect(Collectors.toList());
    }
}
