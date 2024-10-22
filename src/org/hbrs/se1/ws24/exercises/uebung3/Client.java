package org.hbrs.se1.ws24.exercises.uebung3;

import org.hbrs.se1.ws24.exercises.uebung2.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung2.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung2.Member;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private List<Member> list;

    public Client(Container<Member> container) throws ContainerException {
        list = new ArrayList<>();
        for (int i = 0;i<3;i++) {
            container.addMember(new ConcreteMember(i));
        }

        List<Member> listedMember = container.getCurrentList();

        MemberView.dump(listedMember);
    }

}
