package com.company;

public class Main {

    public static void main(String[] args) {
	    //create Pokemon
        Pokemon charmander = new Pokemon ("Charmander", 3);
        Pokemon squirtle = new Pokemon("Squirtle", 4);
        Pokemon pikachu = new Pokemon("Pikachu", 10);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 6);
        Pokemon mew = new Pokemon("Mew", 2);
        Pokemon lugia = new Pokemon("Lugia", 11);
        //create Trainers
        Trainer ash = new Trainer("Ash", charmander, pikachu, mew);
        Trainer red = new Trainer("Red", squirtle, bulbasaur);
        Trainer serena = new Trainer("Serena", lugia);
        //Battle 1
        System.out.println("Semi Finals: " + ash.getTrainerName() + " vs " + red.getTrainerName());
        Battle semiFinals = new Battle(ash, red);
        Trainer winner = semiFinals.runBattle();
        //Battle 2
        System.out.println();
        System.out.println("Final Battle: " + winner.getTrainerName() + " vs " + serena.getTrainerName());
        Battle finals = new Battle(winner, serena);
        finals.runBattle();
    }
}

