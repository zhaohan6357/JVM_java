package ch01;
import org.apache.commons.cli.*;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        // Create a Parser
        CommandLineParser parser = new BasicParser( );

        Options options = new Options( );
        options.addOption("h", "help", false, "Print this usage information");
        options.addOption("v", "verbose", false, "Print out VERBOSE information" );
        options.addOption("f", "file", true, "File to save program output to");
        // Parse the program arguments
        CommandLine commandLine = null;
        try {
            commandLine = parser.parse( options, args );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Set the appropriate variables based on supplied options
        boolean verbose = false;
        String file = "";

        if( commandLine.hasOption('h') ) {
            System.out.println( "Help Message");
            //System.exit(0);
        }
        if( commandLine.hasOption('v') ) {
            verbose = true;
        }
        if( commandLine.hasOption('f') ) {
            file = commandLine.getOptionValue('f');
            String[] strs=commandLine.getArgs();
            System.out.println(file);
            System.out.println(Arrays.toString(strs));
        }
    }
}
