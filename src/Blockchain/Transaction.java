package Blockchain;

import java.util.*;

//A transaction has - Label, Time - both strings (just for fun anyway)

public class Transaction {
    private String label;
    private String time;
    private String hash;

    public Transaction(String label, String time){
        this.time = time;
        this.label = label;

        this.hash = label + time;
        this.hash = Integer.toString(this.hash.hashCode());

    }

    public String getLabel() {
        return label;
    }

    public String getTime() {
        return time;
    }

    public String getHash(){
        return hash;
    }
}
