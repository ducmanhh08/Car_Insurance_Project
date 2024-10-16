package CarInsuranceCompany;

public class ThirdPartyPolicy extends InsurancePolicies{

    // create variable:
    protected String comments;

    // create constructor:
    public ThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) throws PolicyException, PolicyHolderNameException {

        super(policyHolderName, id, car, numberOfClaims, expiryDate);

        this.comments = comments;



    }

    public String getComments(){
        return comments;
    }

    public ThirdPartyPolicy(ThirdPartyPolicy thirdPartyPolicy){
        super(thirdPartyPolicy);
        this.comments = thirdPartyPolicy.comments;
    }

    // Overide methods from the super class:
    @Override
    public void print(){
        super.print();
        System.out.println(" Comments: " + comments);
    }

    @Override
    public String toString(){
        return super.toString() + " Comments: " + comments + " Expiry date: " + expiryDate;
    }
    public String toDelimitedString() {
        return "T," + id + "," + policyHolderName + "," + car.toDelimitedString() + "," + numberOfClaims + ", " + comments + "," + expiryDate.toDelimitedString();
    }
    @Override
    public double calcPayment(double flatRate) {
        double premiumPayment = car.price/100 + numberOfClaims*200 + flatRate;
        return premiumPayment;
    }


    @Override
    public int compareTo(InsurancePolicies policy) {
        return expiryDate.compareTo(policy.expiryDate);
    }
}
