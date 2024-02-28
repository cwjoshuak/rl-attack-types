package com.cwjoshuak;

enum AttackType
{
	CRUSH("Crush"),
	SLASH("Slash"),
	STAB("Stab"),
	RANGED("Ranged"),
	MAGIC("Magic"),
	NONE("None");

	private final String name;

	AttackType(String name) { this.name = name; }

	public String getName() { return name; }
}
