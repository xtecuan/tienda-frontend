## ${artifactId} WildFly JSF with CDI, JAX-RS, Microprofile-config and persistence bootable JAR project

This Project shows how to combine JSF, CDI, JAX-RS, Microprofile-config  and JPA. 

## Running the project
* Run: `shs/pack-run.sh` or `bats\pack-run.bat`


## Development mode (watch of your source files)
* Run: `shs/devmode-watch.sh` or `bats\devmode-watch.bat` (this goal builds your application, build an hollow bootable JAR and start it)
* Do changes in your sources, your application is rebuilt and redeployed.
* When done: Ctrl-C in the console to kill the running goal and bootable JAR.



## Developer Mode  (with re-packaging)
* Start devmode: `shs/devmode-start.sh` or `bats\devmode-start.bat`
* Make some code changes
* Publish changes: `shs/devmode-publish.sh` or `bats\devmode-publish.bat`
* Stop devmode: `shs/devmode-stop.sh` or `bats\devmode-stop.bat`
* Access devmode logs: `shs/devmode-logs.sh` or `bats\devmode-logs.bat`