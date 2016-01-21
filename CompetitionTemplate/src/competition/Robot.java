
package competition;

import java.io.File;

import competition.operatorinterface.OperatorInterfaceCommandMap;
import competition.subsystems.SubsystemDefaultCommandMap;
import xbot.common.command.BaseRobot;
import xbot.common.command.scripted.ScriptedCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends BaseRobot {
    ScriptedCommand autoCommand;
    
	@Override
	protected void initializeSystems() {
		super.initializeSystems();
		this.injector.getInstance(SubsystemDefaultCommandMap.class);
		this.injector.getInstance(OperatorInterfaceCommandMap.class);
    }
	
	@Override
    public void autonomousInit() {
	    autoCommand = new ScriptedCommand(
                xScheduler,
                new File("/home/lvuser/scripts/TestAuto.js"),
                injector.getInstance(AutoCommandFactory.class));
	    
	    xScheduler.add(autoCommand);
	}
	
	@Override
	public void autonomousPeriodic() {
	    super.autonomousPeriodic();
	}
	
	@Override
	public void disabledInit() {
	    if(autoCommand != null)
	        autoCommand.cancel();
	}
}
