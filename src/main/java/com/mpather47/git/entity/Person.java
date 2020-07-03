package com.mpather47.git.entity;

public class Person {
    private int personId;
    private String name;
    private String dateOfBirth;

    public Person(Builder builder) {
        this.personId = personId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    private Person(){
    }

    public int getPersonId()
    {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", fName='" + name + '\'' +
                ", date=" + dateOfBirth +
                '}';
    }

    public static class Builder{
        private int personId;
        private String name;
        private String dateOfBirth;

        public Builder setPersonId(int personId) {
            this.personId = personId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder copy(Person person){
            this.personId = personId;
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}

