package Blockchain;

import java.util.*;

public class GenesisBlock extends Block {

    public GenesisBlock(){
        super();
        super.setPreviousHash(null);
    }

    @Override
    public String getHash() {
        ArrayList<Transaction> transactions = super.getTransactions();
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

            String hash = Integer.toString(hashString.hashCode());
            super.setHash(hash);

            return super.getHash();
        }
    }

    public static void main(String[]args){
        /*GenesisBlock gblock = new GenesisBlock();
        //gblock.getHash();

        Transaction tr = new Transaction("label","time");
        gblock.addTransaction(tr);

        System.out.println(gblock.getHash());

        Block block = new Block(gblock.getHash());
        block.addTransaction(tr);

        System.out.println(block.getHash());*/



    }
}
