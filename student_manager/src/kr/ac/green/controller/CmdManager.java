package kr.ac.green.controller;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.cmd.DeleteInfoCmd;
import kr.ac.green.cmd.ICmd;
import kr.ac.green.cmd.InsertCmd;
import kr.ac.green.cmd.InsertInfoCmd;
import kr.ac.green.cmd.MainCmd;
import kr.ac.green.cmd.SearchAllCmd;
import kr.ac.green.cmd.SearchOneDeleteCmd;
import kr.ac.green.cmd.SearchOneUpdateCmd;
import kr.ac.green.cmd.SendDeleteCmd;
import kr.ac.green.cmd.SendUpdateCmd;
import kr.ac.green.cmd.UpdateInfoCmd;

public class CmdManager {
	private static Hashtable<String, ICmd>cmds;
	
	public static void init(){
		cmds = new Hashtable<String, ICmd>();
		cmds.put("main", new MainCmd());
		cmds.put("insert", new InsertCmd());
		cmds.put("insertInfo", new InsertInfoCmd());
		cmds.put("searchOne_Update", new SearchOneUpdateCmd());
		cmds.put("updateInfo", new UpdateInfoCmd());
		cmds.put("sendUpdate", new SendUpdateCmd());
		cmds.put("searchOne_Delete", new SearchOneDeleteCmd());
		cmds.put("deleteInfo", new DeleteInfoCmd());
		cmds.put("sendDelete", new SendDeleteCmd());
		cmds.put("searchAll", new SearchAllCmd());
	}
	 
	public static void doAction(HttpServletRequest request, String cmd){
		cmds.get(cmd).action(request);
	}
}
