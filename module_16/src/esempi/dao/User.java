package esempi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

public class User implements Comparable<User> {

    private Integer id;
    private String name;
    private String lastName;
    private LocalDate birthDate;

    public User(String name, String lastName, LocalDate birthDate) {
        this(null, name, lastName, birthDate);
    }

    public User(Integer id, String name, String lastName, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    /*
    * Variante: un metodo che torna una Collection di User
    * */
    public static User fromResultSet(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"),
                   rs.getString("name"),
                   rs.getString("lastname"),
                   LocalDate.parse(rs.getString("birthdate")));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


    @Override
    public int compareTo(User user) {
        return this.id.compareTo(user.id);
    }

    /* Equals potrebbe essere anche solo su id oppure solo su nome e cognome */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && name.equals(user.name) && lastName.equals(user.lastName);
    }

    @Override
    public int hashCode() { return Objects.hash(id, name, lastName); }

}
