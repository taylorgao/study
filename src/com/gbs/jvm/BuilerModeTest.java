package com.gbs.jvm;

public class BuilerModeTest {
    private final String name;
    private final int age;
    private final int height;
    private final int sex;

    private BuilerModeTest(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
        this.sex = builder.sex;
    };

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("name : " + name);
        sb.append(",age = " + age);
        sb.append(",sex = " + sex);
        sb.append(",height:" + height);

        return sb.toString();
    }

    public static class Builder{
        private String name;
        private int age;
        private int height;
        private int sex;

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }

        public Builder age(int age)
        {
            this.age = age;
            return this;
        }


        public Builder height(int height)
        {
            this.height = height;
            return this;
        }

        public Builder sex(int sex)
        {
            this.sex = sex;
            return this;
        }

        public BuilerModeTest build()
        {
            return new BuilerModeTest(this);
        }
    }

    public static void main(String[] args) {

        BuilerModeTest b1
                = new BuilerModeTest.Builder()
                    .name("Taylor")
                    .height(182)
                    .build();

        System.out.println(b1);
    }

}
