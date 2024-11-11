package org.hbrs.se1.ws24.exercises.uebung4.prototype;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserStoryView {

    public static void dump(List<UserStory> userStories) {
        dump(userStories, null, null);
    }

    public static void dump(List<UserStory> userStories, String filterCriteria, String filterValue) {
        if (userStories.isEmpty()) {
            System.out.println("Keine User Story gefunden!");
        } else {
            System.out.printf("%-10s %-20s %-20s %-15s %-15s%n",
                    "ID", "Titel", "Akzeptanzkriterium", "Projekt", "Priorität");

            String result = userStories.stream()
                    .filter(story -> {
                        if (filterCriteria != null && filterValue != null) {
                            String value = filterValue.toLowerCase();
                            return switch (filterCriteria.toLowerCase()) {
                                case "projekt" -> story.getProject().equalsIgnoreCase(value);
                                case "id" -> story.getId().toString().equals(value);
                                case "titel" -> story.getTitel().toLowerCase().contains(value);
                                case "akzeptanzkriterium" -> story.getAcceptance().toLowerCase().contains(value);
                                case "priorität" -> story.getPriority() == Double.parseDouble(value);
                                default -> true;
                            };
                        }
                        return true;
                    })
                    .sorted(Comparator.comparingDouble(UserStory::getPriority).reversed())
                    .map(story -> String.format("%-10s %-20s %-20s %-15s %-15.2f",
                            story.getId(), story.getTitel(), story.getAcceptance(), story.getProject(), story.getPriority()))
                    .collect(Collectors.joining("\n"));
            System.out.println(result);
        }
    }

}
