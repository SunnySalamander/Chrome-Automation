# Chrome-Automation
Using Selenium with Java to automate opening Google Chrome and going to a specific page then signing in with a specific account.
--------------------------------------------------------------------------------------------
🖥️╰(*°▽°*)╯
---------------------------------------------------------------------------------------------
Copy demo to your machine first, Do not modify the one on the software share until you are sure your code runs in the vdi.

To edit the app, open the folder named "demo" with Visual Studio or Visual Studio code. 

You will need the Maven extensions and Java extensions installed in VS code. You will need to install Maven as well.

Changes are to be made in App.java, which is located in "demo\src\main\java\com\example"

And then you will have to compile a new executable jar. To do this, run:

mvn clean compile assembly:single

in the demo directory.

IF YOU HAVE ERRORS WHEN TRYING TO COMPILE A NEW JAR:
close VS code, open task manager, end tasks: Application Frame Host, chromedriver.exe. Open VS code, run compile command again.

Sometimes changes may have to be made in pom.xml, which is Maven's project config file and is needed to load the dependencies etc.

The library used to control the browser and open the BD Viewer site is called Selenium.


- Giselle
