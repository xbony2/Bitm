package sheenrox82.RioV.src.api.util;

import java.util.ArrayList;

import sheenrox82.RioV.src.api.base.RioVAPI;


public class Sound {

	private String name;
	private boolean mob;
	private boolean item;

	public Sound(String name){
		this(name, false, false);
	}

	public Sound(String name, boolean mob){
		this(name, mob, false);
	}

	public Sound(boolean item, String name){
		this(name, false, item);
	}

	private static ArrayList<Sound> sounds = new ArrayList<Sound>();

	public Sound(String name, boolean mob, boolean item){
		this.name = name;
		this.mob = mob;
		this.item = item;
		sounds.add(this);
	}

	public String getName(){
		return name;
	}

	public String getPrefixedName(){
		return RioVAPI.mod_id + ":" + name;
	}

	public boolean isMob(){
		return mob;
	}

	public boolean isItem(){
		return item;
	}
}