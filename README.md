# World of Airports

In short, this application is using pulls data about airports from a Cloudant database and
displays their location in a simple list, sorted by distance.


## Requirements

#### **Java JDK 1.8.0<=**
1. Check actual version with the following command: `java -version`. If it is not installed:
    * [Link to download](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    * [Installation guide](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
2. Check environmental variables are set properly with command :
    * [Set](https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/) `JAVA_HOME` variable.
    * [Set](https://www.java.com/en/download/help/path.xml) `Path` variable for the installed jdk bin folder.

#### **Apache Maven 3.3.9<=**

1. [Link to download](https://maven.apache.org/download.cgi)
2. [Installation guide](https://maven.apache.org/install.html)


## Build
### How to download, build and start AirportsApp

#### Download this git repo

You can clone/download directly this repository
1. If you have git bash, you can clone with the following command:
``~$ git clone https://github.com/mojito317/cloudant.git``
2. If not, you can download the zipped project directly from
[this link](https://github.com/mojito317/cloudant/archive/master.zip). You have to unzip it before further steps.

#### Build AirportsApp

1. Open command prompt/terminal and change folder to where you downloaded the program:
``cd [place of download]/cloudant``
2. Build the program with the help of maven:
``mvn package``
    * If everything went well you must get a message with `BUILD SUCCESS` in it, something like this:
    ![build success](img/build_success.png)

## Run

1. Open command prompt/terminal and change folder to target/classes:
``cd target/classes``
2. Run Main class with three double numbers.
  * The first number represents the **radius**,
  * the second the **latitude**
  * the third the **longitude**
  * E. g. when we want 5 degree radius, from 53.630389 degree latitude and 9.988228 degree longitude we should type the following:
    ``java Main 5.0 53.630389 9.988228``
