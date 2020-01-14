/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lev
 */
public class GenerateCommand extends Command {
    
    // This command has no parameters.
    // This command needs no memory to implement undo.
    
    public GenerateCommand(final GenerateData receiver) {
        super(receiver);
    }
    
    @Override
    public GenerateData execute() {
        super.execute();
        //return 
    }
    
    @Override
    public void undo() {
        super.undo();
        receiver.setCount(receiver.getCount() - 1);
    }
    
}
