package pojoTemplates;

public class GoRestUser {
    /**  {
     "id": 5114452,
     "name": "Balachandra Bhattacharya",
     "email": "bhattacharya_balachandra@howe.test",
     "gender": "female",
     "status": "inactive"
     }*/
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;

    public GoRestUser() {

    }

    public GoRestUser(int id, String name, String email, String gender,String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    @Override
    public String toString() {
        return "GoRestUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
