package cp.command;

import cp.model.Counter;
import junit.framework.TestCase;

/**
 * Tests for class Command.
 * 
 * @author Tom Verhoeff (TU/e)
 */
public class CommandTest extends TestCase {
    
    public CommandTest(String testName) {
        super(testName);
    }

    /**
     * Test of constructor method for exceptions, of class Command.
     */
    public void testCommand() {
        System.out.println("Command(Counter)");
        try {
            Command instance = new Command(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Expected NullPointerException, but got " + e);
        }
    }

    /**
     * Test of execute method for exceptions, of class Command.
     */
    public void testExecute() {
        System.out.println("execute");
        Command instance = new Command(new Counter());
        instance.execute();
        try {
            instance.execute();
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Expected IllegalStateException, but got " + e);
        }
    }

    /**
     * Test of undo method for exceptions, of class Command.
     */
    public void testUndo1() {
        System.out.println("undo");
        Command instance = new Command(new Counter());
        try {
            instance.undo();
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Expected IllegalStateException, but got " + e);
        }
    }

    /**
     * Test of undo method for exceptions, of class Command.
     */
    public void testUndo2() {
        System.out.println("undo");
        Command instance = new Command(new Counter());
        instance.execute();
        instance.undo();
        try {
            instance.undo();
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Expected IllegalStateException, but got " + e);
        }
    }
}
