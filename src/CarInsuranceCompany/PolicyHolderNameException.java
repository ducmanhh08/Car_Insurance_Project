package CarInsuranceCompany;

public class PolicyHolderNameException extends Exception{

    public String policyHolderName;

    public PolicyHolderNameException(String policyHolderName) throws PolicyHolderNameException{
        this.policyHolderName = policyHolderName;
    }

    @Override
    public String toString(){
        return "The Policy Holder Name was not valid";
    }
}
