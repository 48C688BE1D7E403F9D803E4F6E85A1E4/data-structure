package com.maxwit.algorithm;

import java.util.Stack;

public class BracketMatching {

    public static Boolean matching(String ex) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < ex.length(); i++) {
            Character c = ex.charAt(i);
            if (c.equals('(') || c.equals('[') || c.equals('{'))
                st.push(c);
            else if (c.equals(')') && st.peek().equals('('))
                st.pop();
            else if (c.equals(']') && st.peek().equals('['))
                st.pop();
            else if (c.equals('}') && st.peek().equals('{'))
                st.pop();
        }

        return st.isEmpty();
    }
}
