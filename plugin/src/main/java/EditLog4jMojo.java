import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.IOException;
import java.io.*;

@Mojo(name = "editLog4j2")
public class EditLog4jMojo extends AbstractMojo {

    @Parameter(property = "propertiesPath", required = true)
    private String propertiesPath;
    @Parameter(property = "logPath", required = true)
    private String logPath;

    public void execute() throws MojoExecutionException {
        try {
            File file = new File(propertiesPath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("appender.R.fileName = ")) {
                    line = "appender.R.fileName = " + logPath;
                }
                stringBuilder.append(line).append("\n");
            }
            reader.close();

            FileWriter writer = new FileWriter(file);
            writer.write(stringBuilder.toString());
            writer.close();
        } catch (IOException e) {
            throw new MojoExecutionException("Error: ", e);
        }
    }
}

