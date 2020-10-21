package com.mpather47.git.entity.hospital;

public class Ward {
    private int wardId;
    private int wardSize;

    public Ward(){}
    public Ward(WardBuilder wardBuilder){
        this.wardId = wardBuilder.wardId;
        this.wardSize = wardBuilder.wardSize;
    }

    public int getWardId() {
        return wardId;
    }

    public int getWardSize() {
        return wardSize;
    }

    public String toString() {
        return "Ward{" +
                "wardId=" + wardId +
                ", wardSize=" + wardSize +
                '}';
    }

    public static class WardBuilder{
        private int wardId;
        private int wardSize;

        public WardBuilder(){}

        public WardBuilder setWardId(int wardId) {
            this.wardId = wardId;
            return this;
        }

        public WardBuilder setWardSize(int wardSize) {
            this.wardSize = wardSize;
            return this;
        }

        public Ward build(){
            return new Ward(this);
        }

        public WardBuilder copy(Ward ward){
            this.wardId = ward.wardId;
            this.wardSize = ward.wardSize;
            return this;
        }

    }

}
