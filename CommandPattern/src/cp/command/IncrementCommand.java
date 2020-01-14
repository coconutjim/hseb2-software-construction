package cp.command;

import cp.model.Counter;

/**
 * The increment command.
 * Illustrates a concrete command without parameters,
 * and which does not have to store anything in order to undo it.
 * 
 * @author Tom Verhoeff (TU/e)
 */
public class IncrementCommand extends Command {
    
    // This command has no parameters.
    // This command needs no memory to implement undo.
    
    public IncrementCommand(final Counter receiver) {
        super(receiver);
    }
    
    @Override
    public void execute() {
        super.execute();
        receiver.increment();
    }
    
    @Override
    public void undo() {
        super.undo();
        receiver.setCount(receiver.getCount() - 1);
    }
    
}
