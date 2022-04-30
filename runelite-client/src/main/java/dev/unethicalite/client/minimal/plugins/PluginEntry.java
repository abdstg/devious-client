package dev.unethicalite.client.minimal.plugins;

import dev.unethicalite.api.plugins.Script;
import lombok.Value;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Value
public class PluginEntry
{
	Class<? extends Plugin> scriptClass;
	PluginDescriptor meta;

	@Override
	public String toString()
	{
		return meta.name();
	}

	public boolean isScript()
	{
		return Script.class.isAssignableFrom(scriptClass);
	}
}
