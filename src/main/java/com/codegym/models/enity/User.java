package com.codegym.models.enity;

import com.codegym.converter.JsonConverter;
import com.codegym.models.Settings;
import com.codegym.models.enums.Gender;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.util.List;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = "User.findAll", query = "FROM User"),
                @NamedQuery(name = "User.findById", query = "FROM User u WHERE u.id = :id")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    private String lastName;

    @Formula("concat(first_name, ' ', lastName)")
    private String fullName;

    private int age;

    private long sum;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Convert(converter = JsonConverter.class)
    private Settings settings;

    @ElementCollection
    @CollectionTable(name = "user_tg_chanels", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "channel")
    private List<String> tgChanels;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private PassportInfo passportInfo;


    public User() {
    }

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public List<String> getTgChanels() {
        return tgChanels;
    }

    public void setTgChanels(List<String> tgChanels) {
        this.tgChanels = tgChanels;
    }

    public PassportInfo getPassportInfo() {
        return passportInfo;
    }

    public void setPassportInfo(PassportInfo passportInfo) {
        this.passportInfo = passportInfo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
