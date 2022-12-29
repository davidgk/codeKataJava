package org.codekata.blanck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;
    @BeforeEach
    public void beforeEach(){
        solution = new Solution();
    }
    @Test
    void execute_SunnyScenario() throws Exception {
        assertEquals(solution.execute(1), 2);
    }

    @Test
    void execute_FailScenario(){
        Exception thrown = assertThrows(
                Exception.class,
                () -> solution.execute(0),
                "Expected solution() to throw, but it didn't"
        );

        assertTrue(thrown.getMessage().contentEquals("Wrong"));
    }


}