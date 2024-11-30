[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=12069044&assignment_repo_type=AssignmentRepo)
# CS-2003-Lab-6

## Overview
For this lab, we will be implementing the K-Min algorithm, also referred to as the kth smallest problem.

Inputs for this lab are provided over STDIN and use the following format.
- A single line with a single integer `q` indicating the number of queries followed by `q` queries, where each query is two lines.
- The first line of each query is a pair of space-separated integers `n` and `k`, where `n` is the size of the input list and `k` is the desired kth minimum.
- The second line is `n` space-separate integers that constitute the input list.

For each query, the program must output the kth minimum of the given list as a single line containing the solution.

## Assignment
Solve the kth smallest problem for an `List<E extends Comparable>` using a recursive algorithm. To do so, you must compute the kth smallest element in the list. That is, if k = 1, you must compute the smallest element in the list. If k = 2, you must compute the second smallest element in the list. This continues for all k <= n, where n is the number of elements in the list (`list.size()`).

Credit will be awarded for valid solutions that can correctly compute the kth smallest element in a list for all k from 1 to n, where n is the size of the list. In addition, the solution must use a recursive algorithm to be valid. Otherwise, no credit will be awarded.

Lastly, solutions that change the list in any way (including sorting) will not receive full credit (copies are permitted). Implicit data structures and the use of a non-variable number of parameters are also suitable for full credit.

## Submission
The assignment is due by the end-of-day Friday of the following week.

*To submit your work, please review the **Commits** section below.*

## Grading Rubric
- [ ] (30pts) Can recursively find the kth min
- [ ] (30pts) Can recursively find the kth min with no side effects
- [ ] (40pts) Can compute the kth min given inputs on STDIN

## Compiling and Testing Code
Your IDE should provide tools to compile your code. If you're unfamiliar with that process, you can research it online or ask. Most developers compile their code from command line using a shell script, such as a **Makefile** or build script (**build.sh**). I've provided build scripts for you in both *Powershell* and *Bash*. Refer to the following directions on how to use these scripts based on the terminal that you're using. If you're on Windows, please use Windows Subsystem for Linux (WSL), Git Bash, or Powershell, not Command Prompt.

### Windows Users (Powershell)
- To compile your code: `./build.ps1`
- To compile and run your code: `./build.ps1 run` (forwards clargs to program)
- To compile and test your code: `./build.ps1 test` (forwards clargs to TUGrader)
- To format your code: `./build.ps1 fmt`
- To sync your code: `./build.ps1 sync`
- To submit your code: `./build.ps1 submit`
- To remove class files: `./build.ps1 clean`

### Windows Users (WSL, Git Bash), Mac and Linux Users
- To compile your code: `./build.sh`
- To compile and run your code: `./build.sh run` (forwards clargs to program)
- To compile and test your code: `./build.sh test` (forwards clargs to TUGrader)
- To format your code: `./build.sh fmt`
- To sync your code: `./build.sh sync`
- To submit your code: `./build.sh submit`
- To remove class files: `./build.sh clean`

These scripts use the following commands. Note that Windows users need to replace the colon with a semicolon in the Java classpath.
- To compile a Java file: `javac -d target -cp lib/*:src <filepath>.java`
- To execute a Java file: `java -cp lib/*:target <package-path>.<filename>`
- To format a Java file: `java -jar lib/google-java-format.jar --replace --skip-javadoc-formatting <filepath>.java`
- To remove class files: `rm -r target/*`

## Code Style
All code should follow the [Google Java style guidelines](https://google.github.io/styleguide/javaguide.html). If you find anything in the code that does not follow the style guidelines, feel free to fix it, but you are not required to do so. Only your handwritten code will be evaluated for its style. You do not need to follow the style guidelines to the letter but egregious deviations from the style guidelines will be penalized. A submission that passes all test cases but does not use an appropriate style will not receive an A for the assignment.

For those using an IDE, such as Eclipse or VS Code, the IDE should provide a formatting tool. I've included the XML specification of the Google Java Style Guidelines at `.vscode/java-google-style.xml`. You can configure your IDE to use the provided XML as its formatting rules to format your code to the Google Java Style Guidelines, which are the industry standard.

If you're working from command-line, [google-java-format](https://github.com/google/google-java-format) is an open-source formatting tool that you can use to format your files. You can use the following commands to format your code depending on your terminal.
- `./build.ps1 fmt`
- `./build.sh fmt`

## Commits
Commits should be made incrementally. Many commits are always better than few, and commits can always be squashed together later if there are too many. You should try to make a commit every time you've made tangible progress in the development of your code.

Every commit should have a commit message. The standard format for commit messages is to start with a verb in present-tense followed by a concise message (typically less than 50 characters) that summarizes the change that the commit is introducing to the repo. For example, "Updates README", "Implements Array", "Passes testGet".

Popular IDEs, such as Eclipse and VS Code, provide integrated Git tools. If you're on Windows, you can install Git Bash or Windows Subsystem for Linux (WSL). If you're on Mac or Linux, you already have git installed.

If you've just installed git, it will need to be configured. The easy way to configure git is from a terminal. Use the following commands.
- `git config --global user.name "<github-username-goes-here>"`
- `git config --global user.email "<github-email-goes-here>"`
- `git config --global pull.rebase true` (optional)
- `git config --global fetch.prune true` (optional)
- `git config --global diff.colorMoved zebra` (optional)

To sync changes made from another device, use the following command.
- `git fetch origin main`
- `git pull origin main`

To push commits from command line, use the following commands.
- `git add -A`
- `git commit -m "<your message goes here>"`
- `git push origin main`

You can also sync all changes and submit with the following commands depending on your terminal.
- `./build.ps1 submit`
- `./build.sh submit`
