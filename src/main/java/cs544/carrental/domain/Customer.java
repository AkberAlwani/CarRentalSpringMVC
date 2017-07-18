package cs544.carrental.domain;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

import javax.validation.Valid;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import cs544.carrental.validation.EmptyOrSize;
import cs544.carrental.validation.NullMinNumber;


@Entity 
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
	
	@Column(length = 16)
	@NotEmpty
	private String firstName;
	
	@Column(length = 16)
	@EmptyOrSize(min=5, max = 9, message= "{EmptyOrSize}")
	private String lastName;

	@Column(unique = true)
	@Size(min = 5, max = 8)
	@NotEmpty(message = "Please enter Your customerNumber")
	private String customerNumber;
	
	@Size(min = 10, max = 15)
	@NotEmpty(message = "Please enter Your phoneNumber")
	private String phoneNumber;
	
	@NotEmpty(message = "Please enter Your phoneNumber")
	@Email(message = "Ivvalid email address")
	private String email;
	
	@Valid
	@Embedded
	private Address address;
	
	@Valid
	@OneToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
	// @JoinColumn(name = "account_person_id", referencedColumnName =
	// "accountId")
	@JoinColumn(name = "account_id")
	private Account account;
	

//	@OneToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL) 
// 	@JoinColumn(name="member_id") 
// 	UserCredentials userCredentials; 	
  
//	@OneToMany(mappedBy="member",fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })  
//  private List<Address2> addresses = new ArrayList<Address2>();

 	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	public Boolean isAdmin() {
		if (this.account.getAuthority().equals(AccountType.ADMIN)) {
			return true;
		} else {
			return false;
		}
	}
	
 }
