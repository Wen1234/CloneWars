import java.io.IOException;

public class BountyHunters extends Character implements WithoutForce {
	private static BountyHunters instance = new BountyHunters();
	
	private BountyHunters () {
		this.setHp(100);
		this.setDef(100);
		this.setPower(100);
		this.setForce(0);
		this.setIntelligence(350);
		this.setLvl(1);
	}
	
	protected static BountyHunters getInstance() throws IOException {
		Class<?> callerClass = null;
		try {
			callerClass = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		if(!callerClass.isAssignableFrom(instance.getClass()))
		{
			throw new IOException("Vous ne pouvez pas appeler cette fonction depuis cette Class");
		}
        return instance;
    }

	public void armedAttack(Character enemy) {
		double deg;
		deg = (this.getIntelligence() - enemy.getDef()*0.01)*BonusDamage();
		if(deg > 0)
			enemy.setHp(enemy.getHp() - deg);
		else
			deg = 0;
		System.out.println(this.getName()+" inflige "+deg+" d�gats.");
	}
}