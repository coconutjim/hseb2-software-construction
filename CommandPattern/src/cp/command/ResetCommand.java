package cp.command;

import cp.model.Counter;

/**
 * The reset command.
 * Illustrates a concrete command without parameters,
 * which needs to store something in order to undo it.
 * 
 * @author Tom Verhoeff (TU/e)
 */
public class ResetCommand extends Command {
    
    // This command has no parameters.
    
    /** Previous state of the receiver, for undo() */
    private int oldCount;
    
    public ResetCommand(final Counter receiver) {
        super(receiver);
    }
    
    @Override
    public void execute() {
        super.execute();
        oldCount = receiver.getCount();
        receiver.reset();
    }
    
    @Override
    public void undo() {
        super.undo();
        receiver.setCount(oldCount);
    }
    
}
