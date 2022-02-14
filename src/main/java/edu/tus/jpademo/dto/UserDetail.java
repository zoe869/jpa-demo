package edu.tus.jpademo.dto;

import javax.persistence.*;

@Entity
@Table(name = "user_detail")
public class UserDetail
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String email;
    private int age;

    public UserDetail()
    {
    }

    public UserDetail(String email, int age)
    {
        this.email = email;
        this.age = age;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
