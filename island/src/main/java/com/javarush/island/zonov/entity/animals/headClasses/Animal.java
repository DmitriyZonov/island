package com.javarush.island.zonov.entity.animals.headClasses;

import com.javarush.island.zonov.entity.animals.Herbivore;
import com.javarush.island.zonov.entity.animals.Predator;
import com.javarush.island.zonov.entity.animals.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.entity.animals.characterstics.PlantCharacteristic;
import com.javarush.island.zonov.exception.ApplicationException;
import com.javarush.island.zonov.entity.island.Cell;
import com.javarush.island.zonov.repository.AnimalTypeCode;

import java.util.*;

import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.ConsoleViewConstants.MULTIPLY_FAIL;
import static com.javarush.island.zonov.constants.PredatorConstants.CHANCE_OF_EAT;
import static com.javarush.island.zonov.repository.AnimalTypeCode.PREDATOR;
import static com.javarush.island.zonov.util.generators.CellNeighborsGenerator.generateNeighbors;
import static com.javarush.island.zonov.util.generators.MenuGenerator.generatePredatorMenu;

public class Animal implements Predator, Herbivore {
    private AnimalTypeCode type;
    private boolean isAlive = true;

    private boolean isGone = false;
    private boolean isHungry = true;
    private Cell cell;
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

    public void setPotentialPredatorFood(Set<Class<? extends Animal>> potentialPredatorFood) {
        this.potentialPredatorFood = potentialPredatorFood;
    }

    public void setPotentialHerbivoreFood(Set<Class<? extends Plant>> potentialHerbivoreFood) {
        this.potentialHerbivoreFood = potentialHerbivoreFood;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
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


    public Animal multiply() {
            Animal newAnimal;
            try {
                newAnimal = this.getClass().getConstructor().newInstance();
                newAnimal.setName(newAnimal.getClass().getSimpleName());
                newAnimal.setCell(cell);
                if (newAnimal.getType() == PREDATOR) {
                    newAnimal.setPotentialPredatorFood(generatePredatorMenu(newAnimal.getClass()));
                }
            } catch (Exception e) {
                throw new ApplicationException(MULTIPLY_FAIL);
            }
            return newAnimal;
    }
    @Override
    public double eatPlants(Cell cell, double eatenFood) {
        Set<Plant> plantsToEat = cell.getPlants().get(Plant.class);
        if (!plantsToEat.isEmpty()) {
            Plant plant = plantsToEat.iterator().next();
            double weightOfPlant = plant.getClass().getAnnotation(PlantCharacteristic.class).weight();
            double food = eatenFood;
            food += weightOfPlant;
            cell.getPlants().get(Plant.class).remove(plant);
            if (food >= this.getClass().getAnnotation(AnimalCharacteristic.class).foodWeight()) {
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
            double weightOfVictim = animalToEat.getClass().getAnnotation(AnimalCharacteristic.class).weight();
            double food = eatenFood;
            boolean eatSuccess = ThreadLocalRandom.current().nextInt(1, 101) <= chanceOfEat.get(this.getClass()).get(eatenAnimalClass);

            if (eatSuccess) {
                food += weightOfVictim;
                cell.getAnimals().get(eatenAnimalClass).remove(animalToEat);
            }
            if (food >= this.getClass().getAnnotation(AnimalCharacteristic.class).foodWeight()) {
                this.setHungry(false);
            }
            return food;
        } else
            return 0.0;
    }
   public Cell move(int speed, Cell cell) {
       Cell destination = cell;
       for (int i = 0; i < speed; i++) {
           List<Cell> variationsOfStep = new ArrayList<>(destination.getNeighbors());
           int index = ThreadLocalRandom.current().nextInt(variationsOfStep.size());
           Cell current = variationsOfStep.get(index);
           generateNeighbors(current);
           destination = current;
       }

       return destination;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

}
