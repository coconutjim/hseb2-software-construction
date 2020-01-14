/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lev
 */
public class Command {
    
    /** The receiving Counter */
    protected final GenerateData receiver;
    
    /** Execution state */
    private boolean executed;
    
    /**
     * Constructs a command for a given receiver.
     * 
     * @pre {@code receiver != null}
     */
    public Command(final GenerateData receiver)
            throws NullPointerException {
        if (receiver == null) {
            throw new NullPointerException("Command(Counter).pre violated: "
                    + "receiver == null");
        }
        this.receiver = receiver;
        this.executed = false;
    }

    /**
     * Executes the command.
     * A concrete command will override this method.
     * 
     * @throws IllegalStateException  if {@code executed}
     * @pre {@code ! executed && }
     *   precondition of the command holds in the receiver
     * @post {@code executed}
     */
    public void execute() throws IllegalStateException {
        if (executed) {
            throw new IllegalStateException("Command.execute().pre violated: "
                    + "command was already executed");
        }
        executed = true;
    }
    
    /**
     * Undoes the command.
     * A concrete command will override this method.
     *
     * @pre {@code executed && }
     *   precondition of the undo holds in the receiver
     * @post {@code ! executed}
     */
    public void undo() throws IllegalStateException {
        if (! executed) {
            throw new IllegalStateException("Command.undo().pre violated: "
                    + "command was not yet executed");
        }
        executed = false;
    }
    
    /**
     * Returns if command is executed or not
     * 
     * @return {@code true} if command is
     * executed or {@code false} otherwise
     */
    public boolean isExecuted() {
        return executed;
    }
    
}
