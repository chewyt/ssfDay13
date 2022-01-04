package chewyt.project;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

// import org.springframework.boot.ApplicationArguments;
// import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SsfDay13Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SsfDay13Application.class);
		// ApplicationArguments cliOpts = new DefaultApplicationArguments(args);
		String dir = "";
		// For this execise, we are accepting the cli args in the form of --dataDir
		// /opt/tmp/data

		int i = 0;
		while (i < args.length) {
			switch (args[i]) {
				case "--dataDir":
					if (args.length > 1) {
						dir = args[i + 1];
					}

					break;

			}
			i++;
		}
		if (dir.equals("")) {
			System.err.println("--dataDir option not specified");
			System.exit(1);
		} else {
			System.out.println("Directory specified is " + dir);
		}

		// Only possible if input fields is in the form of --dataDir=opt/temp/data
		// --dataDir=/static/
		// if (cliOpts.containsOption("dataDir")) {
		// dir = cliOpts.getOptionValues("dataDir").get(0);
		// } else {
		// System.err.println("--dataDir option not specified");
		// System.exit(1);
		// }
		// SpringApplication.run(SsfDay13Application.class, args);
		System.out.printf("Application started... Directory is %s\n", dir);

		Path p = Paths.get(dir);
		File folder = p.toFile();
		if (!folder.exists()) {
			folder.mkdir();
			System.out.printf("Folder directory %s is created", dir);
		} else {
			System.out.printf("Loading existing Folder directory %s....", dir);
		}

		app.run(args);
	}

}
