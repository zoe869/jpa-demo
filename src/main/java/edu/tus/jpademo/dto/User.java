package edu.tus.jpademo.dto;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "user_detail_id")
  //  @Transient
    private UserDetail userDetail;


    public User()
    {
    }

    public User(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public UserDetail getUserDetail()
    {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail)
    {
        this.userDetail = userDetail;
    }
}
