package sandbox.io.rest;

import de.ruu.lib.util.Time;

public class TimeStampProviderMilliseconds implements TimeStampProvider
{
	@Override public String getTimeStamp() { return Time.getSortableTimestamp(); }
}