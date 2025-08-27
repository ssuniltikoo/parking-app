package projects.system.design.dev.parkinglotapp.strategies;

public class CarParkingFeesCalculation extends BaseParkingFeesCalculationBaseParkingFeesCal{
    private static final int FIRST_TWO_HOURS_RATE = 20;
    private static final int TWO_TO_FOUR_HOURS_RATE = 30;
    private static final int FOUR_TO_SIX_HOURS_RATE = 35;
    private static final int AFTER_SIX_HOURS_RATE = 45;



    @Override
    public Integer calculateParkingFees(int duration) {
        return calculateFeesByDuration(duration,FIRST_TWO_HOURS_RATE,TWO_TO_FOUR_HOURS_RATE
        ,FOUR_TO_SIX_HOURS_RATE,AFTER_SIX_HOURS_RATE);
    }
}
