package competition;

import com.google.inject.Inject;

import competition.subsystems.drive.DriveSubsystem;
import xbot.common.command.BaseCommand;

public class TankDriveForTimeCommand extends BaseCommand {
    DriveSubsystem driveSubsystem;
    double leftVal;
    double rightVal;
    double time;
    
    @Inject
    public TankDriveForTimeCommand(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;
    }
    
    public void setTargets(double time, double leftVal, double rightVal) {
        this.time = time;
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }
    
    @Override
    public void initialize() {
        driveSubsystem.tankDrive(leftVal, rightVal);
        this.setTimeout(time);
    }

    @Override
    public void execute() {
    }
    
    @Override
    public boolean isFinished() {
        return this.isTimedOut();
    }

}
