package com.os;

public class Pokemon implements Comparable{
    private int nr;
    private String name;
    private String type1;
    private String type2;
    private int total;
    private int HP;
    private int attack;
    private int defense;
    private int SPattack;
    private int SPdefense;
    private int speed;
    private int generation;
    private boolean legendary;
    // The criteria is used in the compateTo(Object o) method to determine the Pokemon variable to be used in comparison.
    private Object compareCriteria;
    public Object getCompareCriteria() {
        return compareCriteria;
    }

    public void setCompareCriteria(Object compareCriteria) {
        this.compareCriteria = compareCriteria;
    }



    public Pokemon(int nr, String name, String type1, String type2, int total, int HP, int attack, int defense, int SPattack, int SPdefense, int speed, int generation, boolean legendary) {
        this.nr = nr;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
        this.SPattack = SPattack;
        this.SPdefense = SPdefense;
        this.speed = speed;
        this.generation = generation;
        this.legendary = legendary;
        compareCriteria = this.name;
    }

    @Override
    public int compareTo(Object o) {
        if (((Pokemon) o).getCompareCriteria() instanceof String){
            String criteria = (String)((Pokemon) o).getCompareCriteria();

            return ((String)this.compareCriteria).compareTo(criteria);

        } else if(((Pokemon) o).getCompareCriteria() instanceof Integer) {

            int criteria = (Integer) ((Pokemon) o).getCompareCriteria();
            if((int)this.compareCriteria > criteria){
                return 1;
            } else if ((int)this.compareCriteria < criteria){
                return -1;
            } else {
                return 0;
            }

        } else if(((Pokemon) o).getCompareCriteria() instanceof Boolean) {
            boolean criteria = (Boolean) ((Pokemon) o).getCompareCriteria();
            if ((boolean) this.compareCriteria && !criteria) {
                return 1;
            } else if (!(boolean) this.compareCriteria && criteria) {
                return -1;
            } else {
                return 0;
            }
        }
        System.out.println("Compare criteria not valid. Please set the compareCriteria to one of the supported types: int, String or boolean.");
        return 0;
    }

    public int getNr() {
        return nr;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getTotal() {
        return total;
    }

    public int getHP() {
        return HP;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSPattack() {
        return SPattack;
    }

    public int getSPdefense() {
        return SPdefense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGeneration() {
        return generation;
    }

    public boolean isLegendary() {
        return legendary;
    }

    @Override
    public String toString() {
        return name;
    }
}
