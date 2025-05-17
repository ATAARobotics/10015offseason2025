package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.localization.PoseUpdater;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.BezierPoint;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.pedropathing.util.Constants;
import com.pedropathing.util.DashboardPoseTracker;
import com.pedropathing.util.Drawing;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;

/**
 * Autonomous Barrel Racing from FTC Alberta Spring 2025 Challenges.
 * Robot follows a cloverleaf pattern, weaving around three barrels.
 */

@Config
@Autonomous(name="Barrel Racing", group = "FTC Alberta Spring Challenges")
public class BarrelRacing extends OpMode {
    private PoseUpdater poseUpdater;
    private DashboardPoseTracker dashboardPoseTracker;
    private Telemetry telemetryA;
    public static double RADIUS = 15;
    private Follower follower;
    private Timer pathTimer;
    private double pathTime = 0;
    private final Pose startPose = new Pose(135, 72, Math.toRadians(180));  // Starting position
    private final Point barrel1 = new Point(72, 48);
    private final Point barrel2 = new Point(72, 96);
    private final Point barrel3 = new Point(24, 72);

    @Override public void init() {
        pathTimer = new Timer();
        Constants.setConstants(FConstants.class, LConstants.class);
        poseUpdater = new PoseUpdater(hardwareMap, FConstants.class, LConstants.class);
        dashboardPoseTracker = new DashboardPoseTracker(poseUpdater);
//        poseUpdater.setStartingPose(startPose); // TODO: dashboard shows incorrect starting pose on the field
        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);
        follower.setStartingPose(startPose);
        // build path
        PathChain raceTrack = follower.pathBuilder()
                // First barrel
                .addPath(new BezierLine(new Point(startPose),new Point(barrel1.getX(),barrel1.getY()+RADIUS)))
                /*
                .addPath(new BezierCurve(new Point(barrel1.getX(),barrel1.getY()+RADIUS),
                        new Point(barrel1.getX()-RADIUS-3, barrel1.getY()+RADIUS-2),
                        new Point(barrel1.getX()-RADIUS, barrel1.getY()-RADIUS),
                        new Point(barrel1.getX(), barrel1.getY()-RADIUS)))
                // Second barrel
                .addPath(new BezierCurve(new Point(barrel1.getX(), barrel1.getY()-RADIUS),
                        new Point(barrel1.getX()+RADIUS+22, barrel1.getY()),
                        new Point(barrel2.getX()-RADIUS-22, barrel2.getY()),
                        new Point(barrel2.getX(), barrel2.getY()+RADIUS)))
                .addPath(new BezierCurve(new Point(barrel2.getX(), barrel2.getY()+RADIUS),
                        new Point(barrel2.getX()+RADIUS, barrel2.getY()+RADIUS),
                        new Point(barrel2.getX()+RADIUS+4, barrel2.getY()-6),
                        new Point(barrel2.getX(), barrel2.getY()-RADIUS-1)))
                // Third barrel & park
                .addPath(new BezierCurve(new Point(barrel2.getX(), barrel2.getY()-RADIUS-1),
                        new Point(barrel3.getX()+RADIUS-5, barrel3.getY()-RADIUS-6),
                        new Point(barrel3.getX()-RADIUS+1, barrel3.getY()-RADIUS-2),
                        new Point(barrel3.getX()-RADIUS+1, barrel3.getY())))
                .addPath(new BezierCurve(new Point(barrel3.getX()-RADIUS+1, barrel3.getY()),
                        new Point(barrel3.getX()-RADIUS+1, barrel3.getY()+RADIUS+4),
                        new Point(barrel3.getX()+2, barrel3.getY()+RADIUS+2),
                        new Point(startPose.getX()-10, startPose.getY())))
                */
                .build();
        follower.followPath(raceTrack,1.0,true);
        telemetryA = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetryA.addLine("This will run in a roughly cloverleaf pattern of radius " + RADIUS
                + ", starting on the bottom-most edge. So, make sure you have enough "
                + "space to the front to run the OpMode.");
        telemetryA.update();
        Drawing.drawRobot(poseUpdater.getPose(), "#4CAF50");
        Drawing.sendPacket();
    }

    @Override public void start() {
        pathTimer.resetTimer();
    }

    @Override public void loop() {
        poseUpdater.update();
        dashboardPoseTracker.update();
        follower.update();
        follower.telemetryDebug(telemetryA);
        if(!follower.isBusy()) {
            if (pathTime == 0)
                pathTime = pathTimer.getElapsedTimeSeconds();
            telemetryA.addData("path time", pathTime);
            telemetryA.update();
            requestOpModeStop();
        }
        Drawing.drawPoseHistory(dashboardPoseTracker, "#4CAF50");
        Drawing.drawRobot(poseUpdater.getPose(), "#4CAF50");
        Drawing.sendPacket();
    }
}