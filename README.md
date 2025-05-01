# 10015 Hyper Droid Offseason

This is the FTC SDK version 10.2 (as the "upstream" remote) with code for our offseaon
project of programming Dubble Bubble from the ground up.

To use it on a local copy of Android Studio:

- start Android Studio
- if it opens up a project, select "File -> Close Project"
- you should now see a "Welcome to Android Studio" dialog
- click the "Clone Repository" (or "Get from VCS") button
- on the left of the dialog that comes up, click "GitHub (no accounts)"
- click "Log In via GitHub"
- your Web browser should launch, click "Authorize Github" (or "Authorize JetBrains")
- you can now search for "10015offseason2025" in the list, and there should be one repository
  (If this one is not found, send your GitHub username to one of the mentors on Slack you may not have access yet)
- click "Clone"
- Now the Android Studio project view should open (after "cloning" is finished)
- There may be a "Trust project?" dialog; say yes.

## Work on The Code

Under "TeamCode" you can keep navigating to "TeleOp.java":

- ``TeamCode/src/main/java/org/firstinspires/ftc/teamcode/TeleOp.java``

This ``TeleOp.java`` originally comes from one of the examples (all the
examples are under the directory:

- ``FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/``

There are many ways to approach Op-Modes. The way we use repeatedly
calls "loop()" -- see the comments in the code. You should be able to
build the repository right now (and push it to Dubble Bubble. It won't
do much, but will show "Hello, world!" in the telemetry.

Writing a "Hello, world!" program is a classic first step.

Once this all works and you're comfortable pushing code to the robot
and running it, replace the comments with real code.

I have already installed FTCLib and FTCDashboard for use.



## Installation Notes

This should go into our "standard operating procedures".
These are the steps followed to create a new project based off the FTC SDK.

1. create a blank/bare GitHub repository (at ATAA: need Robert to do this)
2. clone it locally (it will be "empty")
3. Find the FTC SDK repository, and add it as "upstream" remote:

    git remote add -f upstream https://github.com/FIRST-Tech-Challenge/FtcRobotController.git

4. check out the latest version:

    git checkout upstream/master

There will be a warning about "unattached", that's fine.

5. make "our" main branch match the FTC SDK:

    git branch main
    git push

6. Make edits (e.g. this README) as appropriate, commit and push

    git add -a
    git commit -m "prepare for 10015 use"
    git push

7. Install FTCLib, FTCDashboard, ...

## Pedro Pathing

Follow the steps on their [website](https://pedropathing.com/) to tune and setup!  

