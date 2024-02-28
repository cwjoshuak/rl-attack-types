package com.cwjoshuak;

import com.google.inject.Provides;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import static com.cwjoshuak.WeaponStyle.*;

@Slf4j
@PluginDescriptor(
	name = "Attack Types",
	description = "Show your current attack type as an overlay",
	tags = {"combat", "defence", "magic", "overlay", "ranged", "strength", "slash", "stab", "crush", "attack style", "attack type"}
)
public class AttackTypesPlugin extends Plugin
{
	private int equippedWeaponTypeVarbit = -1;

	@Getter(AccessLevel.PACKAGE)
	@Nullable
	private AttackType attackType;
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private AttackTypesOverlay overlay;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (event.getVarpId() == VarPlayer.ATTACK_STYLE
			|| event.getVarbitId() == Varbits.EQUIPPED_WEAPON_TYPE
			|| event.getVarbitId() == Varbits.DEFENSIVE_CASTING_MODE)
		{
			final int currentAttackStyleVarbit = client.getVarpValue(VarPlayer.ATTACK_STYLE);
			final int currentEquippedWeaponTypeVarbit = client.getVarbitValue(Varbits.EQUIPPED_WEAPON_TYPE);
			final int currentCastingModeVarbit = client.getVarbitValue(Varbits.DEFENSIVE_CASTING_MODE);

			equippedWeaponTypeVarbit = currentEquippedWeaponTypeVarbit;
			updateAttackStyle(equippedWeaponTypeVarbit, currentAttackStyleVarbit, currentCastingModeVarbit);
		}
	}
	private void updateAttackStyle(int equippedWeaponType, int attackStyleIndex, int castingMode)
	{
		WeaponStyle weaponStyle = null;
		WeaponStyle[] weaponStyles = WeaponType.getWeaponType(equippedWeaponType).getWeaponStyles();
		AttackType[] attackTypes = WeaponAttackType.getWeaponAttackType(equippedWeaponType).getAttackTypes();
		if (attackStyleIndex < weaponStyles.length)
		{
			weaponStyle = weaponStyles[attackStyleIndex];
		}
		if (attackStyleIndex < attackTypes.length)
		{
			attackType = attackTypes[attackStyleIndex];
		}

		if (attackType == null)
		{
			attackType = AttackType.NONE;
		}
		else if (weaponStyle == CASTING && castingMode == 1)
		{
			attackType = AttackType.MAGIC;
		}
	}
}
