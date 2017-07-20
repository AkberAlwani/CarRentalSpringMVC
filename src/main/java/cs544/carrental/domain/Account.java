package cs544.carrental.domain;

 


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotEmpty;  

@Entity
public class Account { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long accountId;
	
	@Column(unique=true)
	@Size(min=4, max=15)
	@NotEmpty(message="Please enter Your username")
	private String username;

	
	@NotEmpty(message="Please enter Your password")
	private String password;
	
	private String verifyPassword;
	
	private Boolean enabled;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "authority_id")
	Authority authority;
//	List<Authority> authority = new ArrayList<Authority>();
	
//	private Boolean active;
//	@Enumerated(EnumType.STRING)
//	private AccountType accountType; 

	
	@OneToOne(mappedBy = "account",cascade=CascadeType.PERSIST)
//	@Cascade({CascadeType.SAVE_UPDATE})
	private Customer customer;
	
	public long getAccountId() {
		return accountId;
	}
	
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", username=" + username + ", password=" + password
				+ ", verifyPassword=" + verifyPassword + ", enabled=" + enabled + ", authority=" + authority
				+ ", customer=" + customer + "]";
	}
	
	

}
