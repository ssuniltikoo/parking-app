package projects.system.design.dev.parkinglotapp.strategies;

public abstract class BaseParkingFeesCalculationBaseParkingFeesCal implements  ParkingFeesCalculationStrategy{

    protected int calculateFeesByDuration(int duration, int firstTwoHourRate, int twoToFourHourRate, int fourToSixHourRate, int afterSizHourRate ){
        int fees =0;
        fees+=2*firstTwoHourRate;
        if(duration>=2){
            fees+=2*twoToFourHourRate;
        }

        if(duration>=4){
            fees+=2*fourToSixHourRate;
        }


        if(duration>6){
            duration=duration-6;//Math.ceil(Double.valueOf(duration)-6);
            fees+=duration*afterSizHourRate;
        }

        return fees;
    }

}
