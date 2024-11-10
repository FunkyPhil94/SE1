package org.hbrs.se1.ws24.exercises.uebung2;

import org.hbrs.se1.ws24.exercises.uebung2.Member;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<Member> list = new ArrayList <Member>();

    public void addMember(Member member) throws ContainerException{
        if (list.contains(member) == true) {
            throw new ContainerException(member.getID().toString());
        }

        list.add(member);
    }

    public String deleteMember(Integer id) {
        if (list.isEmpty()) {
            return "Keine Member in der Liste";
        }
        for (Member member:list) {
            if (member.getID().equals(id)) {
                list.remove(member);
                return "Member mit id " +  id + " gelöscht";
            }
        }
        return "Keine Member mit der ID vorhanden";
    }

    public void dump(){
        for (Member member:list) {
            System.out.println("Member ID( = " + member.getID().toString() + ")");
        }
    }

    public Integer size() {
        return list.size();
    }

}
