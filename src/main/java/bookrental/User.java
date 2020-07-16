package bookrental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="User_table")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String userName;
    private Date regTime;
    private Long rentalId;
    private String birth;
    private String sex;
	private String emailAddress;
    private String phoneNumber;

    public User(){
        Date date = new Date();
        this.regTime = new Timestamp(date.getTime());
        System.out.println("regTime!! : " + this.regTime);
    }
    @PostPersist
    public void onPostPersist(){
        UserRegistered userRegistered = new UserRegistered();
        BeanUtils.copyProperties(this, userRegistered);
        userRegistered.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Date getRegTime() {
        return regTime;
    }
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Long getRentalId() {
        return rentalId;
    }
    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public String getBirth() { return birth; }
    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() { return sex; }
    public void setSex(String sex) {
        this.sex = sex;
    }

	public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




}
