package at.htl.model.dto;

public class RegistrationDTO {

    public String firstname;
    public String lastname;

    public Long planId;

    public RegistrationDTO(String firstname, String lastname, Long planId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.planId = planId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }
}
