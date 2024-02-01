package com.company;

public class Trainer {
    private final String name;
    private Pokemon pokeSlot1;
    private Pokemon pokeSlot2;
    private Pokemon pokeSlot3;
    private Pokemon fighter;

    public Trainer (String name, Pokemon p1, Pokemon p2, Pokemon p3){
        this.name = name;
        pokeSlot1 = p1;
        pokeSlot2 = p2;
        pokeSlot3 = p3;
    }

    public Trainer (String name, Pokemon p1, Pokemon p2){
        this.name = name;
        pokeSlot1 = p1;
        pokeSlot2 = p2;
        pokeSlot3 = null;
    }

    public Trainer (String name, Pokemon p1){
        this.name = name;
        pokeSlot1 = p1;
        pokeSlot2 = null;
        pokeSlot3 = null;
    }

    /** Adds the inputted pokemon to the trainer's second or third pokemon slot.
     * @param newPokemon New Pokemon object that can be added to the trainer's available slots.
     */
    public void addPokemon(Pokemon newPokemon){
        if (pokeSlot2 == null){
            pokeSlot2 = newPokemon;
        }else if(pokeSlot3 == null){
            pokeSlot3 = newPokemon;
        }
    }

    /** Swaps the pokeSlot1 with the inputted new Pokemon.
     * @param newPokemon The inputted Pokemon that will replace pokeSlot1.
     */
    public void swapPokemon(Pokemon newPokemon){
        if (newPokemon == pokeSlot2){
            pokeSlot2 = pokeSlot1;
        }else{
            pokeSlot3 = pokeSlot1;
        }
        pokeSlot1 = newPokemon;
    }

    /** Returns the pokeSlot1 (the fighter).
     *
     * @return pokeSlot1 The Pokemon who will fight.
     */
    public Pokemon getFighter(){
        fighter = pokeSlot1;
        return fighter;
    }

    /** Returns the trainer's name.
     * @return name The trainer's name.
     */
    public String getTrainerName() {
        return name;
    }

    /** Returns the Trainer's Pokemon in slot 2.
     * @return Pokemon in slot 2
     */
    public Pokemon getPokeSlot2(){
        return pokeSlot2;
    }

    /** Returns the Trainer's Pokemon in slot 3.
     * @return Pokemon in slot 3
     */
    public Pokemon getPokeSlot3() {
        return pokeSlot3;
    }
}
