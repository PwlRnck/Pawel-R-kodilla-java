package com.kodilla.patterns.tasks;

public final class TaskFactory {

        public static final String SHOPPING = "SHOPPING";
        public static final String PAINTING = "PAINTING";
        public static final String DRIVING = "DRIVING";

        public final Task createTask(final String taskClass) {
            switch (taskClass) {
                case SHOPPING:
                    return new ShoppingTask("Shopping in the market", "Potatoes", 2);
                case PAINTING:
                    return new PaintingTask("Painting", "White", "Door");
                case DRIVING:
                    return new DrivingTask("Leisure driving", "Park", "Car");
                default:
                    return null;
            }

        }
}

