package Blockchain;
import java.util.*;

//A block has a list of transactions and the hash of the previous block

public class Block{
    private ArrayList<Transaction> transactions;
    private String hash;
    private String previousHash;

    //Default constructor for the genesis block(this is used in the genesis block subclass). Otherwise can just use the other one anyway.
    public Block(){
        this.transactions = new ArrayList<>();
        this.previousHash = "";


    }

    public Block(String previousHash){
        this.transactions = new ArrayList<>();
        this.previousHash = previousHash;

    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }


    //for the genesis block
    public void setHash(String hash){
        this.hash = hash;
    }
    public String getHash(){

        //if empty, can't calculate hash, say that trs need to be added
        if(transactions.isEmpty()){
            System.out.println("No transactions in block. Add transactions.");
            return null;
        }

        //add up all the hash strings and use that to calculate hash
        else{
            String hashString = "";
            for(Transaction tr:transactions){
                hashString += tr.getHash();
            }

            //adding previousHash to the hash string as well to get the final hash
            hashString += previousHash;
            hash = Integer.toString(hashString.hashCode());

            return hash;
        }


    }

    public void setPreviousHash(String previousHash){
        this.previousHash = previousHash;
    }

    public String getPreviousHash(){
        return previousHash;
    }

    public void addTransaction(Transaction tr){
        transactions.add(tr);
    }

    public void removeLastTransaction(){
        transactions.remove(transactions.size() - 1);
    }

    /*
    public static void main(String[]args){


        Block block = new Block();
        Transaction tr = new Transaction("label","time");

        block.addTransaction(tr);
        System.out.println(block.getHash());

        Transaction tr1 = new Transaction("label1","time1");
        block.addTransaction(tr1);
        System.out.println(block.getHash());

        block.removeLastTransaction();
        System.out.println(block.getHash());





    }*/
}