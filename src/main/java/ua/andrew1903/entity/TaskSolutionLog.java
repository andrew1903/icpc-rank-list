package ua.andrew1903.entity;

import java.util.ArrayList;
import java.util.List;

public class TaskSolutionLog {
    private final List<Solution> solutionList;

    public TaskSolutionLog() {
        this.solutionList = new ArrayList<>();
    }

    public int addSolution(Solution solution) {
        int penalty = 0;
        var attempts = solutionList.size();
        if (solution.isCorrect() && !isCompleted()) {
            penalty = calculatePoints(solution, attempts);
        }
        solutionList.add(solution);
        return penalty;
    }

    private boolean isCompleted() {
        return solutionList.stream()
                .anyMatch(Solution::isCorrect);
    }

    public int calculatePoints(Solution solution, long attempts) {
        if (attempts == 0) {
            return solution.getTime();
        }
        return (int) attempts * 20 + solution.getTime();
    }
}
