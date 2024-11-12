package org.hbrs.se1.ws24.exercises.uebung4.prototype;


import java.io.Serializable;

public class UserStory implements Serializable {

        private String project;
        private String acceptance;
        private String titel;
        private Integer id = 0;

        private Integer value;
        private Integer risk;
        private Integer effort;
        private Integer penalty;

        public String getProject() {
            return this.project;
        }

        public void setProject(String project) {
            this.project = project;
        }

        public UserStory(String project, String acceptance, String titel, Integer id, Integer value, Integer risk, Integer effort, Integer penalty) {
            this.project = project;
            this.acceptance = acceptance;
            this.titel = titel;
            this.id = id;
            this.value = value;
            this.risk = risk;
            this.effort = effort;
            this.penalty = penalty;
        }

        public UserStory() {
        }

        public String getTitel() {
            return this.titel;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAcceptance() {
            return this.acceptance;
        }

        public double getPriority() {
            return (double) (this.value + this.penalty) / (this.effort + this.risk);
        }

    }




