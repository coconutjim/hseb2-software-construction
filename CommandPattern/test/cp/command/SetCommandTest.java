package cp.command;

import cp.model.Counter;
import junit.framework.TestCase;

/**
 * Tests for class SetCommand.
 * 
 * @author Tom Verhoeff (TU/e)
 */
public class SetCommandTest extends TestCase {
    
    public SetCommandTest(String testName) {
        super(testName);
    }

    /**
     * Test of execute method, of class SetCommand.
     */
    public void testExecute() {
        System.out.println("execute");
        final Counter counter = new Counter();
        final int newCount = 3;
        SetCommand instance = new SetCommand(counter, newCount);
        instance.execute();
        assertEquals("After execute()", newCount, counter.getCount());
    }

    /**
     * Test of undo method, of class SetCommand.
     */
    public void testUndo() {
        System.out.println("undo");
        final Counter counter = new Counter();
        counter.increment();
        final int expected = counter.getCount();
        final int newCount = 3;
        SetCommand instance = new SetCommand(counter, newCount);
        instance.execute();
        instance.undo();
        assertEquals("After execute() and undo()",
                expected, counter.getCount());
    }
}
