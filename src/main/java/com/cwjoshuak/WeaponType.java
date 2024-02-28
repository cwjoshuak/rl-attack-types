package com.cwjoshuak;

import com.google.common.base.Preconditions;
import lombok.Getter;

enum WeaponType
{
	UNARMED(0, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, null, WeaponStyle.DEFENSIVE),
	AXE(1, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, WeaponStyle.AGGRESSIVE, WeaponStyle.DEFENSIVE),
	BLUNT(2, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, null, WeaponStyle.DEFENSIVE),
	BOW(3, WeaponStyle.RANGING, WeaponStyle.RANGING, null, WeaponStyle.LONGRANGE),
	CLAW(4, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, WeaponStyle.CONTROLLED, WeaponStyle.DEFENSIVE),
	CROSSBOW(5, WeaponStyle.RANGING, WeaponStyle.RANGING, null, WeaponStyle.LONGRANGE),
	SALAMANDER(6, WeaponStyle.AGGRESSIVE, WeaponStyle.RANGING, WeaponStyle.CASTING, null),
	CHINCHOMPA(7, WeaponStyle.RANGING, WeaponStyle.RANGING, null, WeaponStyle.LONGRANGE),
	GUN(8, WeaponStyle.OTHER, WeaponStyle.AGGRESSIVE, null, null),
	SLASH_SWORD(9, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, WeaponStyle.CONTROLLED, WeaponStyle.DEFENSIVE),
	TWO_HANDED_SWORD(10, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, WeaponStyle.AGGRESSIVE, WeaponStyle.DEFENSIVE),
	PICKAXE(11, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, WeaponStyle.AGGRESSIVE, WeaponStyle.DEFENSIVE),
	POLEARM(12, WeaponStyle.CONTROLLED, WeaponStyle.AGGRESSIVE, null, WeaponStyle.DEFENSIVE),
	POLESTAFF(13, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, null, WeaponStyle.DEFENSIVE),
	SCYTHE(14, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, WeaponStyle.AGGRESSIVE, WeaponStyle.DEFENSIVE),
	SPEAR(15, WeaponStyle.CONTROLLED, WeaponStyle.CONTROLLED, WeaponStyle.CONTROLLED, WeaponStyle.DEFENSIVE),
	SPIKED(16, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, WeaponStyle.CONTROLLED, WeaponStyle.DEFENSIVE),
	STAB_SWORD(17, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, WeaponStyle.AGGRESSIVE, WeaponStyle.DEFENSIVE),
	STAFF(18, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, null, WeaponStyle.DEFENSIVE, WeaponStyle.CASTING, WeaponStyle.DEFENSIVE_CASTING),
	THROWN(19, WeaponStyle.RANGING, WeaponStyle.RANGING, null, WeaponStyle.LONGRANGE),
	WHIP(20, WeaponStyle.ACCURATE, WeaponStyle.CONTROLLED, null, WeaponStyle.DEFENSIVE),
	BLADED_STAFF(21, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, null, WeaponStyle.DEFENSIVE, WeaponStyle.CASTING, WeaponStyle.DEFENSIVE_CASTING),
	/**
	 * The displayed category is "2h sword", the same as {@link #TWO_HANDED_SWORD}, but uses a different var value than
	 * other two-handed swords. At present, the five godswords are the only weapons known to use this type.
	 */
	TWO_HANDED_SWORD_GODSWORD(22, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, WeaponStyle.AGGRESSIVE, WeaponStyle.DEFENSIVE),
	POWERED_STAFF(23, WeaponStyle.CASTING, WeaponStyle.CASTING, null, WeaponStyle.DEFENSIVE_CASTING),
	BANNER(24, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, WeaponStyle.CONTROLLED, WeaponStyle.DEFENSIVE),
	/**
	 * The displayed category is "Polearm", the same as {@link #POLEARM}, but uses a different var value than other
	 * polearms. At present, the crystal halberd is the only weapon known to use this type.
	 */
	POLEARM_CRYSTAL_HALBERD(25, WeaponStyle.CONTROLLED, WeaponStyle.AGGRESSIVE, null, WeaponStyle.DEFENSIVE),
	BLUDGEON(26, WeaponStyle.AGGRESSIVE, WeaponStyle.AGGRESSIVE, null, WeaponStyle.AGGRESSIVE),
	BULWARK(27, WeaponStyle.ACCURATE, null, null, WeaponStyle.OTHER),
	/**
	 * This weapon type is unused outside of the Tumeken's heka, which was only available in beta testing.
	 */
	POWERED_WAND(28, WeaponStyle.CASTING, WeaponStyle.CASTING, null, WeaponStyle.DEFENSIVE_CASTING),
	PARTISAN(29, WeaponStyle.ACCURATE, WeaponStyle.AGGRESSIVE, WeaponStyle.AGGRESSIVE, WeaponStyle.DEFENSIVE);

	@Getter
	private final WeaponStyle[] weaponStyles;

	WeaponType(int id, WeaponStyle... weaponStyles)
	{
		Preconditions.checkArgument(id == ordinal());
		Preconditions.checkArgument(weaponStyles.length == 4 || weaponStyles.length == 6,
			"WeaponType " + this + " does not have exactly 4 or 6 attack style arguments");
		this.weaponStyles = weaponStyles;
	}

	public static WeaponType getWeaponType(int id)
	{
		if (id < 0 || id > values().length)
		{
			return null;
		}

		return values()[id];
	}
}
