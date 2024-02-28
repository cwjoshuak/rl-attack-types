package com.cwjoshuak;

import com.google.common.base.Preconditions;
import lombok.Getter;

enum WeaponAttackType {
	UNARMED(0, AttackType.CRUSH, AttackType.CRUSH, null, AttackType.CRUSH),
	AXE(1, AttackType.SLASH, AttackType.SLASH, AttackType.CRUSH, AttackType.SLASH),
	BLUNT(2, AttackType.CRUSH, AttackType.CRUSH, null, AttackType.CRUSH),
	BOW(3, AttackType.RANGED, AttackType.RANGED, null, AttackType.RANGED),
	CLAW(4, AttackType.SLASH, AttackType.SLASH, AttackType.STAB, AttackType.SLASH),
	CROSSBOW(5, AttackType.RANGED, AttackType.RANGED, null, AttackType.RANGED),
	SALAMANDER(6, AttackType.SLASH, AttackType.RANGED, AttackType.MAGIC, null),
	CHINCHOMPA(7, AttackType.RANGED, AttackType.RANGED, null, AttackType.RANGED),
	GUN(8, AttackType.NONE, AttackType.CRUSH, null, null),
	SLASH_SWORD(9, AttackType.SLASH, AttackType.SLASH, AttackType.STAB, AttackType.SLASH),
	TWO_HANDED_SWORD(10, AttackType.SLASH, AttackType.SLASH, AttackType.CRUSH, AttackType.SLASH),
	PICKAXE(11, AttackType.STAB, AttackType.STAB, AttackType.CRUSH, AttackType.STAB),
	POLEARM(12, AttackType.STAB, AttackType.SLASH, null, AttackType.STAB),
	POLESTAFF(13, AttackType.CRUSH, AttackType.CRUSH, null, AttackType.CRUSH),
	SCYTHE(14, AttackType.SLASH, AttackType.SLASH, AttackType.CRUSH, AttackType.SLASH),
	SPEAR(15, AttackType.STAB, AttackType.SLASH, AttackType.CRUSH, AttackType.STAB),
	SPIKED(16, AttackType.CRUSH, AttackType.CRUSH, AttackType.STAB, AttackType.CRUSH),
	STAB_SWORD(17, AttackType.STAB, AttackType.STAB, AttackType.SLASH, AttackType.STAB),
	STAFF(18, AttackType.CRUSH, AttackType.CRUSH, null, AttackType.CRUSH, AttackType.MAGIC, AttackType.MAGIC),
	THROWN(19, AttackType.RANGED, AttackType.RANGED, null, AttackType.RANGED),
	WHIP(20, AttackType.SLASH, AttackType.SLASH, null, AttackType.SLASH),
	BLADED_STAFF(21, AttackType.STAB, AttackType.SLASH, null, AttackType.CRUSH, AttackType.MAGIC, AttackType.MAGIC),
	/**
	 * The displayed category is "2h sword", the same as {@link #TWO_HANDED_SWORD}, but uses a different var value than
	 * other two-handed swords. At present, the five godswords are the only weapons known to use this type.
	 */
	TWO_HANDED_SWORD_GODSWORD(22, AttackType.SLASH, AttackType.SLASH, AttackType.CRUSH, AttackType.SLASH),
	POWERED_STAFF(23, AttackType.MAGIC, AttackType.MAGIC, null, AttackType.MAGIC),
	BANNER(24, AttackType.STAB, AttackType.SLASH, AttackType.CRUSH, AttackType.STAB),
	/**
	 * The displayed category is "Polearm", the same as {@link #POLEARM}, but uses a different var value than other
	 * polearms. At present, the crystal halberd is the only weapon known to use this type.
	 */
	POLEARM_CRYSTAL_HALBERD(25, AttackType.STAB, AttackType.SLASH, null, AttackType.STAB),
	BLUDGEON(26, AttackType.CRUSH, AttackType.CRUSH, null, AttackType.CRUSH),
	BULWARK(27, AttackType.CRUSH, null, null, AttackType.NONE),
	/**
	 * This weapon type is unused outside of the Tumeken's heka, which was only available in beta testing.
	 */
	POWERED_WAND(28, AttackType.MAGIC, AttackType.MAGIC, null, AttackType.MAGIC),
	PARTISAN(29, AttackType.STAB, AttackType.STAB, AttackType.CRUSH, AttackType.STAB);
	@Getter
	private final AttackType[] attackTypes;
	WeaponAttackType(int id, AttackType... attackTypes)
	{
		Preconditions.checkArgument(id == ordinal());
		Preconditions.checkArgument(attackTypes.length == 4 || attackTypes.length == 6,
			"WeaponType " + this + " does not have exactly 4 or 6 attack style arguments");
		this.attackTypes = attackTypes;
	}
	public static WeaponAttackType getWeaponAttackType(int id)
	{
		if (id < 0 || id > values().length)
		{
			return null;
		}
		return values()[id];
	}
}
