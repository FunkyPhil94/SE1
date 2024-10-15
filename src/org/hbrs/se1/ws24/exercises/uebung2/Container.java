package org.hbrs.se1.ws24.exercises.uebung2;

import java.util.ArrayList;

public class Container {

    ArrayList<Member> MemberList = new ArrayList<>();

    public void addMember(Member member) throws ContainerException {
        if(MemberList.contains(member)) {
            throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() +  " ist bereits vorhanden!");
        } else {
            MemberList.add(member);
        }
    }

    public String deleteMember(Integer ID) {
        if (MemberList.isEmpty()) {
            return "Keine Member vorhanden!";
        }
        for (Member member : MemberList) {
            if (member.getID().equals(ID)) {
                MemberList.remove(member);
                return "Member mit der ID " + ID + " wurde entfernt: " + member.toString();
            }
        }
        return "Kein Member mit der ID vorhanden!";
    }


    public void dump(){
        MemberList.forEach(System.out::println);
    }

    public Integer size(){
        return MemberList.size();
    }

}
