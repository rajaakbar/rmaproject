# National Savings & Investments Regression Test

## Pre-reqs

You have followed the Automation Setup Guide document.
In short:-
1. JDK installed and JAVA_HOME path setup.
2. Eclipse installed (optional, but useful if editing/adding tests and steps).
3. Browser drivers downloaded and path setup.
4. Maven installed, M2_HOME path setup and settings.xml correct.
5. Copy of this project imported into eclipse or into own folder.

---

### Configuration options

####default test run

Run with **mvn clean verify** in cmdprompt from within the project folder

Uses chrome browser by default

Test results can be observed from the \target folder

####alternate browser

Run with **mvn clean verify -Dbrowser="marionette"** in cmdprompt from within the project folder

Choose from one of "chrome,	ie,	marionette,	phantomjs" where marionette = firefox

####selenium grid

Download the latest version of selenium-server-standalone-x.x.x.jar from [this_link](http://selenium-release.storage.googleapis.com/index.html)

Create hub.json from the below and place in same folder as above jar file:-
````
{
  "port": 3333,
  "newSessionWaitTimeout": -1,
  "servlets" : [],
  "withoutServlets": [],
  "custom": {},
  "capabilityMatcher": "org.openqa.grid.internal.utils.DefaultCapabilityMatcher",
  "throwOnCapabilityNotPresent": true,
  "cleanUpCycle": 5000,
  "role": "hub",
  "debug": false,
  "browserTimeout": 0,
  "timeout": 1800
}
````

Create node.json from below and place in same folder as above:-
````
{
  "capabilities":
  [
    {
    "platform": "WINDOWS",
      "browserName": "firefox",
      "maxInstances": 2,
      "seleniumProtocol": "WebDriver"
    },
    {
    "platform": "WINDOWS",
      "browserName": "chrome",
      "maxInstances": 2,
      "seleniumProtocol": "WebDriver"
    },
    {
    "platform": "WINDOWS",
      "browserName": "internet explorer",
      "maxInstances": 2,
      "seleniumProtocol": "WebDriver"
    }
  ],
  "proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
  "maxSession": 5,
  "port": 5555,
  "register": true,
  "registerCycle": 5000,
  "hub": "http://localhost:3333/grid/register",
  "nodeStatusCheckTimeout": 5000,
  "nodePolling": 3000,
  "role": "node",
  "unregisterIfStillDownAfter": 60000,
  "downPollingLimit": 2,
  "debug": false,
  "servlets" : [],
  "withoutServlets": [],
  "custom": {},
  "host": "localhost",
  "register": true,
  "hubPort": 3333,
  "hubHost": "localhost"
}
````

From this folder
1. execute **java -jar selenium-server-standalone-x.x.x.jar -role hub -hubConfig hub.json** to start the grid hub
2. execute **java -jar selenium-server-standalone-3.6.0.jar -role node -nodeConfig node.json** to start the nodes, giving us 2 instances each of ie, chrome and firefox

Run with **mvn clean verify -Dbrowser="iphone7" -Dgridon="y"** in cmdprompt from within the project folder

Choose from one of "chrome, ie, marionette, iphone7, galaxys7, safari10"

The iphone7, galaxys7 and safari10 devices are emulated from chrome devtools mobile emulation using the specific pixel density, resolution and useragent settings.