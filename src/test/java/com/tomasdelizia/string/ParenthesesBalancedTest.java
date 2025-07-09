package com.tomasdelizia.string;

import com.tomasdelizia.stack.problem.ParenthesesBalanced;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParenthesesBalancedTest {
    @Test
    void testParenthesesBalanced() {
        assertTrue(ParenthesesBalanced.parentheseseBalanced("()"));
        assertTrue(ParenthesesBalanced.parentheseseBalanced("(())"));
        assertTrue(ParenthesesBalanced.parentheseseBalanced("(()())"));
        assertFalse(ParenthesesBalanced.parentheseseBalanced(")("));
        assertFalse(ParenthesesBalanced.parentheseseBalanced("(()"));
        assertFalse(ParenthesesBalanced.parentheseseBalanced("())"));
        assertFalse(ParenthesesBalanced.parentheseseBalanced("((()))("));
    }

    @Test
    void testParenthesesBalancedWithOneForLoop() {
        assertTrue(ParenthesesBalanced.parentheseseBalancedOneFor("()"));
        assertTrue(ParenthesesBalanced.parentheseseBalancedOneFor("(())"));
        assertTrue(ParenthesesBalanced.parentheseseBalancedOneFor("(()())"));
        assertFalse(ParenthesesBalanced.parentheseseBalancedOneFor(")("));
        assertFalse(ParenthesesBalanced.parentheseseBalancedOneFor("(()"));
        assertFalse(ParenthesesBalanced.parentheseseBalancedOneFor("())"));
        assertFalse(ParenthesesBalanced.parentheseseBalancedOneFor("((()))("));
    }
}