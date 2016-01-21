package competition;

import com.google.inject.Inject;
import com.google.inject.Provider;

import xbot.common.command.BaseCommand;
import xbot.common.command.scripted.ScriptedCommandFactory;
import xbot.common.command.scripted.ScriptedCommandProvider;

public class AutoCommandFactory implements ScriptedCommandFactory {
    Provider<TankDriveForTimeCommand> tankDriveCommandGuiceProvider;
    
    @Inject
    public AutoCommandFactory(Provider<TankDriveForTimeCommand> tankDriveCommandGuiceProvider) {
        this.tankDriveCommandGuiceProvider = tankDriveCommandGuiceProvider;
    }
    
    @Override
    public ScriptedCommandProvider getProviderForName(String commandTypeName) {
        if(commandTypeName.equals("TankDriveForTime"))
            return new TankDriveForDistanceCommandProvider();
        
        return null;
    }
    
    public class TankDriveForDistanceCommandProvider implements ScriptedCommandProvider {

        @Override
        public BaseCommand get(Object[] parameters) {
            TankDriveForTimeCommand command = tankDriveCommandGuiceProvider.get();
            command.setTargets((double)parameters[0], (double)parameters[1], (double)parameters[2]);
            
            return command;
        }
        
    }

}
