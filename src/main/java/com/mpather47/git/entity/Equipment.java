package com.mpather47.git.entity;

public class Equipment {
    private String equipment;
    private String name;
    private String desc;
    private int quantity;
    private Room details;


    public Equipment(Builder b){
        this.equipment = b.equipment;
        this.name = b.name;
        this.desc = b.desc;
        this.quantity = b.quantity;
        this.details = b.details;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
    public int getQuantity() {
        return quantity;
    }
    public Room getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipment='" + equipment + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", quantity=" + quantity +
                ", room=" + details +
                '}';
    }

    public static class Builder{
        private String equipment;
        private String name;
        private String desc;
        private int quantity;
        private Room details;

        public Builder setEquipment(String equipment) {
            this.equipment = equipment;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setDetails(Room details){
            this.details = details;
            return this;
        }
        public Builder copy(Equipment e){
            this.equipment = e.equipment;
            this.name = e.name;
            this.desc = e.desc;
            this.quantity = e.quantity;
            this.details = e.details;
            return this;
        }

        public Equipment build(){
            return new Equipment(this);
        }
    }
}
