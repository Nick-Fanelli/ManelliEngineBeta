package com.manelliengine.engine;

import com.manelliengine.engine.game.Game;

public class Error {
	

	public static void error(String data) {
		System.err.println("Manelli Engine | " + data);
	}
	
	public static void exit(ExitCode exitcode) {
		System.out.println("Application Exited With Code: " + "[ExitCode." + exitcode.toString() + "]");
		Game.cleanUp(exitcode);
	}
	
}
