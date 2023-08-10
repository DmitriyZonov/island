package com.javarush.island.zonov.constants;

import com.javarush.island.zonov.animals.*;
import com.javarush.island.zonov.island.Island;

import static com.javarush.island.zonov.island.IslandPopulationCounter.*;
import static com.javarush.island.zonov.island.SectorPopulationCounter.*;

public class ConsoleViewConstants {
    public static final String GREETING = "Добро пожаловать в симуляцию жизни на острове.\n" +
            "Здесь представлено 15 видов животных, из которых:\n" +
            "- 10 видов травоядных животных\n" +
            "- 5 видов хищных животных\n" +
            "А также один вид растений в качестве пищи для травоядных.\n" +
            "Сам остров состоит из клеток (квадратов), у каждого квадрата есть свои координаты.\n" +
            "Животные могут передвигаться по острову в разные квадраты, поедать друг друга и размножаться с животными своего вида";

    public static final String FIRST_CHOICE = "Если Вы пользуетесь программой впервые - нажмите Enter для создания острова с нуля и следуйте дальнейшим инструкциям.\n" +
            "Или введите 0 для загрузки предыдущего состояния острова";

    public static final String MULTIPLY_FAIL = "Размножение пошло не по плану!";

    public static final String NEXT_DAY = "Для запуска симуляции следующего дня нажмите ENTER\n" +
            "Чтобы сохранить прогресс нажмите 0\n" +
            "Чтобы загрузить сохраненный прогресс нажмите 1\n";

    public static final String ISLAND_STATISTIC = String.format("На острове проживает:\n" +
            "%d животных, из них:\n" +
            "%d медведей\n" +
            "%d удавов\n" +
            "%d орлов\n" +
            "%d лис\n" +
            "%d волков\n" +
            "%d кабанов\n" +
            "%d буйволов\n" +
            "%d гусениц\n" +
            "%d оленей\n" +
            "%d уток\n" +
            "%d коз\n" +
            "%d лошадей\n" +
            "%d мышей\n" +
            "%d кроликов\n" +
            "%d овец\n" +
            "%d растений\n",
            allPopulationCount(), oneAnimalSpecieCount(Bear.class), oneAnimalSpecieCount(Boa.class),
            oneAnimalSpecieCount(Eagle.class), oneAnimalSpecieCount(Fox.class), oneAnimalSpecieCount(Wolf.class),
            oneAnimalSpecieCount(Boar.class), oneAnimalSpecieCount(Buffalo.class), oneAnimalSpecieCount(Caterpillar.class),
            oneAnimalSpecieCount(Deer.class), oneAnimalSpecieCount(Duck.class), oneAnimalSpecieCount(Goat.class),
            oneAnimalSpecieCount(Horse.class), oneAnimalSpecieCount(Mouse.class), oneAnimalSpecieCount(Rabbit.class),
            oneAnimalSpecieCount(Sheep.class), allPlantCount());

//    public static final String SECTOR_STATISTIC = String.format("В секторе проживает:\n" +
//            "%d животных, из них:\n" +
//            "%d медведей\n" +
//            "%d удавов\n" +
//            "%d орлов\n" +
//            "%d лис\n" +
//            "%d волков\n" +
//            "%d кабанов\n" +
//            "%d буйволов\n" +
//            "%d гусениц\n" +
//            "%d оленей\n" +
//            "%d уток\n" +
//            "%d коз\n" +
//            "%d лошадей\n" +
//            "%d мышей\n" +
//            "%d кроликов\n" +
//            "%d овец\n" +
//            "%d растений\n", sectorAllPopulationCount(Island.getSectors().get(0)), sectorOneAnimalSpecieCount(Bear.class, Island.getSectors().get(0)),
//            sectorOneAnimalSpecieCount(Boa.class, Island.getSectors().get(0)), sectorOneAnimalSpecieCount(Eagle.class, Island.getSectors().get(0)),
//            sectorOneAnimalSpecieCount(Fox.class, Island.getSectors().get(0)), sectorOneAnimalSpecieCount(Wolf.class, Island.getSectors().get(0)),
//            sectorOneAnimalSpecieCount(Boar.class, Island.getSectors().get(0)), sectorOneAnimalSpecieCount(Buffalo.class, Island.getSectors().get(0)),
//            sectorOneAnimalSpecieCount(Caterpillar.class, Island.getSectors().get(0)), sectorOneAnimalSpecieCount(Deer.class, Island.getSectors().get(0)),
//            sectorOneAnimalSpecieCount(Duck.class, Island.getSectors().get(0)), sectorOneAnimalSpecieCount(Goat.class, Island.getSectors().get(0)),
//            sectorOneAnimalSpecieCount(Horse.class, Island.getSectors().get(0)), sectorOneAnimalSpecieCount(Mouse.class, Island.getSectors().get(0)),
//            sectorOneAnimalSpecieCount(Rabbit.class, Island.getSectors().get(0)), sectorOneAnimalSpecieCount(Sheep.class, Island.getSectors().get(0)),
//            sectorAllPlantCount(Island.getSectors().get(0)));
}
