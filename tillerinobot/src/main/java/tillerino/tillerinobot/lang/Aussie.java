package tillerino.tillerinobot.lang;

import java.util.List;
import java.util.Random;

import org.tillerino.osuApiModel.Mods;
import org.tillerino.osuApiModel.OsuApiUser;

import tillerino.tillerinobot.BeatmapMeta;
import tillerino.tillerinobot.IRCBot.IRCBotUser;
import tillerino.tillerinobot.RecommendationsManager.Recommendation;

public class Default implements Language {

	@Override
	public String unknownBeatmap() {
		return "U weedwhacker drongo that map aint old enough yet ya rathead.";
	}

	@Override
	public String internalException(String marker) {
		return "Looks like old m8 tillo got rekt, the pisshead."
				+ " If he doesn't notice soon, could you [https://github.com/Tillerino/Tillerinobot/wiki/Contact inform him]? (reference "
				+ marker + ")";
	}

	@Override
	public String externalException(String marker) {
		return "WHAT ARE YOU DOING FILTHY MONGREL PEPPY, FIX THE SERVERS"
				+ " don't panic ya filthy gronk, go get ur goonsack mate. try again later"
				+ " if ur running around like a headless chook, you can [https://github.com/Tillerino/Tillerinobot/wiki/Contact tell him] about it. (reference "
				+ marker + ")";
	}

	@Override
	public String noInformationForModsShort() {
		return "no data for requested mods";
	}

	@Override
	public void welcomeUser(IRCBotUser user, OsuApiUser apiUser, long inactiveTime) {
		if(inactiveTime < 60 * 1000) {
			user.message("beep boop");
		} else if(inactiveTime < 24 * 60 * 60 * 1000) {
			user.message("G'day mate, " + apiUser.getUserName() + ".");
		} else if(inactiveTime > 7l * 24 * 60 * 60 * 1000) {
			user.message(apiUser.getUserName() + "...");
			user.message("it's been so long you bloody wanker");
			user.message("your back? Good. Want me to fill ur eskie with a six pack of pp maps?");
		} else {
			String[] messages = {
					"you want some recommendations to fix ur farming?.",
					"nice to meet ya",
					"ur my favourite cunt(don't tell the others)",
					"that's fucking sick ayy cunt",
					"been waitin for ya m8, all those other cunts are a bunch of soft cocks, tell them and ill bash ya fucken head but ay",
			};
			
			Random random = new Random();
			
			String message = messages[random.nextInt(messages.length)];
			
			user.message(apiUser.getUserName() + ", " + message);
		}
	}

	@Override
	public String unknownCommand(String command) {
		return "unknown command \"" + command
				+ "\". Type !help if you need help!";
	}

	@Override
	public String noInformationForMods() {
		return "oi cunt I cant provide shit to ya atm";
	}

	@Override
	public String malformattedMods(String mods) {
		return "pick the right mods ya gronk. DT HR HD HT EZ NC FL SO NF. Combine them without any spaces or special chars. Example: !with HDHR, !with DTEZ";
	}

	@Override
	public String noLastSongInfo() {
		return "Song info? What the fuck mate";
	}

	@Override
	public String tryWithMods() {
		return "Put some mods on ya yank";
	}

	@Override
	public String tryWithMods(List<Mods> mods) {
		return "Try this map with " + Mods.toShortNamesContinuous(mods);
	}

	/**
	 * The user's IRC nick name could not be resolved to an osu user id. The
	 * message should suggest to contact @Tillerinobot or /u/Tillerino.
	 * 
	 * @param exceptionMarker
	 *            a marker to reference the created log entry. six or eight
	 *            characters.
	 * @param name
	 *            the irc nick which could not be resolved
	 * @return
	 */
	public String unresolvableName(String exceptionMarker, String name) {
		return "Where's ur name you spearchucker, you banned or some crap? If not >[https://github.com/Tillerino/Tillerinobot/wiki/Contact contact Tillerino]. (reference "
				+ exceptionMarker + ")";
	}

	@Override
	public String excuseForError() {
		return "sorry cunt had a goon bag on the clothesline, whatcha want again m8?";
	}

	@Override
	public String complaint() {
		return "Thanks for ya complaint mate, now go farm some trash 10.3 maps";
	}

	@Override
	public void hug(final IRCBotUser user, OsuApiUser apiUser) {
		user.message("Come here ya wanker!");
		user.action("hugs " + apiUser.getUserName());
	}

	@Override
	public String help() {
		return "G'day mate, I'm the bloody dingo who ate your Tillerino Baby. Nah I'm messing with ya you mug"
				+ " [https://twitter.com/Tillerinobot status and updates]"
				+ " - [https://github.com/Tillerino/Tillerinobot/wiki commands]"
				+ " - [http://ppaddict.tillerino.org/ ppaddict]"
				+ " - [https://github.com/Tillerino/Tillerinobot/wiki/Contact contact]";
	}

	@Override
	public String faq() {
		return "[https://github.com/Tillerino/Tillerinobot/wiki/FAQ Frequently asked questions]";
	}
	
	@Override
	public String featureRankRestricted(String feature, int minRank, OsuApiUser user) {
		return "Sorry, at this point " + feature + " is only available for players who have surpassed rank " + minRank + ".";
	}
	
	@Override
	public String mixedNomodAndMods() {
		return "What do you mean nomod with mods?";
	}
	
	@Override
	public String outOfRecommendations() {
		return "You run me dry on bloody beatmaps you prick."
				+ "Try other recommendation options or use !reset. If ur a downer, use !help";
	}

	@Override
	public String notRanked() {
		return "This beatmap ain't ranked mate";
	}

	@Override
	public void optionalCommentOnNP(IRCBotUser user,
			OsuApiUser apiUser, BeatmapMeta meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public void optionalCommentOnWith(IRCBotUser user, OsuApiUser apiUser,
			BeatmapMeta meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public void optionalCommentOnRecommendation(IRCBotUser user,
			OsuApiUser apiUser, Recommendation meta) {
		// regular Tillerino doesn't comment on this
	}
	
	@Override
	public boolean isChanged() {
		return false;
	}

	@Override
	public void setChanged(boolean changed) {
		
	}

	@Override
	public String invalidAccuracy(String acc) {
		return "Invalid accuracy: \"" + acc + "\"";
	}

	@Override
	public void optionalCommentOnLanguage(IRCBotUser user, OsuApiUser apiUser) {
		user.message("So you like me just the way I am :)");
	}

	@Override
	public String invalidChoice(String invalid, String choices) {
		return "I'm sorry, but \"" + invalid
				+ "\" does not compute. Try these: " + choices + "!";
	}

	@Override
	public String setFormat() {
		return "The syntax to set a parameter is !set option value. Try !help if you need more pointers.";
	}
}
