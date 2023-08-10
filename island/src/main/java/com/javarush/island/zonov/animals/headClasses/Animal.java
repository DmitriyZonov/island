package com.javarush.island.zonov.animals.headClasses;

import com.javarush.island.zonov.animals.Herbivore;
import com.javarush.island.zonov.animals.Predator;
import com.javarush.island.zonov.characterstics.AnimalCharacteristic;
import com.javarush.island.zonov.characterstics.PlantCharacteristic;
import com.javarush.island.zonov.exception.ApplicationException;
import com.javarush.island.zonov.island.Cell;
import com.javarush.island.zonov.island.Island;
import com.javarush.island.zonov.repository.AnimalTypeCode;

import java.lang.reflect.Constructor;
import java.util.*;

import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.island.zonov.constants.ConsoleViewConstants.MULTIPLY_FAIL;
import static com.javarush.island.zonov.constants.PredatorConstants.CHANCE_OF_EAT;
import static com.javarush.island.zonov.generators.CellNeighborsGenerator.generateNeighbors;
import static com.javarush.island.zonov.generators.MenuGenerator.generatePredatorMenu;

public class Animal implements Predator, Herbivore {
    private boolean isHungry = true;
    private Cell cell;
    private Set<Class<? extends Animal>> potentialPredatorFood;
    private Set<Class<? extends Plant>> potentialHerbivoreFood;
    private String name;

    private final Map<Class<? extends Animal>, Map<Class<? extends Animal>, Integer>> chanceOfEat = CHANCE_OF_EAT;

    public Set<Class<? extends Animal>> getPotentialPredatorFood() {
        return potentialPredatorFood;
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

    public Animal multiply() {
            Animal newAnimal;
            try {
                Constructor<? extends Animal> animalConstructor = this.getClass().getConstructor();
                newAnimal = animalConstructor.newInstance();
                newAnimal.setName(newAnimal.getClass().getSimpleName());
                newAnimal.setCell(cell);
                if (Objects.requireNonNull(newAnimal.getClass().getAnnotation(AnimalCharacteristic.class).type()) == AnimalTypeCode.PREDATOR) {
                    newAnimal.setPotentialPredatorFood(generatePredatorMenu(newAnimal.getClass()));
                }
            } catch (Exception e) {
                throw new ApplicationException(MULTIPLY_FAIL);
            }
            return newAnimal;
    }
    @Override
    public double eatPlants(Cell cell, double eatenFood) {
        List<Plant> plantsToEat = cell.getPlants().get(Plant.class).stream().toList();
        if (!plantsToEat.isEmpty()) {
            Plant plant = plantsToEat.get(ThreadLocalRandom.current().nextInt(plantsToEat.size()));
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
        List<Class<? extends Animal>> potentialPredatorFoodList = this.getPotentialPredatorFood().stream().toList();
        Class<? extends Animal> eatenAnimalClass = potentialPredatorFoodList.get(ThreadLocalRandom.current().nextInt(potentialPredatorFoodList.size()));
        List<Animal> animalsToEat = cell.getAnimals().get(eatenAnimalClass).stream().toList();
        if (!animalsToEat.isEmpty()) {
            Animal animalToEat = animalsToEat.get(ThreadLocalRandom.current().nextInt(animalsToEat.size()));
            double weightOfVictim = animalToEat.getClass().getAnnotation(AnimalCharacteristic.class).weight();
            double food = eatenFood;
            boolean eatSuccess = ThreadLocalRandom.current().nextInt(1, 101) <= chanceOfEat.get(this.getClass()).get(eatenAnimalClass);

            if (eatSuccess) {
                food += weightOfVictim;
                cell.getAnimals().get(eatenAnimalClass).remove(animalToEat);
                int index = Island.getCells().indexOf(cell);
                Island.getCells().get(index).getAnimals().get(eatenAnimalClass).remove(animalToEat);
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
