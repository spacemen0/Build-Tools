import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.IOException;

@Mojo(name = "run-server")
public class RunServerMojo extends AbstractMojo {

    @Parameter(property = "executablePath", required = true)
    private String executablePath;

    public void execute() throws MojoExecutionException{
        getLog().info("Running server executable: " + executablePath);
        try {
            Runtime.getRuntime().exec(executablePath);
        }
        catch (IOException e) {
            throw new MojoExecutionException("Error running server executable", e);
        }
    }
}

