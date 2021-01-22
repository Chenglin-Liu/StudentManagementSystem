package bean;

public class Student {

    private int id;

    private String name;

    private String gender;

    private String[] stream;

    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String[] getStream() {
        return stream;
    }

    public void setStream(String[] stream){
        this.stream = stream;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
