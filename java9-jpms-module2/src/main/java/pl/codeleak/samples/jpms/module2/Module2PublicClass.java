package pl.codeleak.samples.jpms.module2;

import pl.codeleak.samples.jpms.module1.api.Module1ApiPublicInterface;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Module2PublicClass {

    // java.util.logging.Logger is visible because it is transitively imported in `module1`
    private Logger logger = Logger.getLogger(Module2PublicClass.class.getName());

    public void method1() {
        // pl.codeleak.samples.jpms.module1.api.Module1ApiPublicInterface is visible because the `api` package
        // is explicitly exported in `module1` and it is public.
        Module1ApiPublicInterface module1ApiPublicInterface = new Module1ApiPublicInterface() {
        };

        logger.info("Module2PublicClass.method1");

    }
}
