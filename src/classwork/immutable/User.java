package classwork.immutable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class User {
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final List<String> languageList;

    public User(String name, String surname, String email, String password, List<String> languageList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.languageList = new ArrayList<>(languageList);

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getLanguageList() {
        return new ArrayList<>(languageList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(surname, user.surname)) return false;
        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(password, user.password)) return false;
        return Objects.equals(languageList, user.languageList);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (languageList != null ? languageList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", languageList=" + languageList +
                '}';
    }
}
