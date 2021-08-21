package th.co.gosoft.rmos.master.user;

import th.co.gosoft.rmos.master.user.request.UserRequest;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class User {
    public User() {
    }

    public User(@Valid UserRequest userRequest) {
        this.name = userRequest.getName();
        this.userName = userRequest.getUsername();
        setCompany(userRequest.getCompany());
        this.email = userRequest.getEmail();
        setAddress(userRequest.getAddress());
        this.phone = userRequest.getPhone();
        this.website = userRequest.getWebsite();
    }

    private void setAddress(th.co.gosoft.rmos.master.user.request.Address addressRequest) {
        Address address = new Address();
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getStreet());
        address.setSuite(addressRequest.getSuite());
        address.setZipcode(addressRequest.getZipcode());
        Geo geo = new Geo();
        geo.setLat(addressRequest.getGeo().getLat());
        geo.setLng(addressRequest.getGeo().getLng());
        address.setGeo(geo);
        this.address = address;
    }

    private void setCompany(th.co.gosoft.rmos.master.user.request.Company companyRequest) {
        Company company = new Company();
        company.setBs(companyRequest.getBs());
        company.setName(companyRequest.getName());
        company.setCatchPhrase(companyRequest.getCatchPhrase());
        this.company = company;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="user_id")
    private Long id;

    private String name;
    private String userName;
    private String email;
    private String phone;
    private String website;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
