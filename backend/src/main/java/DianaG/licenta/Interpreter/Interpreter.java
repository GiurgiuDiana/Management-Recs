package DianaG.licenta.Interpreter;
import org.python.core.PyInstance;
import org.python.util.PythonInterpreter;

public class Interpreter {


        PythonInterpreter interpreter = null;


        public Interpreter()
        {
            PythonInterpreter.initialize(System.getProperties(),
                    System.getProperties(), new String[0]);

            this.interpreter = new PythonInterpreter();
        }

        void execfile( final String fileName )
        {
            this.interpreter.execfile(fileName);
        }

        PyInstance createClass( final String className, final String opts )
        {
            return (PyInstance) this.interpreter.eval(className + "(" + opts + ")");
        }

        public static void main( String gargs[] )
        {
            Interpreter ie = new Interpreter();

            ie.execfile("newTRY_20.py");

            PyInstance hello = ie.createClass("KNN", "None");

            hello.invoke("run");
        }
    }

