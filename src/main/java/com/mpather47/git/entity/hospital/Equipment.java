package com.mpather47.git.entity.hospital;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Equipment {
    @Id
    private String equipmentId;
    private String name;
    private String description;
    private int quantity;
    private String details;

    protected Equipment(){

    }

    private Equipment(Builder b){
        this.equipmentId = b.equipment;
        this.name = b.name;
        this.description = b.desc;
        this.quantity = b.quantity;
        this.details = b.details;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipment='" + equipmentId + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + description + '\'' +
                ", quantity=" + quantity +
                ", room=" + details +
                '}';
    }

    public static class Builder{
        private String equipment;
        private String name;
        private String desc;
        private int quantity;
        private String details;

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

        public Builder setDetails(String details){
            this.details = details;
            return this;
        }
        public Builder copy(Equipment e){
            this.equipment = e.equipmentId;
            this.name = e.name;
            this.desc = e.description;
            this.quantity = e.quantity;
            this.details = e.details;
            return this;
        }

        public Equipment build(){
            return new Equipment(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return equipmentId.equals(equipment.equipmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentId);
    }
}
