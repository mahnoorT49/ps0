/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }
    
    /**
     * Your own code can always be used, even if it is not public.
     */
    @Test
    public void testOwnCodeAlwaysAllowed() {
        assertTrue("Expected true: code written by yourself",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, false, true));
    }
    
    /**
     * Public code cannot be used if the source is not cited.
     */
    @Test
    public void testUncitedPublicCodeNotAllowed() {
        assertFalse("Expected false: public code without citation",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
    }

    /**
     * Code from a private source cannot be used even if it is cited.
     */
    @Test
    public void testPrivateCodeNotAllowed() {
        assertFalse("Expected false: code that is not publicly available",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, false));
    }
}
