package cp.command;

import cp.model.Counter;

/**
 * The set command.
 * Illustrates a concrete command with a parameter.
 * It also needs to store something in order to undo it.
 * In this example project, it is not used (except in the tests).
 * 
 * @author Tom Verhoeff (TU/e)
 */
public class SetCommand extends Command {
    
    /** The command's parameter */
    private int newCount;
    
    /** Previous state of the receiver, for undo() */
    private int oldCount;
    
    public SetCommand(final Counter receiver, final int newCount) {
        super(receiver);
        this.newCount = newCount;
    }
    
    @Override
    public void execute() {
        super.execute();
        oldCount = receiver.getCount();
        receiver.setCount(newCount);
    }
    
    @Override
    public void undo() {
        super.undo();
        receiver.setCount(oldCount);
    }
    
}
