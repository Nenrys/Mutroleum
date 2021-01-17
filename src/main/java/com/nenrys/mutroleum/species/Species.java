package com.nenrys.mutroleum.species;

public class Species {

    public String[] genes = new String[6];
    private String name;
    public static final String DNAMOL = "natcg";

    public Species() {
        this("Mutroleum");
    }

    public Species(String name) {
        genes[0] = "nnnnnnn";
        genes[1] = "nnnnnnnn";
        genes[2] = "nnnnn";
        genes[3] = "nnnnn";
        genes[4] = "nnnnnnnnnn";
        genes[5] = "nnnn";
        this.name=name;
    }

    public void changeGene(int chromo, int num, String gene) {
        String s1 = "";
        String s2 = "";
        if(num == 0) {
            s2 = this.genes[chromo].substring(1);
        } else if(num == this.genes.length) {
            s1 = this.genes[chromo].substring(0,num);
        } else {
            s1 = genes[chromo].substring(0,num);
            s2 = genes[chromo].substring(num+1);
        }
        this.genes[chromo] = s1 + gene + s2;
    }

    public static String getNextDNA(String c) {
        String c1;

        switch(c) {
            case "n":
                c1 = "a";
                break;
            case "a":
                c1 = "t";
                break;
            case "t":
                c1 = "c";
                break;
            case "c":
                c1 = "g";
                break;
            case "g":
                c1 = "n";
                break;
            default:
                c1 = "n";
                break;
        }
        return c1;

    }

    public static String getPrevDNA(String c) {
        String c1;

        switch(c) {
            case "n":
                c1 = "g";
                break;
            case "a":
                c1 = "n";
                break;
            case "t":
                c1 = "a";
                break;
            case "c":
                c1 = "t";
                break;
            case "g":
                c1 = "c";
                break;
            default:
                c1 = "n";
                break;
        }
        return c1;
    }

}
