package org.hbrs.se1.ws24.exercises.uebung3;

import org.hbrs.se1.ws24.exercises.uebung2.Member;

import java.util.List;

public class MemberView {

    public static void dump(List<? extends Member> list) {
        for (Member m : list) {
            System.out.println(m);
        }
    }

}
