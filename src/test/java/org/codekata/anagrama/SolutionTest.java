package org.codekata.anagrama;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;
    private List<String> sut;
    @BeforeEach
    public void beforeEach(){
        solution = new Solution();
    }

    @Test
    void execute_SunnyScenarioEnd() throws Exception {
        sut = Arrays.asList("cats", "redraw", "tap", "dog", "pat", "acts", "drawer", "remote", "reward", "god");
        assertEquals(solution.execute(sut).size(), 5);
    }
    @Test
    void execute_SunnyScenario_SimpleCase() throws Exception {
        Set<Set<String>> result = solution.execute(Arrays.asList("cats", "acts" ));
        assertEquals(result.size(), 1);
        Set<String> strings = result.stream().findFirst().get();
        assertEquals(strings.size(), 2);
        assertTrue(strings.contains("cats"));
        assertTrue(strings.contains("acts"));
    }

    @Test
    void execute_SunnyScenario_SimpleCase02() throws Exception {
        Set<Set<String>> result = solution.execute(Arrays.asList("cats", "acts", "beds" ));
        assertEquals(result.size(), 2);
        List<Set<String>> mainList = new ArrayList<Set<String>>();
        mainList.addAll(result);
        List<String> aList01 = new ArrayList();
        aList01.addAll(mainList.get(0));
        assertEquals(aList01.size(), 2);
        assertTrue(aList01.contains("cats"));
        assertTrue(aList01.contains("acts"));
        List<String> aList02 = new ArrayList();
        aList02.addAll(mainList.get(1));
        assertEquals(aList02.size(), 1);
        assertTrue(aList02.contains("beds"));
    }

//    @Test
//    void execute_FailScenario(){
//        Exception thrown = assertThrows(
//                Exception.class,
//                () -> solution.execute(null),
//                "Expected solution() to throw, but it didn't"
//        );
//
//        assertTrue(thrown.getMessage().contentEquals("Wrong"));
//    }


}