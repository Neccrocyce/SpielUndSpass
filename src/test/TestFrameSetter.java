package test;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import layout.MainFrame;

public class TestFrameSetter {
	private static MainFrame mf;
	
	@BeforeClass
	public static void init () {
		TestFrameStarter.start();		
		while (MainFrame.getInstance() == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		mf = MainFrame.getInstance();
	}

	@Test
	public void test() {
		try {
			sleep(1000);
			//gameText
			mf.setGameTitel("Das Problem will ich nicht, zeig mir das Nächste!");
			sleep(1000);
			mf.setGameText("Der älteste Witz der Welt und der Humor der Antike\nBritische Wissenschaftler der Universität Wolverhampton fanden einen Witz, der ca. 4000 Jahre alt sein soll und der deutlich zeigt, dass damals über Dinge gelacht wurde, die man heute nicht mehr richtig nachvollziehen kann. In Mesopotamien gab es den Spruch: Was ist noch nie geschehen? Es ist noch nie passiert, dass eine Frau auf dem Schoß eines Mannes sitzt und nicht pupst.\nDie Witze der alten Römer und Griechen bringen uns heute da schon eher zum Lachen. In der Odyssee sagt Odysseus zu einem Zyklopen, dass er Niemand heißt. Als der Zyklop um Hilfe ruft, schreit er deshalb: Niemand greift mich an. Bekannt sind auch die humoristischen Schriften von Äsop, der ca. 600 vor Christi lebte. Er war eigentlich Sklave, machte aber dank seines klugen Witzes Karriere und wurde am Ende ein freier Mann. Aber auch damals gab es mit Humor die gleichen Probleme wie heute: Lustige Sätze und Bemerkungen können von den falschen Leuten ganz verkehrt aufgefasst und deshalb missverstanden werden. Äsops Leben endete deshalb tragisch. In Delphi empfand man seinen Humor als Gotteslästerung, die Priester ermordeten ihn.\nVon den alten Römern ist uns zum Glück eine Vielzahl an lustigen Sprüchen erhalten geblieben. An einer Hauswand in Pompeji hatte ein Mann z.B. folgenden Spruch eingeritzt: Da veniam ut veniam (Verzeihe mir, damit ich kommen kann). Und Cicero stellte folgende Frage: Was ist das für ein Mensch, der sich beim Ehebruch erwischen lässt? Antwort: Ein Langsamer.\nFast hat man das Gefühl, dass die alten Römer die Art von Humor, wie wir ihn heute kennen, erfunden haben. Das Wort Humor stammt jedenfalls aus dem lateinischen und bedeutet direkt übersetzt Feuchtigkeit oder Körpersäfte. Es entstammt der antiken Säfte-Lehre, die die Menschen in Choleriker, Melancholiker, Phlegmatiker und Sanguiniker einteilte. Wenn die Säfte in Ordnung waren, dann war der Mensch ausgeglichen. Wenn man lachen konnte, dann hatte man einen guten Humor – einen guten Säfte-Haushalt.");
			sleep(1000);
			mf.setGameTitel("Was sagen Sie als Unbeteiligter eigentlich zum Thema Intelligenz?");
			sleep(1000);
			mf.setGameTitel("Titel");
			
			//gameTimer
			for (int i = 0; i < 2; i++) {
				for (int j = 3; j <= 5; j++) {
					for (int k = 0; k < 20; k++) {
						mf.setTimer(i, (j%4) * (j%3) / 2 * k, (j%5) * (j%3) / 4 * k, (j%4) * (j%5) / 9 * k);
						sleep(250);
					}
				}
			}
					
			for (int i = 0; i < 2; i++) {
				//teamName
				mf.setTeamName(i, "Das Team");
				sleep(500);
				mf.setTeamName(i, "Gruppe\n15");
				sleep(500);
				
				//teamScore
				for (int j = 0; j < 20; j++) {
					mf.setTeamScore(i, (int) Math.pow(Math.E, j));
					sleep(250);
				}
				
				//teamVicPoints
				for (int j = 0; j < 12; j++) {
					mf.setVicPoints(i, j*j);
					sleep(500);
				}
				//player
				for (int j = 0; j < 4; j++) {
					//playerName
					mf.setPlayerName(i, j, "" + ((char) (j + 90)));
					sleep(500);
					mf.setPlayerName(i, j, "Abcdef");
					sleep(500);
					
					//playerScore
					for (int k = 0; k < 20; k++) {
						mf.setPlayerScore(i, j,(int) Math.pow(2, k));
						sleep(100);
					}
					
					//playerText
					mf.setPlayerText(i, j, "Das Wort „Vegetarier“ kommt aus dem Sanskrit und bedeutet “zu blöd zum Jagen“.");
					sleep(500);
					mf.setPlayerText(i, j, "Da lernt man Dreisatz und Wahrscheinlichkeitsrechnung und steht trotzdem grübelnd vor dem Backofen, welche der vier Schienen nun die Mittlere ist.");
					sleep(500);
				}
			}
			
			sleep(30000);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	private void sleep (long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
