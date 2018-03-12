package Blockchain;

import java.util.*;

//LinkedList of blocks
public class Blockchain {
    private LinkedList<Block> blocks;
    private Block genesisBlock;

    public Blockchain(){
        blocks = new LinkedList<Block>();

    }

    /*
        Check if there are no blocks in the blocks list
            If no blocks, add and set genesis block to this block.
        Else
            set previous hash and add the block to the list

     */
    public void addBlock(Block block){
        //add and set genesis block
        if(blocks.isEmpty()){
            this.genesisBlock = block;
        }

        else{
            Block prevBlock = blocks.getLast();
            block.setPreviousHash(prevBlock.getHash());
            blocks.add(block);
        }

    }

    public static void main(String[]args){
        
    }
}
