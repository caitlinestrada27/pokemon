package com.company;
import java.util.concurrent.TimeUnit;

public class Battle {
    private final Trainer trainer1;
    private final Trainer trainer2;
    private Trainer currentPlayer;

    public Battle(Trainer player1, Trainer player2){
        this.trainer1 = player1;
        this.trainer2 = player2;
        currentPlayer = whoGoesFirst();
    }

    /** Commit to Github. Runs the game and has the two pokemon battle each other until one loses.
     *
     */
    public Trainer runBattle(){
        String winner;
        String loser;
        System.out.println(trainer1.getTrainerName() + "'s fighter is " + trainer1.getFighter().getPokemonName() + " and " + trainer2.getTrainerName() + "'s fighter is " + trainer2.getFighter().getPokemonName());
        delayForEffect(3);
        System.out.println(trainer1.getFighter().getPokemonName() + "'s stats are: " + trainer1.getFighter().getStats());
        delayForEffect(3);
        System.out.println(trainer2.getFighter().getPokemonName() + "'s stats are: " + trainer2.getFighter().getStats());
        delayForEffect(3);
        System.out.println("Let the games begin");
        delayForEffect(3);
            while (trainer1.getFighter().isAlive() && trainer2.getFighter().isAlive()){
                playersTurn();
                swapPlayers();
                if(!currentPlayer.getFighter().isAlive()) {
                    System.out.println();
                    System.out.println(currentPlayer.getFighter().getPokemonName() + " has fainted");
                    switchFighter();
                    delayForEffect(3);
                    if (currentPlayer.getFighter().isAlive()){
                        System.out.println(currentPlayer.getFighter().getPokemonName() + " is now " + currentPlayer.getTrainerName() + "'s fighter");
                    }
                    System.out.println();
                }
            }

        if (trainer1.getFighter().isAlive() && !trainer2.getFighter().isAlive()){
                winner = trainer1.getTrainerName();
                loser = trainer2.getTrainerName();
        }else{
                loser = trainer1.getTrainerName();
                winner = trainer2.getTrainerName();
        }

        System.out.println("The winner is " + winner + " and the loser is " + loser + ". Congratulations " + winner + "! Back to the training courses " + loser);
        if(winner.equals(trainer1.getTrainerName())){
            return trainer1;
        }else{
            return trainer2;
        }
    }

    /** Generates an attack for the player whose turn it is based on the pokemon's stats.
     */
    public void playersTurn(){
    //generate an attack based on the pokemon's stats
        int currentAttack = currentPlayer.getFighter().generateAttack();
        if(currentPlayer == trainer1){
            trainer2.getFighter().takeAttack(currentAttack);
            System.out.println(trainer2.getFighter().getPokemonName() + " took " + currentAttack + " damage");
        }else{
            trainer1.getFighter().takeAttack(currentAttack);
            System.out.println(trainer1.getFighter().getPokemonName() + " took " + currentAttack + " damage");
        }
        delayForEffect(3);
    }

    /** Swaps who the current player is.
     */
    public void swapPlayers(){
        if (currentPlayer == trainer1){
            currentPlayer = trainer2;
        }else{
            currentPlayer = trainer1;
        }
    }

    /** Randomly generates which trainer gets to go first.
     * @return Trainer who goes first in the battle
     */
    public Trainer whoGoesFirst(){
        int randValue = (int)(Math.random() * (2-1) + 1);
        if (randValue == 1){
            return trainer1;
        }else{
            return trainer2;
        }
    }

    /** Delays printing time for effect.
     * @param seconds determines the seconds between each line
     */
    public void delayForEffect(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ie){
            Thread.currentThread().interrupt();
        }
    }

    /** Switches the fainted Pokemon for the poke in slot 2 or 3.
     */
    public void switchFighter(){
        if (currentPlayer.getPokeSlot2() != null && currentPlayer.getPokeSlot2().isAlive()){
            currentPlayer.swapPokemon(currentPlayer.getPokeSlot2());
        }else if (currentPlayer.getPokeSlot3() != null && currentPlayer.getPokeSlot3().isAlive()){
            currentPlayer.swapPokemon(currentPlayer.getPokeSlot3());
        }
    }

}
