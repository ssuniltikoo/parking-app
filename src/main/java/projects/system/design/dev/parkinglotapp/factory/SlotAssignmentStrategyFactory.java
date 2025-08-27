package projects.system.design.dev.parkinglotapp.factory;

import projects.system.design.dev.parkinglotapp.strategies.*;

public class SlotAssignmentStrategyFactory {
    private SlotAssignmentStrategyFactory() {}

    public static SlotAssignmentStrategy getSlotAssignmentStrategy(SlotAssignmentStrategyType slotAssignmentStrategyType){
        if(slotAssignmentStrategyType.equals(SlotAssignmentStrategyType.RANDOM)){
            return new RandomSlotAssignmentStrategy();
        }else if(slotAssignmentStrategyType.equals(SlotAssignmentStrategyType.NEAREST)){
            return new NearestSlotAssignmentStrategy();
        }else if(slotAssignmentStrategyType.equals(SlotAssignmentStrategyType.MOST_VACANT_FLOOR)){
            return new MostVacantFloorStrategy();
        }else
            return null;
    }
}
