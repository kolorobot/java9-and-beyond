package pl.codeleak.samples.jpms.module1.internal;

import java.util.logging.Logger;

/* Won't be visible outside the module, unless explicitly exported. See module-info.java */
public class Module1InternalPublicClass {
    Logger logger;
}
