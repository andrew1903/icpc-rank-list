package ua.andrew1903.utils;

import org.apache.commons.lang3.tuple.Pair;
import org.jooq.lambda.Seq;
import ua.andrew1903.entity.TeamResult;

import java.util.List;
import java.util.stream.IntStream;

public class TableUtils {
    public static void draw(List<TeamResult> teamResultList) {
        System.out.print(
                """
                        # |   TEAM  | SOLVED | TOTAL TIME
                        """
        );
        Seq.seq(teamResultList)
                .sorted()
                .zip(Seq.seq(IntStream.rangeClosed(1, teamResultList.size())), (v, k) -> Pair.of(k, v))
                .forEach(p -> System.out.println(p.getValue().print(p.getKey())));
    }
}
