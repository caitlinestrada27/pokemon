package com.company;

public class Pokemon {
    private int hp;
    private final int attack;
    private final String name;

    /** This creates a new Pokemon.
     *
     * @param name The pokemon's name.
     * @param level Determines the pokemon's hp and attack power.
     */
    public Pokemon(String name, int level){
        this.name = name;
        this.hp = level*5;
        this.attack = level*3;
    }

    /** This randomly generates the number of attack points.
     * @return attackPoints The number of damage the attack will do to the other pokemon's hp.
     */
    public int generateAttack(){
        return (int)(Math.random()*attack);
    }

    /** This subtracts the incoming attack points from the hp.
     * @param incomingAttack Attack points of the other pokemon's attack.
     */
    public void takeAttack(int incomingAttack){
        hp -= incomingAttack;
    }

    /** This returns whether or not the Pokemon is alive.
      * @return isAlive Determines whether or not the pokemon is alive based on its hp.
     */
    public boolean isAlive(){
        return hp > 0;
    }

    /** Getter method for the pokemon's name.
     * @return String Pokemon's name
     */
    public String getPokemonName() {
        return name;
    }

    /** Getter method for pokemon's stats.
     * @return the hp and attack
     */
    public String getStats(){
        return "HP of " + hp + " and attack of " + attack;
    }
}
