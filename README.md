
# Static code analysis - Java

Static code analysis helps identify bad/error prone code earlier, and follow a consistent coding practice & style.
3 different ways the static-code analysis are performed on the code.
1. Enforce coding convention
2. Define coding practices
3. Identify potential bugs

This sample project uses Maven Java project to configure define static-code analysis. It uses PMD, Checkstyle & SpotBugs tools.

These tools are executed in the `validate` phase of Maven, in the order they are defined in pom.xml.
## PMD

The PMD is a static code analysis that finds bad codes like, empty catch statements, unused variables, unorganized imports, object creation among many others.
It also has Copy-Paste-Detector (cpd) that finds out duplicated (copied) codes.
Both PMD and CPD are configure in this project.
* `check` goal fails the build when any code violations are found.
* `cpd-check`, fails the build when any cpd violations are found.
PMD uses rulesets (xml files) that can applied in the code analysis. This project has 5 predefined ruleset 
* bestpractices
* errorprone
* security
* multithreading
* performance
This plugin runs as part of the `mvn install` before test phase. This also can be separately invoked with the command `mvn pdm:check` to identify and fail the build or `mvn pmd:pmd` to generate the report but passing the build.

## Checkstyle
Checkstyle tool is a tool to enforce developers to follow & adhere coding standard.
The Checkstyle, by default, is provided with two conventions commonly followed, [Sun Code Convention](https://www.oracle.com/technetwork/java/javase/documentation/codeconvtoc-136057.html) & [Google Code Convention ](https://checkstyle.org/styleguides/google-java-style-20170228.html)
This project is configured with Checkstyle Maven plugin to run as part of the project build. 
Checkstyle also can be invoked individually with the command `mvn checkstyle:check` to identify the code and fail the build when violations are found, or `mvn checkstyle:checkstyle` to generate HTML report - this not failing the build.
`google_checks.xml` is predefined convention configured in this project.
## FindBugs
FindBugs is a static code analysis tool to identify potential bugs in the code. This plugin runs as part of project build. This also can be invoked separately with the command `mvn findbugs:findbugs` to identify the bugs and generate report simultaneously not failing the build, or `mvn findbugs:check` to analyse code for bugs and fail if any violations are found.


## google-java-format
This is a tool to format the code to Google style 
This tool can be configure in Java projects in different ways, one way is to have pre-commit hook that triggers this plugin to format the modified Java files during git commit.
`maven-git-code-format` that registers a pre-commit hook with a script (.git/hooks/{project_name}.maven-git-code-format.sh) which is triggered when the developer commits the changes.

## When not to format?
There are times it isn't good to format the code, for example, the files that are not part of the current changeset shouldn't be format even if the files do not conform to the standards.
In case code analysis is configured to a large code base has lots of violations, introduce changes with small proportion by excluding the old files from formatting.
This unnecessary code format can bring additional challenges in code reviews.

### TODO
- [ ] configure client-side pre-commit hook to run the fmt plugin
