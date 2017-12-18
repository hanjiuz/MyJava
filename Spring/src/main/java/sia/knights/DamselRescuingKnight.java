package sia.knights;

public class DamselRescuingKnight implements Knight {

  private RescueDamselQuest quest;

  public DamselRescuingKnight() {
    this.quest = new RescueDamselQuest();
  }

  public void embarkOnQuest() {
	  System.out.println("DamselRescuingKnight is embarkOnQuest...");    
    quest.embark();
  }

}
