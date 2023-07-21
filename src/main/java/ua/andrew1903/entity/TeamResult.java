package ua.andrew1903.entity;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TeamResult implements Comparable<TeamResult> {
    private final String name;
    private int solved;
    private int totalTime;
    private final Map<Task, TaskSolutionLog> tasks;

    public TeamResult(String name) {
        this.name = name;
        this.tasks = new HashMap<>();
    }

    public int addSolution(Task task, Solution solution) {
        tasks.putIfAbsent(task, new TaskSolutionLog());
        return tasks.get(task).addSolution(solution);
    }

    @Override
    public int compareTo(TeamResult t) {
        return Comparator.comparing(TeamResult::getSolved)
                .thenComparing(TeamResult::getTotalTime, Comparator.reverseOrder())
                .compare(t, this);
    }

    public String print(int position) {
        return String.format(
                "%d | %s |    %d   |      %d     ",
                position, name, solved, totalTime
        );
    }

    public String getName() {
        return name;
    }

    public int getSolved() {
        return solved;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void update(int result) {
        if (result > 0) {
            totalTime += result;
            solved++;
        }
    }
}
