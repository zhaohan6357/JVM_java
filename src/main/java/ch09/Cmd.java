package ch09;

import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Cmd {

    String cpOpthion;
    String XjreOption;
    String version="0.0.1";
    String className;
    boolean verboseClassFlag=false;
    boolean verboseInstFlag=false;
    List<String> arg=new LinkedList<>();
    String[] args;
    void cmdParse(String[] args ){
        CommandLineParser parser = new BasicParser( );
        Options options = new Options( );
        options.addOption("h", "help", false, "Print this usage information");
        options.addOption("v", "version", false, "Print out version information" );
        options.addOption("c", "classpath", true, "the path of a class");
        options.addOption("c", "cp", true, "the path of a class");
        options.addOption("verbose", "verbose", false, "enable verbose output");
        options.addOption("verbose", "verbose:class", false, "enable verbose output");
        options.addOption("verboseinst", "verbose:inst", false, "enable verbose output");

        options.addOption("x","Xjre",true,"the path of jre");
        // Parse the program arguments
        CommandLine commandLine = null;
        try {
            commandLine = parser.parse( options, args );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Set the appropriate variables based on supplied options
        if( commandLine.hasOption('h') ) {
            System.out.println( "Usage:java -jar file.jar"+" [-options] class [args...]");
            System.exit(0);
        }
        if( commandLine.hasOption("verbose") ) {
            System.out.println("this version is"+version);
            System.exit(0);
        }

        if(commandLine.hasOption("verbose")){
            verboseClassFlag=true;
        }

        if(commandLine.hasOption("verboseinst")){
            verboseInstFlag=true;
        }

        if(commandLine.hasOption('x')){
            XjreOption=commandLine.getOptionValue('x');
        }
        if( commandLine.hasOption('c') ) {
            cpOpthion = commandLine.getOptionValue('c');
        }
        List<String> ars= commandLine.getArgList();
        if(ars.size()>0){
            className=ars.get(0);
            arg=ars.subList(1,ars.size());
            this.args=new String[arg.size()];
            arg.toArray(this.args);
        }

    }
}
