package com.cwjoshuak;

import lombok.Getter;
import net.runelite.api.Skill;

enum WeaponStyle
{
	ACCURATE("Accurate", Skill.ATTACK),
	AGGRESSIVE("Aggressive", Skill.STRENGTH),
	DEFENSIVE("Defensive", Skill.DEFENCE),
	CONTROLLED("Controlled", Skill.ATTACK, Skill.STRENGTH, Skill.DEFENCE),
	RANGING("Ranging", Skill.RANGED),
	LONGRANGE("Longrange", Skill.RANGED, Skill.DEFENCE),
	CASTING("Casting", Skill.MAGIC),
	DEFENSIVE_CASTING("Defensive Casting", Skill.MAGIC, Skill.DEFENCE),
	OTHER("Other");

	@Getter
	private final String name;
	@Getter
	private final Skill[] skills;

	WeaponStyle(String name, Skill... skills)
	{
		this.name = name;
		this.skills = skills;
	}
}
