# ${artifactId}
${artifactId} (WildFly Bootable JAR)

## Building the project

* Clone this repository project.
* Do: `mvn clean install -DskipTests`

## Running the project

* Do: `cd ${artifactId}-web`
* Run: `shs/pack-run.sh` or `bats\pack-run.bat`


## Development mode (watch of your source files)
* Do: `cd ${artifactId}-web`
* mvn wildfly-jar:dev-watch (this goal builds your application, build an hollow bootable JAR and start it)
* Do changes in your sources, your application is rebuilt and redeployed.
* When done: Ctrl-C in the console to kill the running goal and bootable JAR.



## Developer Mode  (with re-packaging)
* Do: `cd ${artifactId}-web`
* Start devmode: `shs/devmode-start.sh` or `bats\devmode-start.bat`
* Make some code changes
* Publish changes: `shs/devmode-publish.sh` or `bats\devmode-publish.bat`
* Stop devmode: `shs/devmode-stop.sh` or `bats\devmode-stop.bat`
* Access devmode logs: `shs/devmode-logs.sh` or `bats\devmode-logs.bat`
