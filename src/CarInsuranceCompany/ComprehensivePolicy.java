package CarInsuranceCompany;

public class ComprehensivePolicy extends InsurancePolicies {

//    Attributes:
    protected int driverAge;
    protected int level;

//    Constructors:
    public ComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) throws PolicyException, PolicyHolderNameException {
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.driverAge = driverAge;
        this.level = level;
    }

    public ComprehensivePolicy(ComprehensivePolicy comprehensivePolicy){
        super(comprehensivePolicy);
        this.driverAge = comprehensivePolicy.driverAge;
        this.level = comprehensivePolicy.level;
    }

    public int getDriverAge() { return driverAge;}

    public int getLevel(){
        return level;
    }

//    Methods:
    @Override
    public void print(){
        super.print();
        System.out.println(" Driver Age: " + driverAge + " Level: " + level);
    }

    @Override
    public String toString(){
        return super.toString() + " Driver Age: " + driverAge + " Level: " + level + " Expiry date: " + expiryDate;
    }
    public String toDelimitedString() { return "C," + id + "," + policyHolderName + "," + car.toDelimitedString() + "," + numberOfClaims + "," + driverAge + "," + level + "," + expiryDate.toDelimitedString();}

    @Override
    public double calcPayment(double flatRate) {
        double premiumPayment = car.price/50 + numberOfClaims*200 + flatRate;
        if(driverAge < 30){
            premiumPayment += (30-driverAge)*50;
        }
        return premiumPayment;
    }

    @Override
    public int compareTo(InsurancePolicies policy) {
        return expiryDate.compareTo(policy.expiryDate);
    }
}
