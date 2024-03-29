import java.util.ArrayList;
import java.util.List;

/**
 * A composite observer that distributes events
 * to all registered observers.
 * Observers can be added and removed at run-time.
 *
 * @param A  Type of generator
 *
 * @author Tom Verhoeff (TU/e)
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Lev Osipov, 271(1), 13.12.2013</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class CompositeGeneratorObserver<A> implements GeneratorObserver<A> {

    /** List of registered observers */
    private final List<GeneratorObserver<A>> observers;

    // Representation invariant:
    //    (\forall obs : observers; obs != null)

    /**
     * Constructs an empty composite observer.
     */
    public CompositeGeneratorObserver() {
        observers = new ArrayList<GeneratorObserver<A>>();
    }

    /**
     * Registers an observer.
     *
     * @param observer  observer for functionality B to register
     * @pre {@code observer != null}
     * @throws IllegalArgumentException  if {@code observer == null}
     */
    public void add(GeneratorObserver<A> observer) {
        if (observer == null) {
            throw new IllegalArgumentException(
                    "GeneratorObserver.add: pre observer != null failed");
        }
        observers.add(observer);
    }
    /**
     * Unregisters an observer.  Has no effect if observer
     * was not registered.
     *
     * @param observer  observer to unregister
     */
    public void remove(GeneratorObserver<A> observer) {
        observers.remove(observer);
    }

    /**
     * Distributes notification to all registered observers.
     */
    @Override
    public void objectGenerated(Generator<A> generator) {
//# BEGIN TODO Implementation of objectGenerated
        for (GeneratorObserver<A> observer : observers) {
            observer.objectGenerated(generator);
        }
//# END TODO
    }

}
