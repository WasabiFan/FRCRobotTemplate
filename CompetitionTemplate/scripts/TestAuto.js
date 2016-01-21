robot.requireCommands('TankDriveForTime');

var invokedCommand = robot.invokeTankDriveForTime(0.5, 0.5, 0.5);
invokedCommand.waitForCompletion();