README File

Before you start do anything you must verify installed or no Apache Maven in your system
For this, if you use Linux:
	1. Open Terminal (for example in Linux Mint: press Alt+F2, input "terminal" and press Enter)
	2. Input into terminal: 
			mvn --version
	3. If you see any information like this:
			Apache Maven 3.0.4 
			Maven home: /usr/share/maven
		thats mean Apache Maven installed into your system
	4. If you see another information you must install Maven
		4.1. For this input into terminal
			sudo apt-get install maven
		4.2. This command will be work if you use Linux based on Debian
		4.3 If you use another Linux use command for installation packages and install maven
	5. If maven installed or you just install it you can work with this project.
	
Build and Run project and test
	1. Change active directory in terminal to directory where is the file pom.xml located
		for this use command "cd"
		(For example: cd /home/user/QNameProject)
	2. Next you can use few commands
		2.1. mvn compile - this command download all libs from Internet, compile and build project
		2.2. mvn test - build project and run all test for it
		2.3. mvn package - build project, run all test and if tests success build jar file with
			all necessary libs
		2.4. If any test is failure you can see it in terminal
		2.5. mvn test -e - use this command to see stack trace of error, if they are