package Patients;

public class Patient{
    int priority;
    private int age;
    private String name;
    private String address;

    public Patient(int priority, int age, String name, String addr){
        this.priority=priority;
        this.age=age;
        this.name=name;
        this.address=addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    void details(){
        System.out.println("Priority:"+priority+"; Age:"
                            +age+"; Name:"+name+"; Address"+address);
    }
}