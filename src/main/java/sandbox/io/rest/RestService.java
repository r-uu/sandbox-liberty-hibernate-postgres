package sandbox.io.rest;

import java.util.List;
import java.util.Map;

import de.ruu.lib.util.SystemProperties;
import jakarta.inject.Inject;

public class RestService
{
	@Inject private TimeStampProvider timeStampProvider;
	@Inject private EventDAO eventDAO;

	public Map<String, String> getSystemProperties()
	{
		return SystemProperties.asOrderedMap();
	}

	public String getTimestamp()
	{
		return timeStampProvider.getTimeStamp();
	}

	public List<Event> createEventAndGetList()
	{
		eventDAO.createEvent(new Event("name", "location", timeStampProvider.getTimeStamp()));
		return eventDAO.readAllEvents();
	}
}