package com.javarush.island.zonov.entity.animals.headClasses;

import com.javarush.island.zonov.entity.animals.Herbivore;
import com.javarush.island.zonov.entity.animals.Predator;
import com.javarush.island.zonov.entity.island.Island;
import com.javarush.island.zonov.entity.island.Sector;
import com.javarush.island.zonov.exception.ApplicationException;
import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.repository.AnimalTypeCode;

import java.util.*;

import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.ConsoleViewConstants.MULTIPLY_FAIL;
import static com.javarush.island.zonov.repository.PredatorMenu.CHANCE_OF_EAT;
import static com.javarush.island.zonov.repository.AnimalTypeCode.PREDATOR;
import static com.javarush.island.zonov.util.AnimalCharacteristicSetter.setCharacteristic;
import static com.javarush.island.zonov.util.DestinationCellGenerator.generateDestinationCell;
import static com.javarush.island.zonov.util.generators.MenuGenerator.generatePredatorMenu;

public class Animal implements Predator, Herbivore {
    private AnimalTypeCode type;
    private double weight;
    private int maxCountOnCell;
    private int speed;
    private double foodWeight;

    public void setAnimalCharacteristic() {
        List<Double> characteristics = setCharacteristic(this.getClass());
        this.weight = characteristics.get(0);
        this.maxCountOnCell = characteristics.get(1).intValue();
        this.speed = characteristics.get(2).intValue();
        this.foodWeight = characteristics.get(3);
    }

    private boolean isAlive = true;

    private boolean isGone = false;
    private boolean isHungry = true;
    private Set<Class<? extends Animal>> potentialPredatorFood;
    private Set<Class<? extends Plant>> potentialHerbivoreFood;
    private String name;

    private final Map<Class<? extends Animal>, Map<Class<? extends Animal>, Integer>> chanceOfEat = CHANCE_OF_EAT;

    public Set<Class<? extends Animal>> getPotentialPredatorFood() {
        return potentialPredatorFood;
    }

    public AnimalTypeCode getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountOnCell() {
        return maxCountOnCell;
    }

    public double getFoodWeight() {
        return foodWeight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setPotentialPredatorFood(Set<Class<? extends Animal>> potentialPredatorFood) {
        this.potentialPredatorFood = potentialPredatorFood;
    }

    public void setPotentialHerbivoreFood(Set<Class<? extends Plant>> potentialHerbivoreFood) {
        this.potentialHerbivoreFood = potentialHerbivoreFood;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }
    public boolean getHungry() {
        return isHungry;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public boolean getAlive() {
        return isAlive;
    }

    public void setGone(boolean gone) {
        isGone = gone;

    }
    public boolean getGone() {
        return isGone;
    }


    public void multiply(Cell cell) {
            Animal newAnimal;
            try {
                newAnimal = this.getClass().getConstructor().newInstance();
                newAnimal.setName("New " + newAnimal.getClass().getSimpleName());
                for(Cell current : Island.getSectors().get(cell.getSectorIndex()).getCells()) {
                    if (current.equals(cell)) {
                        current.getAnimals().get(newAnimal.getClass()).add(newAnimal);
                        break;
                    }
                }
                if (newAnimal.getType() == PREDATOR) {
                    newAnimal.setPotentialPredatorFood(generatePredatorMenu(newAnimal.getClass()));
                }
            } catch (Exception e) {
                throw new ApplicationException(MULTIPLY_FAIL);
            }
    }
    @Override
    public double eatPlants(Cell cell, double eatenFood) {
        Set<Plant> plantsToEat = cell.getPlants().get(Plant.class);
        if (!plantsToEat.isEmpty()) {
            Plant plant = plantsToEat.iterator().next();
            double weightOfPlant = plant.getWeight();
            double food = eatenFood;
            food += weightOfPlant;
            for (Cell current : Island.getSectors().get(cell.getSectorIndex()).getCells()) {
                if (current.equals(cell)) {
                    current.getPlants().get(Plant.class).remove(plant);
                }
            }
            if (food >= this.foodWeight) {
                this.setHungry(false);
            }
            return food;
        } else {
            return 0.0;
        }
    }

    @Override
    public double eatAnimal(Cell cell, double eatenFood) {
        Class<? extends Animal> eatenAnimalClass = this.potentialPredatorFood.iterator().next();
        Set<Animal> animalsToEat = cell.getAnimals().get(eatenAnimalClass);
        if (!animalsToEat.isEmpty()) {
            Animal animalToEat = animalsToEat.iterator().next();
            animalToEat.setAnimalCharacteristic();
            double weightOfVictim = animalToEat.getWeight();
            double food = eatenFood;
            boolean eatSuccess = ThreadLocalRandom.current().nextInt(1, 101) <= chanceOfEat.get(this.getClass()).get(eatenAnimalClass);

            if (eatSuccess) {
                food += weightOfVictim;
                for (Cell current : Island.getSectors().get(cell.getSectorIndex()).getCells()) {
                    if (current.equals(cell)) {
                        current.getAnimals().get(eatenAnimalClass).remove(animalToEat);
                        break;
                    }
                }
            }
            if (food >= this.foodWeight) {
                this.setHungry(false);
            }
            return food;
        } else
            return 0.0;
    }
   public synchronized void move(int speed, Cell cell) {
        Cell current = generateDestinationCell(speed, cell);
        Cell temp = current;
        for (Sector sector : Island.getSectors()) {
            if (sector.getCells().stream().anyMatch(c -> c.getX() == current.getX() && c.getY() == current.getY())) {
                temp = sector.getCells().stream().filter(c -> c.getX() == current.getX() && c.getY() == current.getY()).findFirst().get();
            }
        }
        int sectorIndex = temp.getSectorIndex();
        for (Cell destination : Island.getSectors().get(sectorIndex).getCells()) {
            if(destination.equals(current)) {
                destination.getAnimals().get(this.getClass()).add(this);
                break;
            }
        }

    }
}
