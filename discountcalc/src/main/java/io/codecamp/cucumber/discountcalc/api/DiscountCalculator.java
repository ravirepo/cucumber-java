package io.codecamp.cucumber.discountcalc.api;
public class DiscountCalculator {
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Boolean getSeniorCitizen() {
        return isSeniorCitizen;
    }

    public void setSeniorCitizen(Boolean seniorCitizen) {
        isSeniorCitizen = seniorCitizen;
    }

    String state = "NA";
    String profession = "NA";
    Boolean isSeniorCitizen = false;

    public int calculateDiscount(){
        if (getSeniorCitizen())
        {
            System.out.println("Senior Citizen rate");
            return 15;
        }

        if (getState().toUpperCase().equalsIgnoreCase("NJ") ||
                getState().toUpperCase().equalsIgnoreCase("PA")) {
            System.out.println("Preferred state");
            return 10;
        }

        if (getProfession().toUpperCase().equalsIgnoreCase("DEVELOPER")) {
            System.out.println("Developer!!!");
            return 10;
        }

        return 5;
    }
}
