package com.github.luka5w.fileservercli;

import com.github.luka5w.util.cli.Logger;
import com.github.luka5w.util.data.Utils;
import com.github.luka5w.util.program.DefaultOption;
import com.github.luka5w.util.program.MainClass;
import com.github.luka5w.util.program.Program;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * FileServer
 *
 * GitHub: https://github.com/luka5w/fileserver
 *
 * @author Lukas // https://github.com/luka5w
 * @version 1.0.0
 */
public class Main implements MainClass {

    private static int LOG_LEVEL = 0;
    private static Logger LOGGER = new Logger(Constants.PROGRAM_NAME, LOG_LEVEL);

    private Ini ini;

    public static void main(String[] args) {
        Main main = new Main();
        Program program = new Program(main, args, Program.DEFAULT_OPTIONS, Constants.FILE_CONFIG, Constants.PROGRAM_NAME, Constants.PROGRAM_VERSION, Constants.HELP_HEADER, Constants.HELP_FOOTER, Constants.HELP_AUTOUSAGE);
        program.init();
        program.exec();
    }

    /**
     * Returns the logger for the specific part of the program.
     *
     * @param subLogger The name of the part of the program.
     *
     * @return The logger for the part of the program.
     */
    public static Logger getLogger(String subLogger) {
        return new Logger(subLogger, LOGGER);
    }

    @Override
    public void getOptions(Options options) {
        /**
         * usage
         * @see Options#addOption(Option)
         * @see Options#addOption(String, String)
         * @see Options#addOption(String, boolean, String)
         * @see Options#addOption(String, String, boolean, String)
         */
    }

    @Override
    public void setup(CommandLine cmd, File configFile) {
        // TODO: 09.01.2021 add loglevel to default config file
    }

    @Override
    public void main(CommandLine cmd, File configFile) {
        LOGGER.log("Updating log level...");
        try {
            LOG_LEVEL = Integer.parseInt(this.ini.get("main", "log-level"));
            LOGGER = new Logger(Constants.PROGRAM_NAME, LOG_LEVEL);
        }
        catch (NumberFormatException e) {
            LOGGER.warn("Can't update log level: " + e.getMessage() + " Keeping default level (" + LOG_LEVEL + ").");
        }
        LOGGER.debug("Done.");

        // TODO: 09.01.2021 Start cli
    }
}
