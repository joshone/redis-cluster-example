package cl.joshone.redisclient.model;

public class Person {
    private String name;
    private String age;
    private String phone;
    public Person() {
    }
    public Person(String name, String age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
