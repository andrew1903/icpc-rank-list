package ua.andrew1903;

import ua.andrew1903.entity.Solution;
import ua.andrew1903.entity.Task;
import ua.andrew1903.entity.TeamResult;
import ua.andrew1903.utils.EntityGenerator;
import ua.andrew1903.utils.TableUtils;

import java.util.List;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Contest {
    private final int totalTime;
    private final List<TeamResult> teamResults;
    private final List<Task> tasks;

    public Contest(int tasks, int teams, int time) {
        this.totalTime = time;
        this.teamResults = EntityGenerator.generateTeams(teams);
        this.tasks = EntityGenerator.generateTask(tasks);
    }

    public void start() {
        TableUtils.draw(teamResults);

        for (int currentTime = 0; currentTime < totalTime; currentTime++) {
            if (current().nextBoolean()) {
                var team = determineTeam();
                var currentTask = determineTask();
                System.out.println(team.getName() + " is trying to pass their solution...");
                var theirSolution = new Solution(currentTime, current().nextBoolean());
                var penalty = team.addSolution(currentTask, theirSolution);
                if (penalty > 0) {
                    System.out.printf("They get %d points!\n", penalty);
                } else {
                    System.out.println("Their solution isn`t correct!");
                }
                team.update(penalty);
            }
        }

        TableUtils.draw(teamResults);
    }

    private TeamResult determineTeam() {
        return teamResults.get(generateIntInBound(0, teamResults.size()));
    }

    private Task determineTask() {
        return tasks.get(generateIntInBound(0, tasks.size()));
    }

    private int generateIntInBound(int origin, int bound) {
        return current().nextInt(origin, bound);
    }
}
